
//Sagrada Test
DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='url_alestra';
INSERT INTO tablas(idtabla,idelemento,dato2) VALUES('emisor_adquiriente','url_alestra','http://192.168.110.85:6969/syc-siscoop/webservice/sagrada-familia/siscoopSecureService');

DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='credenciales';
INSERT INTO tablas(idtabla,idelemento,dato1,dato2) VALUES('emisor_adquiriente','credenciales','ws_sagrada_familia','ws_sagrada_familia');

//Sagrada Prod
DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='url_alestra';
INSERT INTO tablas(idtabla,idelemento,dato2) VALUES('emisor_adquiriente','url_alestra','http://200.15.1.143:8080/syc/webservice/sagrada-familia/siscoopSecureService');

DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='credenciales';
INSERT INTO tablas(idtabla,idelemento,dato1,dato2) VALUES('emisor_adquiriente','credenciales','ws_sagrada_familia','p12nIvjhnJp1ovi8bocg');


//Buenos Aires
DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='url_alestra';
INSERT INTO tablas(idtabla,idelemento,dato2) VALUES('emisor_adquiriente','url_alestra','http://192.168.110.85:6969/syc-siscoop/webservice/buenos-aires/siscoopSecureService');

DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='credenciales';
INSERT INTO tablas(idtabla,idelemento,dato1,dato2) VALUES('emisor_adquiriente','credenciales','ws_buenos_aires','ws_buenos_aires');



//Buenos aires produccion
DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='url_alestra';
INSERT INTO tablas(idtabla,idelemento,dato2) VALUES('emisor_adquiriente','url_alestra','http://200.15.1.143:8080/syc/webservice/buenos-aires/siscoopSecureService');

DELETE FROM tablas WHERE idtabla='emisor_adquiriente' AND idelemento='credenciales';
INSERT INTO tablas(idtabla,idelemento,dato1,dato2) VALUES('emisor_adquiriente','credenciales','ws_buenos_aires','ls$2YH%4uQPtJw4n7wJOP');






//Curl SAICoop

Activar TDD
curl --location GET 'http://192.168.99.37:9001/api/cards/activateCard/idtarjeta=TuNumTjeta';

Saldo TDD
curl --location GET 'http://192.168.99.37:9001/api/cards/getBalanceQuery/idtarjeta=TuNumTjeta';

Bloqueo TDD
curl --location GET 'http://192.168.99.37:9001/api/cards/cardLock/idtarjeta=TuNumTjeta';

BloqueoTemporalTDD
curl --location GET 'http://192.168.99.37:9001/api/cards/temporaryLock/idtarjeta=TuNumTjeta&mov=1 bloqueo 2 desbloqueo';

DepositoTDD
curl --location GET 'http://192.168.99.37:9001/api/cards/loadBalance/idtarjeta=TuNumTjeta&monto=monto en formato 0.00';

Modificar Datos Demograficos
curl -X POST -d '{"name":"Nombre","shortName":"Apellido","address":"Direccion","email":"correo","colony":"Colonia","zipCode":"CodigoPostal","municipality":"Municipio","city":"Ciudad","state":"Estado","rfc":"RFC","homePhone":"TelefonoCasa","cellPhone":"Celular","workPhone":"TelefonoTrabajo"}' -H 'Content-Type: application/json' 'http://192.168.99.37:9001/api/cards/updateDemographicData/idtarjeta=TuNumTjeta'

Ultimos Movimientos TDD
curl --location 'http://192.168.99.37:9001/api/cards/lastestsTransactions/idtarjeta=TuNumTjeta&totalMov=NumMovs&tipoMov=1 cargos 2 abonos 3 ambos'

Reemplazar TDD
curl --location 'http://192.168.99.37:9001/api/cards/stockCardReplacement/idtarjeta=tuNumTjeta&reemplazar=NvaTddNum'

Asigna NIP TDD
curl --location 'http://192.168.99.37:9001/api/cards/asignaNip/idtarjeta=TuNumTjeta8&nip=TuNip'

Informacion TDD
curl --location 'http://192.168.99.37:9001/api/cards/cardHolderInformation/idtarjeta=tuNumTjeta'

Asignar Cuenta TDD
curl -X POST -d '{ "cuenta":"", "nombreLargo":"Wilmer De Jesus","nombreCorto":"r","direccion":"","colonia":"","entidadFederativa":"","codigoPostal":"","rfc":"","telefono":"","telefono2":"","sucursal":"","producto":""}' -H 'Content-Type: application/json'  'http://192.168.99.37:9001/api/cards/assignamentAccount/idtarjeta=TuNumMTjeta'
    
Retiro TDD
curl --location 'http://192.168.99.37:9001/api/cards/doWithDrawal/idtarjeta=TuNumtjeta8&monto=tu monto en formato 0.00'

Eliminar Limite TDD
curl --location 'http://192.168.99.37:9001/api/cards/deleteIndividualLimit/idtarjeta=TuNumTjeta'

Modificar Limite TDD
curl -X POST -d '{"maxWithdrawalAmount":"3000","maxWithdrawalNumber":"2","maxBuysAmount":"2","maxBuysNumber":"2","maxWithdrawalAmountInt":"1000","maxWithdrawalNumberInt":"1000"}' -H 'Content-Type: application/json' 'http://192.168.99.37:9001/api/cards/updateIndividualLimit/idtarjeta=TuNumTjeta'

Guardar coincidencias Bits Cliente TDD
curl -X POST -d '{"cuenta":"5063350100001355","nombreLargo":"Wilmer De Jesus","nombreCorto":"r","direccion":"","colonia":"","entidadFederativa":"","codigoPostal":"","rfc":"","telefono":"","telefono2":"","sucursal":"","producto":""}' -H 'Content-Type: application/json' 'http://192.168.99.37:9001/api/cards/saveInformationClient'


