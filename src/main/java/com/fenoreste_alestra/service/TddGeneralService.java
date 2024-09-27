package com.fenoreste_alestra.service;

import com.fenoreste_alestra.entity.*;
import com.fenoreste_alestra.ws_client_tdd.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.Exception;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TddGeneralService {

    @Autowired
    private AccountServiceAlestra accountServiceAlestra;

    @Autowired
    private ISaldoService saldoService;

    @Autowired
    private IActivacionService activacionService;

    @Autowired
    private IDepositoService depositoService;

    @Autowired
    private IRetiroService retiroService;

    @Autowired
    private INipService nipService;

    @Autowired
    private IAsignacionService asignacionService;

    @Autowired
    private ITransaccionDTOService transaccionDTOService;

    @Autowired
    private ITransaccionService transaccionService;

    @Autowired
    private IBloqueoTemporalService bloqueoTemporalService;

    @Autowired
    private IBloqueoService bloqueoService;

    @Autowired
    private IInformacionService informacionService;

    @Autowired
    private IEliminarLimiteService eliminarLimiteService;

    @Autowired
    private IModificarLimiteService modificarLimiteService;

    @Autowired
    private IDemograficoService demograficoService;

    @Autowired
    private IReemplazoService reemplazoService;

    @Autowired
    private IBistInformacionService bistInformacionService;


    public ActivateCardResponse activateCard(HttpServletRequest request,String idCard) {
        ActivateCardResponse activateCardResponse = null;
        try {

            //Nos aseguramos que la tarjeta que estamos activando este asignada
            Asignacion asignacion = asignacionService.buscarPorTarjeta(idCard);
            Activacion activacion = new Activacion();
            activacion.setFecha(new Date());
            activacion.setPeticion(request.getRequestURI());
            activacion.setTarjeta(idCard);
            activacion.setDescripcion("Conexion invalida hacia proveedor TDD");
            activacion.setCorrecta(false);
            if(asignacion != null) {
                activateCardResponse = accountServiceAlestra.activeCard(idCard);
                log.info("Active Card Response:"+activateCardResponse);
                if(activateCardResponse != null){
                    if(activateCardResponse.getCode() == 1){
                        activacion.setCodigo(activateCardResponse.getCode());
                        activacion.setDescripcion(activateCardResponse.getDescription());
                        activacion.setAutorizacion(activateCardResponse.getAuthorization());
                        activacion.setCorrecta(true);
                    }else{
                        activacion.setCodigo(activateCardResponse.getCode());
                        activacion.setDescripcion(activateCardResponse.getDescription());
                        activacion.setAutorizacion(activateCardResponse.getAuthorization());
                        activacion.setCorrecta(false);
                    }
                }
            }else{
                activacion.setDescripcion("Tarjeta aun no esta asignada");
                activacion.setCodigo(0);
            }
            activacionService.guardarActive(activacion);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error Activacion: " + e.getMessage());
        }
        return activateCardResponse;
    }

    public BalanceQueryResponseDto balanceQueryResponseDto(String idTarjeta, HttpServletRequest req){
        BalanceQueryResponseDto balanceQueryResponseDto =  null;
        try {

            balanceQueryResponseDto = accountServiceAlestra.getBalance(idTarjeta);
            log.info("Response consulta saldo:+"+balanceQueryResponseDto);
            Saldo saldo = new Saldo();
            saldo.setPeticion(req.getRequestURI());
            saldo.setFecha(new Date());
            saldo.setCorrecta(false);
            saldo.setTarjeta(idTarjeta);
            saldo.setDescripcion("Conexion invalida hacia proveedor TDD");
            if(balanceQueryResponseDto !=null){
                if(balanceQueryResponseDto.getCode() == 1){
                    saldo.setCodigo(balanceQueryResponseDto.getCode());
                    saldo.setDescripcion(balanceQueryResponseDto.getDescription());
                    saldo.setCorrecta(true);
                    saldo.setSaldo(balanceQueryResponseDto.getAvailableAmount());
                }else{
                    saldo.setCodigo(balanceQueryResponseDto.getCode());
                    saldo.setDescripcion(balanceQueryResponseDto.getDescription());
                    saldo.setCorrecta(false);
                    saldo.setSaldo(balanceQueryResponseDto.getAvailableAmount());
                }
            }
            saldoService.guardarSaldo(saldo);
        }catch (Exception e){
            log.error("Error al buscar saldo:"+e.getMessage());
        }
        return balanceQueryResponseDto;
    }

    public LoadBalanceResponse deposito(String idTarjeta, HttpServletRequest req,String amount){
        LoadBalanceResponse loadBalanceResponse = null;
        Deposito deposito = new Deposito();
        try{
           
            deposito.setFecha(new Date());
            deposito.setPeticion(req.getRequestURI());
            deposito.setDescripcion("Conexion invalida hacia proveedor TDD");
            deposito.setCorrecto(false);
            deposito.setTarjeta(idTarjeta);
            loadBalanceResponse = accountServiceAlestra.loadBalance(idTarjeta,amount);

            log.info("Respuesta Deposito:"+loadBalanceResponse);
            if(loadBalanceResponse != null){
                if(loadBalanceResponse.getCode() == 1){
                   deposito.setCodigo(loadBalanceResponse.getCode());
                   deposito.setDescripcion(loadBalanceResponse.getDescription());
                   deposito.setAutorizacion(loadBalanceResponse.getAuthorization());
                   deposito.setCorrecto(true);
                   deposito.setSaldo_antes_abono(loadBalanceResponse.getBalance());
                   deposito.setSaldo_despues_abono(loadBalanceResponse.getCurrentBalance());
                }else{
                    deposito.setCodigo(loadBalanceResponse.getCode());
                    deposito.setDescripcion(loadBalanceResponse.getDescription());
                    deposito.setAutorizacion(loadBalanceResponse.getAuthorization());
                    deposito.setCorrecto(true);
                    deposito.setSaldo_antes_abono(loadBalanceResponse.getBalance());
                    deposito.setSaldo_despues_abono(loadBalanceResponse.getCurrentBalance());
                }
            }
        }catch(Exception e){
            log.error("Error al realizar deposito:"+e.getMessage());
        }
        depositoService.guardarDeposito(deposito);
        return loadBalanceResponse;
    }

    public DoWithdrawalAccountResponse retiro(String idTarjeta, HttpServletRequest req, String amount){
        DoWithdrawalAccountResponse doWithdrawalAccountResponse = null;
        Retiro retiro = new Retiro();
        try{
            retiro.setFecha(new Date());
            retiro.setPeticion(req.getRequestURI());
            retiro.setDescripcion("Conexion invalida hacia proveedor TDD");
            retiro.setCorrecto(false);
            retiro.setTarjeta(idTarjeta);
            doWithdrawalAccountResponse = accountServiceAlestra.doWithDrawal(idTarjeta,amount);
            log.info("Respuesta Retiro:"+doWithdrawalAccountResponse);
            if(doWithdrawalAccountResponse != null){
                    retiro.setCodigo(doWithdrawalAccountResponse.getCode());
                    retiro.setDescripcion(doWithdrawalAccountResponse.getDescription());
                    retiro.setAutorizacion(doWithdrawalAccountResponse.getAuthorization());
                    retiro.setCorrecto(true);
                    retiro.setSaldo_antes_retiro(doWithdrawalAccountResponse.getBalance());
                    retiro.setSaldo_despues_retiro(doWithdrawalAccountResponse.getCurrentBalance());
            }
        }catch(Exception e){
            log.error("Error al realizar deposito:"+e.getMessage());
        }
        retiroService.guardarRetiro(retiro);
        return doWithdrawalAccountResponse;
    }

    public AsignaNIPResponse asignaNIPResponse(String idTarjeta, HttpServletRequest req, String nip){
        AsignaNIPResponse asignaNIPResponse = null;
        Nip nipRegistro = new Nip();
        try{
            nipRegistro.setFecha(new Date());
            nipRegistro.setPeticion(req.getRequestURI());
            nipRegistro.setDescripcion("Conexion invalida hacia proveedor TDD");
            nipRegistro.setCorrecto(false);
            nipRegistro.setTarjeta(idTarjeta);
            asignaNIPResponse = accountServiceAlestra.asignaNip(idTarjeta,nip);

            log.info("Respuesta Asigna Nip:"+asignaNIPResponse);
            if(asignaNIPResponse != null){
                nipRegistro.setCodigo(asignaNIPResponse.getCodigo());
                nipRegistro.setDescripcion(asignaNIPResponse.getDescripcion());
                nipRegistro.setCorrecto(true);
            }
        }catch(Exception e){
            log.error("Error al realizar deposito:"+e.getMessage());
        }
        nipService.guardarNip(nipRegistro);
        return asignaNIPResponse;
    }

    public AssignmentAccountResponse assignmentAccountResponse(String idTarjeta, HttpServletRequest req,AssignamentAccountDto assignmentAccount){
        AssignmentAccountResponse assignmentAccountResponse = null;
        Asignacion asignacion = new Asignacion();
        try{

            /*String normalized = Normalizer.normalize(assignmentAccount.getNombreCorto(), Normalizer.Form.NFD);
            String reemplazo = normalized.replaceAll(", "");
            assignmentAccount.setNombreCorto(reemplazo);
            normalized = Normalizer.normalize(assignmentAccount.getNombreLargo(), Normalizer.Form.NFD);
            reemplazo = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            assignmentAccount.setNombreLargo(reemplazo);
            normalized = Normalizer.normalize(assignmentAccount.getDireccion(), Normalizer.Form.NFD);
            reemplazo = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            assignmentAccount.setDireccion(reemplazo);
            normalized = Normalizer.normalize(assignmentAccount.getColonia(), Normalizer.Form.NFD);
            reemplazo = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            assignmentAccount.setColonia(reemplazo);
            normalized = Normalizer.normalize(assignmentAccount.getEntidadFederativa(), Normalizer.Form.NFD);
            reemplazo = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            assignmentAccount.setEntidadFederativa(reemplazo);*/

            asignacion.setFecha(new Date());
            asignacion.setPeticion(req.getRequestURI());
            asignacion.setDescripcion("Conexion invalida hacia proveedor TDD");
            asignacion.setCorrecto(false);
            asignacion.setTarjeta(idTarjeta);

            assignmentAccountResponse = accountServiceAlestra.assignamentAccount(idTarjeta,assignmentAccount);
            /*assignmentAccountResponse = new AssignmentAccountResponse();
            assignmentAccountResponse.setCode(1);
            assignmentAccountResponse.setDescription("Exitosa");
            assignmentAccountResponse.setCLABE("456546456456546");*/
            log.info("Resultado asignacion cuenta:"+assignmentAccountResponse);
            if(assignmentAccountResponse != null){

                String[] arrayError = {"3","4","10","11","12","14","15","17"};
                for(int i=0;i<arrayError.length;i++){
                    int errorCode = Integer.parseInt(arrayError[i]);
                    if(assignmentAccountResponse.getCode() == errorCode){
                        asignacion.setCodigo(assignmentAccountResponse.getCode());
                        asignacion.setDescripcion(assignmentAccountResponse.getDescription());
                        break;
                    }else{
                        asignacion.setCodigo(assignmentAccountResponse.getCode());
                        if(assignmentAccountResponse.getCode() != 1){
                            asignacion.setDescripcion("Advertencia:"+assignmentAccountResponse.getDescription() + ",code:"+assignmentAccountResponse.getCode());
                        }else{
                            asignacion.setDescripcion(assignmentAccountResponse.getDescription());
                        }

                    }
                }
                asignacion.setCorrecto(true);
                asignacion.setFechamovimiento(assignmentAccountResponse.getIssueDate());
                asignacion.setHoramovimiento(assignmentAccountResponse.getCurrentTime());
                asignacion.setNombrecliente(assignmentAccountResponse.getClientName());
                asignacion.setNumerocliente(assignmentAccountResponse.getNoCliente());
                asignacion.setClabeinterbancaria(assignmentAccountResponse.getNoCuenta());
                asignacion.setAutorizacion(assignmentAccountResponse.getAuthorization());
            }
        }catch (Exception e){
            log.error("Error al realizar asignacion:"+e.getMessage());
        }

        asignacionService.guardarAsignacion(asignacion);
        return assignmentAccountResponse;
    }

    public GetLastestTransactionsResponse getLastestTransactionsResponse(String idTarjeta,int tmovs,int tipomov,HttpServletRequest req){
        GetLastestTransactionsResponse getLastestTransactionsResponse = null;
        Transaccion transaccion = new Transaccion();
        try{
            //transaccion.setIdoperacionsaicoop(transaccionService.valorProximo());
            transaccion.setFecha(new Date());
            transaccion.setPeticion(req.getRequestURI());
            transaccion.setDescripcion("Conexion invalida hacia proveedor TDD");
            transaccion.setCorrecto(false);
            transaccion.setTarjeta(idTarjeta);

            GetLastestTransactionsResponse tr = new GetLastestTransactionsResponse();

            tr.setCode(1);
            tr.setDescription("Conexion invalida hacia proveedor TDD");

            TransactionDto trDto = new TransactionDto();
            trDto.setPan(idTarjeta);
            trDto.setAmount("345");
            trDto.setAcceptorName("Wilmer");
            trDto.setAuthorization("456");
            trDto.setAvailableBalance("90");
            tr.getLastestTransactions().add(trDto);

            getLastestTransactionsResponse =   accountServiceAlestra.lastTransaction(idTarjeta,tmovs,tmovs);
            log.info("Resultado busqueda operaciones a tdd:"+getLastestTransactionsResponse);
            if(getLastestTransactionsResponse != null){
                transaccion.setCodigo(getLastestTransactionsResponse.getCode());
                transaccion.setDescripcion(getLastestTransactionsResponse.getDescription());
                transaccion.setCorrecto(true);
                transaccion.setNoperaciones(getLastestTransactionsResponse.getLastestTransactions().size());

                transaccionService.guardarTransaccion(transaccion);

                log.info("Numero de transaccion:"+transaccion.getIdoperacionsaicoop());
                for(int i=0;i<getLastestTransactionsResponse.getLastestTransactions().size();i++){
                    TransaccionDTO transaccionDTO = new TransaccionDTO();
                    transaccionDTO.setIdoperacionsaicoop(transaccion.getIdoperacionsaicoop());
                    transaccionDTO.setTarjeta(getLastestTransactionsResponse.getLastestTransactions().get(i).getPan());
                    transaccionDTO.setTipotransaccion(getLastestTransactionsResponse.getLastestTransactions().get(i).getTrxDescription());
                    transaccionDTO.setMonto(new Double(getLastestTransactionsResponse.getLastestTransactions().get(i).getAmount()));
                    transaccionDTO.setCodigo(getLastestTransactionsResponse.getLastestTransactions().get(i).getTrxCode());
                    transaccionDTO.setDescripcion(getLastestTransactionsResponse.getLastestTransactions().get(i).getConceptDescription());
                    transaccionDTO.setFecha(getLastestTransactionsResponse.getLastestTransactions().get(i).getTransactionDate());
                    transaccionDTO.setAutorizacion(getLastestTransactionsResponse.getLastestTransactions().get(i).getAuthorization());
                    transaccionDTO.setSaldodisponible(new Double(getLastestTransactionsResponse.getLastestTransactions().get(i).getAvailableBalance()));
                    transaccionDTOService.guardarTransaccionDTO(transaccionDTO);

                }

            }


        }catch (Exception e){
            log.error("Error al realizar busqueda operaciones:"+e.getMessage());
        }
        return getLastestTransactionsResponse;
    }

    public DeleteIndividualLimitsResponse deleteIndividualLimitsResponse(String idTarjeta,HttpServletRequest request){
        DeleteIndividualLimitsResponse deleteIndividualLimitsResponse = null;
        EliminarLimite eliminarLimite = new EliminarLimite();
        try{
           eliminarLimite.setFecha(new Date());
           eliminarLimite.setTarjeta(idTarjeta);
           eliminarLimite.setDescripcion("Conexion invalida hacia proveedor TDD");
           eliminarLimite.setCorrecto(false);

           deleteIndividualLimitsResponse = accountServiceAlestra.deleteIndividualLimit(idTarjeta);
           log.info("Response eliminar Limite Individuales:"+deleteIndividualLimitsResponse);
           if(deleteIndividualLimitsResponse != null){
               eliminarLimite.setCodigo(deleteIndividualLimitsResponse.getCode());
               eliminarLimite.setDescripcion(deleteIndividualLimitsResponse.getDescription());
               eliminarLimite.setAutorizacion(deleteIndividualLimitsResponse.getAuthorization());
               eliminarLimite.setCorrecto(true);
           }
           eliminarLimiteService.guardarLimite(eliminarLimite);
        }catch(Exception e){
            log.error("Error al eliminar limite TDD:"+e.getMessage());
        }
        return deleteIndividualLimitsResponse;
    }

    public UpdateIndividualLimitsResponse updateIndividualLimitsResponse(String idTarjeta,IndividualLimitsDto limitsModel,HttpServletRequest request){
        UpdateIndividualLimitsResponse updateIndividualLimitsResponse = null;
        ModificarLimite modificarLimite = new ModificarLimite();
        try{
            modificarLimite.setFecha(new Date());
            modificarLimite.setTarjeta(idTarjeta);
            modificarLimite.setPeticion(request.getRequestURI());
            modificarLimite.setDescripcion("Conexion invalida hacia proveedor TDD");
            modificarLimite.setCorrecto(false);

            updateIndividualLimitsResponse = accountServiceAlestra.updateIndividualLimit(idTarjeta, limitsModel);
            log.info("Responser modificar limit:"+updateIndividualLimitsResponse);
            if(updateIndividualLimitsResponse != null){
              modificarLimite.setCodigo(updateIndividualLimitsResponse.getCode());
              modificarLimite.setDescripcion(updateIndividualLimitsResponse.getDescription());
              modificarLimite.setAutorizacion(updateIndividualLimitsResponse.getAuthorization());
              modificarLimite.setCorrecto(true);
            }
            modificarLimiteService.guardarLimite(modificarLimite);
        }catch(Exception e){
            log.error("Error al modificar limite TDD:"+e.getMessage());
        }
      return updateIndividualLimitsResponse;
    }

    public TemporaryLockResponse getTemporaryLockResponse(String idTarjeta,int accion,HttpServletRequest request){
        TemporaryLockResponse temporaryLockResponse = null;
        BloqueoTemporal bloqueoTemporal = new BloqueoTemporal();
        try{

            bloqueoTemporal.setFecha(new Date());
            bloqueoTemporal.setTarjeta(idTarjeta);
            bloqueoTemporal.setPeticion(request.getRequestURI());
            bloqueoTemporal.setCorrecta(false);

            temporaryLockResponse = accountServiceAlestra.temporaryLock(idTarjeta,accion);
            System.out.println("Resultado bloqueo temporal a tdd:"+temporaryLockResponse);
            if(temporaryLockResponse != null){
                bloqueoTemporal.setCodigo(temporaryLockResponse.getCode());
                bloqueoTemporal.setDescripcion(temporaryLockResponse.getDescription());
                bloqueoTemporal.setAutorizacion(temporaryLockResponse.getAuthorization());
                bloqueoTemporal.setCorrecta(true);
            }

            bloqueoTemporalService.guardaBloqueoTemporal(bloqueoTemporal);

        }catch(Exception e){
            System.out.println("Error al guardar bloqueo temporal a tdd:"+e.getMessage());
        }
       return temporaryLockResponse;
    }

    public CardLockResponse getCardLockResponse(String idTarjeta,HttpServletRequest request){
        CardLockResponse cardLockResponse = null;
        Bloqueo bloqueo = new Bloqueo();
        try{
          bloqueo.setFecha(new Date());
          bloqueo.setTarjeta(idTarjeta);
          bloqueo.setPeticion(request.getRequestURI());
          bloqueo.setCorrecta(false);

          cardLockResponse = accountServiceAlestra.cardLock(idTarjeta);
          if(cardLockResponse != null){
              bloqueo.setCodigo(cardLockResponse.getCode());
              bloqueo.setDescripcion(cardLockResponse.getDescription());
              bloqueo.setAutorizacion(cardLockResponse.getAuthorization());
              bloqueo.setCorrecta(true);
          }
          bloqueoService.guardarBloqueo(bloqueo);
        }catch(Exception e){
            System.out.println("Error al guardar bloqueo a tdd:"+e.getMessage());
        }
        return cardLockResponse;
    }

    public CardHolderInformationResponse getCardHolderInformationResponse(String idTarjeta,HttpServletRequest request){
        CardHolderInformationResponse cardHolderInformationResponse = null;
        Informacion informacion = new Informacion();
        try{

            informacion.setFecha(new Date());
            informacion.setTarjeta(idTarjeta);
            informacion.setPeticion(request.getRequestURI());
            informacion.setCorrecto(false);

            cardHolderInformationResponse = accountServiceAlestra.cardHolderInformation(idTarjeta);
            System.out.println("Resultado informacion al tdd:"+cardHolderInformationResponse);

            if(cardHolderInformationResponse != null){
                informacion.setTarjetaresponse(cardHolderInformationResponse.getTarjeta());
                informacion.setCodigo(cardHolderInformationResponse.getCode());
                informacion.setDescripcion(cardHolderInformationResponse.getDescription());
                informacion.setNombre(cardHolderInformationResponse.getNombre());
                informacion.setDireccion(cardHolderInformationResponse.getDireccion());
                informacion.setColonia(cardHolderInformationResponse.getColonia());
                informacion.setLocalidad(cardHolderInformationResponse.getLocalidad());
                informacion.setEstado(cardHolderInformationResponse.getEstado());
                informacion.setRfc(cardHolderInformationResponse.getRfc());
                informacion.setCodigopostal(cardHolderInformationResponse.getCp());
                informacion.setTelefono(cardHolderInformationResponse.getTelefono());
                informacion.setCorrecto(true);
            }
            informacionService.guardarInformacion(informacion);
        }catch (Exception e){
            System.out.println("Error al guardar obtener tdd:"+e.getMessage());
        }
        return cardHolderInformationResponse;
    }

    public UpdateDemographicDataResponse getUpdateDemographicDataResponse(String idTarjeta,CardInfo cardInfo,HttpServletRequest request){
        UpdateDemographicDataResponse updateDemographicDataResponse = null;
        Demografico demographic = new Demografico();
        try{
            demographic.setFecha(new Date());
            demographic.setTarjeta(idTarjeta);
            demographic.setPeticion(request.getRequestURI());
            demographic.setDescripcion("Conexion invalida hacia proveedor TDD");
            demographic.setCorrecto(false);
            updateDemographicDataResponse = accountServiceAlestra.updateDemographicData(idTarjeta,cardInfo);
            if(updateDemographicDataResponse != null){
                demographic.setCodigo(updateDemographicDataResponse.getCodigo());
                demographic.setDescripcion(updateDemographicDataResponse.getDescripcion());
                demographic.setCorrecto(true);
            }
            demograficoService.guardaDemografico(demographic);
        }catch (Exception e){
            System.out.println("Error al modificar datos demograficos:"+e.getMessage());
        }
        return updateDemographicDataResponse;
    }

    public StockCardReplacementResponse getStockCardReplacementResponse(String idTarjetaNueva,String TarjetaR,HttpServletRequest request){
        StockCardReplacementResponse stockCardReplacementResponse = null;
        Reemplazo reemplazo = new Reemplazo();
        try{

            reemplazo.setFecha(new Date());
            reemplazo.setTarjeta(TarjetaR);
            reemplazo.setPeticion(request.getRequestURI());
            reemplazo.setDescripcion("Conexion invalida hacia proveedor TDD");
            reemplazo.setCorrecto(false);

            stockCardReplacementResponse = accountServiceAlestra.stockCardReplacement(idTarjetaNueva,TarjetaR);
            log.info("Response Stock Card Replacement:"+stockCardReplacementResponse);
            if(stockCardReplacementResponse != null){
                   reemplazo.setCodigo(stockCardReplacementResponse.getCode());
                   reemplazo.setDescripcion(stockCardReplacementResponse.getDescription());
                   reemplazo.setAutorizacion(stockCardReplacementResponse.getAuthorization());
                   reemplazo.setTarjetanueva(stockCardReplacementResponse.getPan());
                   reemplazo.setCuentaambiente(stockCardReplacementResponse.getCardHolderName());
                   reemplazo.setFechaexpiracion(stockCardReplacementResponse.getExpiryDate());
                   reemplazo.setStatus(stockCardReplacementResponse.getStatus());
                   reemplazo.setTipo(stockCardReplacementResponse.getType());
                   reemplazo.setCorrecto(true);
            }

            reemplazoService.guardarReemplazo(reemplazo);
        }catch (Exception e){
            log.error("Error al modificar datos de reemplazos:"+e.getMessage());
        }
        return stockCardReplacementResponse;
    }

    public SaveInformationClientBitMatchResponse getSaveInformationClientBitMatchResponse(InfoClientRequest infoClientRequest,HttpServletRequest request){
        SaveInformationClientBitMatchResponse saveInformationClientBitMatchResponse = null;
        BitsInformacion bitsInformacion = new BitsInformacion();
        try{
           bitsInformacion.setFecha(new Date());
           bitsInformacion.setTarjeta(infoClientRequest.getCuenta());
           bitsInformacion.setPeticion(request.getRequestURI());
           bitsInformacion.setDescripcion("Conexion invalida hacia proveedor TDD");
           bitsInformacion.setCorrecto(false);

           saveInformationClientBitMatchResponse = accountServiceAlestra.saveInformationClientBitMatch(infoClientRequest);
           if(saveInformationClientBitMatchResponse != null){
               bitsInformacion.setCodigo(saveInformationClientBitMatchResponse.getCode());
               bitsInformacion.setDescripcion(saveInformationClientBitMatchResponse.getDescription());
               bitsInformacion.setAutorizacion(saveInformationClientBitMatchResponse.getAuthorization());
               bitsInformacion.setCorrecto(true);
           }
           bistInformacionService.guardarBitsInformacion(bitsInformacion);
        }catch(Exception e){
            System.out.println("Error al modificar datos de bits informacion:"+e.getMessage());
        }
        return saveInformationClientBitMatchResponse;
    }


}
