package com.fenoreste_alestra.service;


import com.fenoreste_alestra.ws_client_tdd.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fenoreste_alestra.ws_client_tddImpl.Exception;
import com.fenoreste_alestra.ws_client_tddImpl.SiscoopAlternativeEndpoint;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccountServiceAlestra {
	
	@Autowired
    private SiscoopAlternativeEndpoint clienteWS;
     
    public BalanceQueryResponseDto getBalance(String idcard) {
    	BalanceQueryResponseDto saldoAlestra = clienteWS.getBalanceQuery(idcard);
		System.out.println("Saldo Alestra: " + saldoAlestra);
    	return saldoAlestra;
    }
    
    public CardLockResponse cardLock(String idcard) throws Exception {
    	return clienteWS.cardLock(idcard);
    }
    
    public TemporaryLockResponse temporaryLock(String idcard,int accion) throws Exception {
    	return clienteWS.temporaryLock(idcard, accion);
    }
    
    public LoadBalanceResponse loadBalance(String idcard,String amount) throws NumberFormatException, Exception {
    	return clienteWS.loadBalance(idcard,amount);
    }

    public UpdateDemographicDataResponse updateDemographicData(String pan,CardInfo data) {
    	return clienteWS.updateDemographicData(pan,data);
    }
      
    
    public GetLastestTransactionsResponse lastTransaction(String idcard,int totMovs,int tipoMovs) {
    	return clienteWS.getLastestTransactions(idcard, totMovs, tipoMovs);
    }
    
    public StockCardReplacementResponse stockCardReplacement(String idcard,String cardReplacement){
    	return clienteWS.stockCardReplacement(idcard, cardReplacement);
    }
    
    public AsignaNIPResponse asignaNip(String idCard,String nip) {
    	NipRequest req = new NipRequest();
    	req.setNumeroTarjeta(idCard);
    	req.setNip(nip);
    	
    	return clienteWS.asignaNIP(req);
    }
    
    public CardHolderInformationResponse cardHolderInformation(String idcard) {
    	CardHolderInformationResponse information = clienteWS.getCardholderInformation(idcard);
    	if(information != null) {
    		if(information.getNombre() != null) {
    			information.setNombre(information.getNombre().trim());	
    		}if(information.getColonia()!= null) {
    			information.setColonia(information.getColonia().trim());	
    		}if(information.getCp() != null) {
    			information.setCp(information.getCp().trim());	
    		}if(information.getDescription() != null) {
    			information.setDescription(information.getDescription().trim());	
    		}if(information.getDireccion() != null) {
    			information.setDireccion(information.getDireccion().trim());	
    		}if(information.getLocalidad() != null) {
    			information.setLocalidad(information.getLocalidad().trim());	
    		}if(information.getRfc() != null) {
    			information.setRfc(information.getRfc().trim());
    		}if(information.getTarjeta() != null) {
    			information.setTarjeta(information.getTarjeta().trim());
    		}if(information.getTelefono() != null) {
    			information.setTelefono(information.getTelefono().trim());	
    		}  		
    		
    	}
    	return information;
    }
    
    public AssignmentAccountResponse assignamentAccount(String pan, AssignamentAccountDto assignmentAccount) {
    	return clienteWS.assignmentAccount(pan,assignmentAccount);
    	
    }
    
    public ActivateCardResponse activeCard(String idcard){
		return clienteWS.activateCard(idcard);
    	
    }
    
    public DoWithdrawalAccountResponse doWithDrawal(String idcard,String amount) {
    	return clienteWS.doWithdrawalAccount(idcard, amount);
    }
    
    public DeleteIndividualLimitsResponse deleteIndividualLimit(String idcard) {
    	return clienteWS.deleteIndividualLimits(idcard);
    }
    
    public UpdateIndividualLimitsResponse updateIndividualLimit(String pan,IndividualLimitsDto modelCard) {
    	return clienteWS.updateIndividualLimits(pan,modelCard);
    }
    
    public SaveInformationClientBitMatchResponse saveInformationClientBitMatch(@RequestBody InfoClientRequest info) {
    	return clienteWS.saveInformationClientBitMatch(info);
    }

}
