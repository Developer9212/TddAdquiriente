package com.fenoreste_alestra.controller;

import com.fenoreste_alestra.service.TddGeneralService;
import com.fenoreste_alestra.ws_client_tdd.*;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fenoreste_alestra.ws_client_tddImpl.Exception;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
@Slf4j
public class AccountController {

    @Autowired
    private TddGeneralService tddGeneralService;

    @RequestMapping(value = "/activateCard/idtarjeta={idcard}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivateCardResponse activarTarjeta(HttpServletRequest request, @PathVariable String idcard) throws Exception {
        return tddGeneralService.activateCard(request, idcard);
    }

    @RequestMapping(value = "/getBalanceQuery/idtarjeta={idcard}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BalanceQueryResponseDto obtenerSaldo(@PathVariable String idcard, HttpServletRequest request) {
        return tddGeneralService.balanceQueryResponseDto(idcard, request);// service.getBalance(idcard);
    }

    @RequestMapping(value = "/loadBalance/idtarjeta={idcard}&monto={amount}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public LoadBalanceResponse depositarSaldoTarjeta(@PathVariable String idcard, HttpServletRequest request, @PathVariable String amount) throws NumberFormatException, Exception {
        return tddGeneralService.deposito(idcard, request, amount);
    }

    @RequestMapping(value = "/doWithDrawal/idtarjeta={idcard}&monto={amount}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.DoWithdrawalAccountResponse retirarSaldoTarjeta(@PathVariable String idcard, HttpServletRequest request, @PathVariable String amount) {
        return tddGeneralService.retiro(idcard, request, amount);
    }

    @RequestMapping(value = "/asignaNip/idtarjeta={idcard}&nip={passnip}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AsignaNIPResponse assignaNipTarjeta(@PathVariable String idcard, HttpServletRequest request, @PathVariable String passnip) {
        return tddGeneralService.asignaNIPResponse(idcard, request, passnip);
    }

    @RequestMapping(value = "/assignamentAccount/idtarjeta={pan}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AssignmentAccountResponse asignarCuenta(@PathVariable String pan, @RequestBody AssignamentAccountDto info, HttpServletRequest request) {
        System.out.println("Peticion asignar cuenta:::::::::::::::::::::"+info);
        return tddGeneralService.assignmentAccountResponse(pan, request, info);
    }

    @RequestMapping(value = "/lastestsTransactions/idtarjeta={idcard}&totalMov={nmov}&tipoMov={tmov}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.GetLastestTransactionsResponse verMovimientosTarjeta(@PathVariable String idcard, @PathVariable int nmov, @PathVariable int tmov, HttpServletRequest request) {
        return tddGeneralService.getLastestTransactionsResponse(idcard, nmov, tmov, request);
    }

    @RequestMapping(value = "/temporaryLock/idtarjeta={idcard}&mov={accion}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TemporaryLockResponse bloquearTarjetaTemporal(@PathVariable String idcard, @PathVariable int accion, HttpServletRequest request) throws Exception {
        return tddGeneralService.getTemporaryLockResponse(idcard, accion, request);
    }

    @RequestMapping(value = "/cardLock/idtarjeta={idcard}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CardLockResponse bloquearTarjeta(@PathVariable String idcard, HttpServletRequest request) throws Exception {
        return tddGeneralService.getCardLockResponse(idcard, request);
    }


    @RequestMapping(value = "/cardHolderInformation/idtarjeta={idcard}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CardHolderInformationResponse informacionTarjeta(@PathVariable String idcard, HttpServletRequest request) throws Exception {
        return tddGeneralService.getCardHolderInformationResponse(idcard, request);
    }


    @RequestMapping(value = "/deleteIndividualLimit/idtarjeta={idcard}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.DeleteIndividualLimitsResponse eliminarLimiteTarjeta(@PathVariable String idcard, HttpServletRequest request) throws Exception {
        return tddGeneralService.deleteIndividualLimitsResponse(idcard, request);
    }

    @RequestMapping(value = "/updateIndividualLimit/idtarjeta={idcard}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.UpdateIndividualLimitsResponse modificarLimiteTarjeta(@PathVariable("idcard") String idcard, @RequestBody IndividualLimitsDto model, HttpServletRequest request) throws Exception {
        return tddGeneralService.updateIndividualLimitsResponse(idcard, model, request);
    }

    @RequestMapping(value="/updateDemographicData/idtarjeta={idcard}", method =RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UpdateDemographicDataResponse modificarDatosDemograficos(@PathVariable String idcard,@RequestBody CardInfo data,HttpServletRequest request) throws Exception {
        return tddGeneralService.getUpdateDemographicDataResponse(idcard,data,request);
    }


    @RequestMapping(value="/stockCardReplacement/idtarjeta={nuevatarjeta}&reemplazar={tarjetaareemplazar}", method =RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.StockCardReplacementResponse reemplazarTarjeta(@PathVariable String nuevatarjeta,@PathVariable String tarjetaareemplazar,HttpServletRequest request) throws Exception {
      return tddGeneralService.getStockCardReplacementResponse(nuevatarjeta, tarjetaareemplazar, request);
    }

    @RequestMapping(value="/saveInformationClient", method =RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.fenoreste_alestra.ws_client_tdd.SaveInformationClientBitMatchResponse guardarInformacionCliente(@RequestBody InfoClientRequest info,HttpServletRequest request) {
        return tddGeneralService.getSaveInformationClientBitMatchResponse(info,request);
    }
    /*


    

    

    
    

    


    


    

    

    

    

    
  */
    //holaaassssssssssswwwssssdsdfdgdfgdfsfdsssdasdsssasss
}
