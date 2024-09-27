

DROP TABLE IF EXISTS activacion_tdd;
CREATE TABLE activacion_tdd(
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                codigo integer,
                descripcion varchar(45),
                autorizacion varchar(45),
                correcta boolean
);


DROP TABLE IF EXISTS saldo_tdd;
CREATE TABLE saldo_tdd(
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                codigo integer,
                descripcion varchar(45),
                saldo numeric,
                correcta boolean
);


DROP TABLE IF EXISTS deposito_tdd;
CREATE TABLE deposito_tdd(
                             tarjeta varchar(45),
                             peticion text,
                             fecha timestamp without time zone,
                             codigo Integer,
                             descripcion text,
                             autorizacion varchar(45),
                             saldo_antes_abono numeric,
                             saldo_despues_abono numeric,
                             correcto boolean
);



DROP TABLE IF EXISTS retiro_tdd;
CREATE TABLE retiro_tdd(
                           peticion text,
                           tarjeta varchar(45),
                           fecha timestamp without time zone,
                           codigo integer,
                           autorizacion varchar(45),
                           descripcion varchar(45),
                           saldo_antes_retiro numeric,
                           saldo_despues_retiro numeric,
                           correcto boolean
);


DROP TABLE IF EXISTS asignanip_tdd;/**/
CREATE TABLE asignanip_tdd(
                              peticion text,
                              tarjeta varchar(45),
                              fecha timestamp without time zone,
                              codigo Integer,
                              descripcion varchar(45),
                              correcto boolean
);



DROP TABLE IF EXISTS transacciones_tdd;
CREATE TABLE transacciones_tdd(
                                  idoperacionsaicoop integer DEFAULT nextval('transacciones_tdd_sequence'),
                                  peticion text,
                                  tarjeta varchar(45),
                                  fecha timestamp without time zone,
                                  codigo Integer,
                                  descripcion varchar(45),
                                  correcto boolean,
                                  noperaciones integer,

                                  primary key(idoperacionsaicoop)


);

DROP table IF EXISTS transaccion_tdd;
CREATE TABLE transaccion_tdd(
                                idoperacionsaicoop integer,
                                tarjeta varchar(45),
                                tipotransaccion varchar(45),
                                monto numeric,
                                codigo varchar(45),
                                descripcion varchar(45),
                                fecha varchar(45),
                                autorizacion varchar(45),
                                saldodisponible numeric,
                                FOREIGN KEY (idoperacionsaicoop)
                                    REFERENCES transacciones_tdd(idoperacionsaicoop)
);


CREATE SEQUENCE transacciones_tdd_sequence
    START WITH 1    -- Valor inicial
    INCREMENT BY 1  -- Incremento
    NO MINVALUE     -- Sin valor mínimo
    NO MAXVALUE     -- Sin valor máximo
    CACHE 1;        -- Cache de secuencia




DROP TABLE IF EXISTS asignar_tdd;
CREATE TABLE asignar_tdd(
                            peticion text,
                            tarjeta varchar(45),
                            fecha timestamp without time zone,
                            codigo integer,
                            descripcion text,
                            autorizacion varchar(45),
                            numerocuenta text,
                            numerocliente varchar(45),
                            nombrecliente text,
                            clabeinterbancaria text,
                            fechamovimiento varchar(45),
                            horamovimiento varchar(45),
                            correcto boolean
);


DROP TABLE IF EXISTS bloqueo_tdd;
CREATE TABLE bloqueo_tdd(
                            fecha timestamp without time zone,
                            tarjeta varchar(45),
                            peticion text,
                            codigo integer,
                            descripcion varchar(45),
                            autorizacion varchar(45),
                            correcta boolean
);


DROP TABLE IF EXISTS bloqueo_temporal_tdd;
CREATE TABLE bloqueo_temporal_tdd(
                                     tarjeta varchar(45),
                                     fecha timestamp without time zone,
                                     peticion text,
                                     codigo varchar(45),
                                     descripcion text,
                                     autorizacion varchar(45),
                                     correcta boolean
);

DROP TABLE IF EXISTS informacion_tdd;
CREATE TABLE informacion_tdd(
                                tarjeta varchar(45),
                                peticion text,
                                fecha timestamp without time zone,
                                tarjetaresponse varchar(45),
                                codigo integer,
                                descripcion text,
                                nombre varchar(45),
                                direccion varchar(45),
                                colonia varchar(45),
                                localidad varchar(45),
                                estado varchar(45),
                                rfc varchar(45),
                                codigopostal varchar(45),
                                telefono varchar(45),
                                correcto boolean
);

DROP TABLE IF EXISTS modificar_limite_tdd;
CREATE TABLE modificar_limite_tdd(
                                     peticion text,
                                     tarjeta varchar(45),
                                     fecha timestamp without time zone,
                                     codigo integer,
                                     autorizacion varchar(45),
                                     descripcion varchar(45),
                                     correcto boolean
);


DROP TABLE IF EXISTS reemplazo_tdd;
CREATE TABLE reemplazo_tdd(
                              peticion text,
                              tarjeta varchar(45),
                              reemplazo varchar(45),
                              fecha timestamp without time zone,
                              codigo Integer,
                              descripcion text,
                              autorizacion varchar(45),
                              tarjetanueva varchar(45),
                              cuentaambiente text,
                              fechaexpiracion varchar(45),
                              status varchar(45),
                              tipo varchar(20),
                              correcto boolean
);


DROP TABLE IF EXISTS datos_demograficos;
CREATE TABLE datos_demograficos(
                                   peticion text,
                                   tarjeta varchar(45),
                                   fecha timestamp without time zone,
                                   codigo Integer,
                                   descripcion varchar(45),
                                   correcto boolean
);


DROP TABLE IF EXISTS guardarbitsinformacion_tdd;
CREATE TABLE guardarbitsinformacion_tdd(
                                           peticion text,
                                           tarjeta varchar(45),
                                           fecha timestamp without time zone,
                                           codigo integer,
                                           autorizacion varchar(45),
                                           descripcion varchar(45),
                                           correcto boolean
);

DROP TABLE IF EXISTS eliminar_limite_tdd;
CREATE TABLE eliminar_limite_tdd(
                           peticion text,
                           tarjeta varchar(45),
                           fecha timestamp without time zone,
                           codigo integer,
                           autorizacion varchar(45),
                           descripcion varchar(45),
                           correcto boolean
);




























/********************************/




DROP TABLE IF EXISTS activacion_tdd;
CREATE TABLE activacion_tdd (
                                tarjeta varchar(45),
                                fecha timestamp without time zone,
                                peticion text,
                                codigo integer,
                                descripcion varchar(45),
                                autorizacion varchar(45),
                                correcta boolean
);
create index activacion_tdd_idx on activacion_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS asignar_tdd;
CREATE TABLE asignar_tdd (
                             peticion text,
                             tarjeta varchar(45),
                             fecha timestamp without time zone,
                             codigo integer,
                             descripcion text,
                             autorizacion varchar(45),
                             numerocuenta text,
                             numerocliente varchar(45),
                             nombrecliente text,
                             clabeinterbancaria text,
                             fechamovimiento varchar(45),
                             horamovimiento varchar(45),
                             correcto boolean
);
create index asignar_tdd_idx on asignar_tdd (tarjeta, fecha);




DROP TABLE IF EXISTS consulta_saldo_tdd;
CREATE TABLE consulta_saldo_tdd(
                                   tarjeta varchar(45),
                                   fecha timestamp without time zone,
                                   peticion text,
                                   codigo integer,
                                   descripcion varchar(45),
                                   saldo numeric,
                                   correcta boolean
);
create index consulta_saldo_tdd_idx on consulta_saldo_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS deposito_tdd;
CREATE TABLE deposito_tdd (
                              tarjeta varchar(45),
                              peticion text,
                              fecha timestamp without time zone,
                              codigo Integer,
                              descripcion text,
                              autorizacion varchar(45),
                              saldo_antes_abono numeric,
                              saldo_despues_abono numeric,
                              correcto boolean
);
create index deposito_tdd_idx on deposito_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS retiro_tdd;
CREATE TABLE retiro_tdd (
                            peticion text,
                            tarjeta varchar(45),
                            fecha timestamp without time zone,
                            codigo integer,
                            autorizacion varchar(45),
                            descripcion varchar(45),
                            saldo_antes_retiro numeric,
                            saldo_despues_retiro numeric,
                            correcto boolean
);

create index retiro_tdd_idx on retiro_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS asignanip_tdd;
CREATE TABLE asignanip_tdd (
                               peticion text,
                               tarjeta varchar(45),
                               fecha timestamp without time zone,
                               codigo Integer,
                               descripcion varchar(45),
                               correcto boolean
);
create index asignanip_tdd_idx on asignanip_tdd (tarjeta, fecha);




DROP TABLE IF EXISTS transacciones_tdd;
CREATE TABLE transacciones_tdd (
                                   idoperacionsaicoop integer DEFAULT nextval('transacciones_tdd_sequence'),
                                   peticion text,
                                   tarjeta varchar(45),
                                   fecha timestamp without time zone,
                                   codigo Integer,
                                   descripcion varchar(45),
                                   correcto boolean,
                                   noperaciones integer,
                                   primary key(idoperacionsaicoop)
);
create index transacciones_tdd_idx on transacciones_tdd (idoperacionsaicoop, tarjeta, fecha);




DROP table IF EXISTS transaccion_tdd;
CREATE TABLE transaccion_tdd (
                                 idoperacionsaicoop integer,
                                 tarjeta varchar(45),
                                 tipotransaccion varchar(45),
                                 monto numeric,
                                 codigo varchar(45),
                                 descripcion varchar(45),
                                 fecha varchar(45),
                                 autorizacion varchar(45),
                                 saldodisponible numeric,
                                 FOREIGN KEY (idoperacionsaicoop)
                                     REFERENCES transacciones_tdd(idoperacionsaicoop)
);
create index transaccion_tdd_idx on transaccion_tdd (idoperacionsaicoop, tarjeta, fecha);

CREATE SEQUENCE transacciones_tdd_sequence
    START WITH 1    -- Valor inicial
    INCREMENT BY 1  -- Incremento
    NO MINVALUE     -- Sin valor mínimo
    NO MAXVALUE     -- Sin valor máximo
    CACHE 1;        -- Cache de secuencia



DROP TABLE IF EXISTS bloqueo_tdd;
CREATE TABLE bloqueo_tdd (
                             fecha timestamp without time zone,
                             tarjeta varchar(45),
                             peticion text,
                             codigo integer,
                             descripcion varchar(45),
                             autorizacion varchar(45),
                             correcta boolean
);

create index bloqueo_tdd_idx on bloqueo_tdd (tarjeta, fecha);





DROP TABLE IF EXISTS bloqueo_temporal_tdd;
CREATE TABLE bloqueo_temporal_tdd (
                                      tarjeta varchar(45),
                                      fecha timestamp without time zone,
                                      peticion text,
                                      codigo varchar(45),
                                      descripcion text,
                                      autorizacion varchar(45),
                                      correcta boolean
);

create index bloqueo_temporal_tdd_idx on bloqueo_temporal_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS informacion_tdd;
CREATE TABLE informacion_tdd (
                                 tarjeta varchar(45),
                                 peticion text,
                                 fecha timestamp without time zone,
                                 tarjetaresponse varchar(45),
                                 codigo integer,
                                 descripcion text,
                                 nombre varchar(45),
                                 direccion varchar(45),
                                 colonia varchar(45),
                                 localidad varchar(45),
                                 estado varchar(45),
                                 rfc varchar(45),
                                 codigopostal varchar(45),
                                 telefono varchar(45),
                                 correcto boolean
);

create index informacion_tdd_idx on informacion_tdd (tarjeta, fecha);







DROP TABLE IF EXISTS modificar_limite_tdd;
CREATE TABLE modificar_limite_tdd (
                                      peticion text,
                                      tarjeta varchar(45),
                                      fecha timestamp without time zone,
                                      codigo integer,
                                      autorizacion varchar(45),
                                      descripcion varchar(45),
                                      correcto boolean
);

create index modificar_limite_tdd_idx on modificar_limite_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS reemplazo_tdd;
CREATE TABLE reemplazo_tdd (
                               peticion text,
                               tarjeta varchar(45),
                               reemplazo varchar(45),
                               fecha timestamp without time zone,
                               codigo Integer,
                               descripcion text,
                               autorizacion varchar(45),
                               tarjetanueva varchar(45),
                               cuentaambiente text,
                               fechaexpiracion varchar(45),
                               status varchar(45),
                               tipo varchar(20),
                               correcto boolean
);

create index reemplazo_tdd_idx on reemplazo_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS datos_demograficos;
CREATE TABLE datos_demograficos (
                                    peticion text,
                                    tarjeta varchar(45),
                                    fecha timestamp without time zone,
                                    codigo Integer,
                                    descripcion varchar(45),
                                    correcto boolean
);

create index datos_demograficos_idx on datos_demograficos (tarjeta, fecha);



DROP TABLE IF EXISTS guardarbitsinformacion_tdd;
CREATE TABLE guardarbitsinformacion_tdd (
                                            peticion text,
                                            tarjeta varchar(45),
                                            fecha timestamp without time zone,
                                            codigo integer,
                                            autorizacion varchar(45),
                                            descripcion varchar(45),
                                            correcto boolean
);

create index guardarbitsinformacion_tdd_idx on guardarbitsinformacion_tdd (tarjeta, fecha);



DROP TABLE IF EXISTS eliminar_limite_tdd;
CREATE TABLE eliminar_limite_tdd(
                                    peticion text,
                                    tarjeta varchar(45),
                                    fecha timestamp without time zone,
                                    codigo integer,
                                    autorizacion varchar(45),
                                    descripcion varchar(45),
                                    correcto boolean
);

create index eliminar_limite_tdd_idx on eliminar_limite_tdd (tarjeta, fecha);




                                                                Busqueda Saldo
   tarjeta         |          fecha          |                       peticion                        | codigo |    descripcion    | saldo | correcta
------------------+-------------------------+-------------------------------------------------------+--------+-------------------+-------+----------
 5062420100002645 | 28/05/2024 12:16:13.908 | /api/cards/getBalanceQuery/idtarjeta=5062420100002645 |      1 | Tarjeta Inactiva. |     0 | t                ---Error
 5062420100002645 | 28/05/2024 17:04:23.028 | /api/cards/getBalanceQuery/idtarjeta=5062420100002645 |      1 | Tarjeta Registrada. |     0 | t              ---Consulta exitosa
 5062420100002689 | 28/05/2024 18:12:18.539 | /api/cards/getBalanceQuery/idtarjeta=5062420100002689 |      0 | Tarjeta no registrada. |     0 | f

                                                                  Activacion
tarjeta          |           fecha          |                       peticion                     | codigo |        descripcion  | autorizacion | correcta
5062420100002645 | 28/05/2024 12:54:02.108  | /api/cards/activateCard/idtarjeta=5062420100002645 |   1    |  Activacion exitosa |    921810    |   true       ---Correcta
5062420100002645 | 28/05/2024 17:02:24.45   | /api/cards/activateCard/idtarjeta=5062420100002645 |   3    | La Tarjeta ya fue Activada. | 0            | f    ---Error
5062420100002689 | 28/05/2024 18:13:09.401 | /api/cards/activateCard/idtarjeta=5062420100002689 |      2 | Tarjeta no Registrada.      | 0             |f


                                                                 Deposito
tarjeta           |                         peticion                           |          fecha          | codigo |         descripcion           | autorizacion | saldo_antes_abono | saldo_despues_abono | correcto
------------------+----------------------------------------------------------- +-------------------------+--------+------------------------------+--------------+-------------------+---------------------+----------
 5062420100002645 | /api/cards/loadBalance/idtarjeta=5062420100002645&monto=1  | 28/05/2024 17:35:48.137 |    1   | Recarga realizada con exito.  | 520138       |              1.91 |                2.91 | t
 5062420100002645 | /api/cards/loadBalance/idtarjeta=5062420100002645&monto=1s | 28/05/2024 17:48:05.897 |        | Conexion invalida hacia proveedor TDD |      |                   |                     | f
 5062420100002645 | /api/cards/loadBalance/idtarjeta=5062420100002645&monto=-100 | 28/05/2024 18:10:26.567 |      6 | El monto a depositar es incorrecto.   | 0            |                 0 |                   0 | t


                                                                    Retiro
                          peticion                           |     tarjeta      |          fecha          | codigo | autorizacion |         descripcion         | saldo_antes_retiro | saldo_despues_retiro | correcto
-------------------------------------------------------------+------------------+-------------------------+--------+--------------+-----------------------------+--------------------+----------------------+----------
 /api/cards/doWithDrawal/idtarjeta=5062420100002645&monto=10 | 5062420100002645 | 28/05/2024 18:07:45.907 |      1 | 763314       | Retiro realizado con exito. |            1002.91 |               992.91 | t
 /api/cards/doWithDrawal/idtarjeta=5062420100002645&monto=1000 | 5062420100002645 | 28/05/2024 18:09:05.522 |      5 | 900825       | Fondos Insuficientes.       |                  0 |                    0 | t
 /api/cards/doWithDrawal/idtarjeta=5062420100002645&monto=-100 | 5062420100002645 | 28/05/2024 18:09:43.013 |      6 | 0            | El monto a retirar es incorrecto. |                  0 |                    0 | t


                                                                    Asigna Nip 
                         peticion                         |     tarjeta      |          fecha          | codigo |      descripcion       | correcto
----------------------------------------------------------+------------------+-------------------------+--------+------------------------+----------
 /api/cards/asignaNip/idtarjeta=5062420100002645&nip=9218 | 5062420100002645 | 28/05/2024 18:51:08.947 |      4 | Operacion no permitida | t


                                                                         Asignar TDD
                          peticion                         |     tarjeta      |          fecha          | codigo |                    descripcion                     | autorizacion | numerocuenta | numerocliente | nombrecliente | clabeinte
rbancaria | fechamovimiento | horamovimiento | correcto 
----------------------------------------------------------+------------------+-------------------------+--------+----------------------------------------------------+--------------+--------------+---------------+---------------+----------
----------+-----------------+----------------+----------
 /api/cards/assignamentAccount/idtarjeta=5062420100002645 | 5062420100002645 | 29/05/2024 12:00:35.895 |      3 | La tarjeta a procesar ya fue asignada previamente. | 0            |              |               |               |          
          |                 |                | t
 /api/cards/assignamentAccount/idtarjeta=5062420100002689 | 5062420100002689 | 29/05/2024 12:02:04.707 |      2 | Tarjeta no registrada.                             | 0            |              |               |               |          
          |                 |                | t
 /api/cards/assignamentAccount/idtarjeta=5062420100002611 | 5062420100002611 | 29/05/2024 12:03:25.258 |      4 | La cuenta ya se encuentra asignada.                | 0            |              |               |               |          
          |                 |                | t
 /api/cards/assignamentAccount/idtarjeta=5062420100002611 | 5062420100002611 | 29/05/2024 12:03:44.179 |     21 | Validar el campo cuenta.                           | 0            |              |               |               |          
          |                 |                | t

                                                                           Consulta Movimientos
 noperaciones |                                    peticion                                     |     tarjeta      |          fecha          | codigo |       descripcion        | correcto | idoperacionsaicoop
--------------+---------------------------------------------------------------------------------+------------------+-------------------------+--------+--------------------------+----------+--------------------
            4 | /api/cards/lastestsTransactions/idtarjeta=5062420100002645&totalMov=4&tipoMov=3 | 5062420100002645 | 29/05/2024 18:15:58.667 |      1 | Movimientos Registrados. | t        |                  6    --->Registro principal


                                                                         Todos movimientos con su descripcion
idoperacionsaicoop |       tarjeta       | tipotransaccion | monto | codigo |            descripcion            |        fecha        | autorizacion | saldodisponible
--------------------+---------------------+-----------------+-------+--------+-----------------------------------+---------------------+--------------+-----------------
                  6 | 5062420100002645    | Disposición     |    10 | 13000  | DISPOSICIÓN                       | 28/05/2024 18:04:58 | 763314       |          992.91
                  6 | 5062420100002645    | Deposito        |  1000 | 210000 | DEPOSITO POR DISPERSION DE SALDOS | 28/05/2024 17:47:06 | 131837       |         1002.91                ----> Movimiento amarrado con idoperacionsaicoop
                  6 | 5062420100002645    | Deposito        |     1 | 210000 | DEPOSITO POR DISPERSION DE SALDOS | 28/05/2024 17:33:00 | 520138       |            2.91
                  6 | 5062420100002645    | Deposito        |     1 | 210000 | DEPOSITO POR DISPERSION DE SALDOS | 28/05/2024 17:31:47 | 783178       |            1.91



                                                                          bloqueo Temporal TDD
     tarjeta      |          fecha          |                         peticion                          | codigo |            descripcion             | autorizacion | correcta
------------------+-------------------------+-----------------------------------------------------------+--------+------------------------------------+--------------+----------
 5062420100002645 | 30/05/2024 09:42:14.046 | /api/cards/temporaryLock/idtarjeta=5062420100002645&mov=2 | 3      | La Tarjeta no se encuentra Activa. | 0            | t


                                                                        bloqueo TDD
                                                                                   fecha          |     tarjeta      |                    peticion                    | codigo |            descripcion             | autorizacion | correcta
-------------------------+------------------+------------------------------------------------+--------+------------------------------------+--------------+----------
 30/05/2024 09:49:28.537 | 5062420100002645 | /api/cards/cardLock/idtarjeta=5062420100002645 |      3 | La Tarjeta no se encuentra Activa. | 0            | t


                                                                       Informacion TDD

                                                                           tarjeta      |                          peticion                           |          fecha          | tarjetaresponse  | codigo | descripcion |   nombre   |       direccion        | colonia | localidad | estado | rfc | codigopostal
  tarjeta      |                          peticion                           |          fecha          | tarjetaresponse  | codigo |     descripcion      |   nombre   |       direccion        | colonia | localidad | estado | rfc | codi
gopostal | telefono | correcto
------------------+-------------------------------------------------------------+-------------------------+------------------+--------+----------------------+------------+------------------------+---------+-----------+--------+-----+-----
---------+----------+----------
 5062420100002611 | /api/cards/cardHolderInformation/idtarjeta=5062420100002611 | 30/05/2024 13:34:15.082 | 5062420100002611 |      1 |                      | nahumdfdsf | nuervocscssc dsjfpdsfj |         |           |        |     |
         |          | t
 5062420100002699 | /api/cards/cardHolderInformation/idtarjeta=5062420100002699 | 30/05/2024 13:36:06.193 |                  |      3 | No existe la tarjeta |            |                        |         |           |        |     |
         |          | t


                                                                    Modificar Limites TDD

                                                                                                   peticion                           |     tarjeta      |          fecha          | codigo | autorizacion |            descripcion            | correcto
-------------------------------------------------------------+------------------+-------------------------+--------+--------------+-----------------------------------+----------
 /api/cards/updateIndividualLimit/idtarjeta=5062420100002611 | 5062420100002611 | 30/05/2024 13:43:12.246 |      1 | 473118       | limites individuales creados      | t
 /api/cards/updateIndividualLimit/idtarjeta=5062420100002611 | 5062420100002611 | 30/05/2024 13:44:15.245 |      1 | 898064       | limites individuales actualizados | t


                                                                 Reemplado TDD(reemplazar numero de tjeta. a ser reemplazada,idtarjeta=nueva tarjeta y debe estar inactiva)

                                                                           peticion                                        |     tarjeta      | reemplazo |          fecha          | codigo |            descripcion             | autorizacion | tarjetanueva | cuentaambiente
| fechaexpiracion | status | tipo | correcto
----------------------------------------------------------------------------------------+------------------+-----------+-------------------------+--------+------------------------------------+--------------+--------------+----------------
+-----------------+--------+------+----------
 /api/cards/stockCardReplacement/idtarjeta=5062420100002637&reemplazar=5062420100002645 | 5062420100002637 |           | 30/05/2024 13:54:33.324 |      6 | La tarjeta a reemplzar esta activa | 0            |              |
|                 |        |      | t

                                                                            Modificar Datos demograficos

                          peticion                           |     tarjeta      |          fecha          | codigo |       descripcion       | correcto
-------------------------------------------------------------+------------------+-------------------------+--------+-------------------------+----------
 /api/cards/updateDemographicData/idtarjeta=5062420100002611 | 5062420100002611 | 30/05/2024 13:58:29.568 |      1 | Finalizo Correctamente. | t


                                                                        Guardar Bits informacion
             peticion             |     tarjeta      |          fecha          | codigo | autorizacion |       descripcion        | correcto
----------------------------------+------------------+-------------------------+--------+--------------+--------------------------+----------
 /api/cards/saveInformationClient | 5062420100002611 | 30/05/2024 14:01:41.178 |      2 | 0            | Validar el campo cuenta. | t

                                            Eliminar limites Individuales TDD

 peticion |     tarjeta      |          fecha          | codigo | autorizacion |          descripcion          | correcto
----------+------------------+-------------------------+--------+--------------+-------------------------------+----------
          | 5062420100002611 | 30/05/2024 14:04:55.622 |      1 |              | limites individuales borrados | t


activateCard       *
getBalanceQuery    *
cardLock           *
temporaryLock      *
loadBalance        *
getLastestTransactions *
asignaNip          * Integrado pero con revision de codigo 4 siempre
assignamentAccount  *  "description": "Validar el campo cuenta." codigo 21,
doWithdrawalAccount *
deleteInidividualLimits *
updateInidividualLimits *
saveInformationClientBitchMatch * --Validar el campo cuenta Solicitar ejemplo de request con cuenta para QA
stockCardReplacement *
updateDemogrphicData *
getCardHolderInformation  *


5062420100002611

5062420100002629

5062420100002637

5062420100002645 ---Usado y bloqueado

5062420100002652

5062420100002660

5062420100002678

5062420100002686

5062420100002694 /**/
5062420100002694 /**/

5062420100002702