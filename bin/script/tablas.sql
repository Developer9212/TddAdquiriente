

DROP TABLE IF EXISTS activacion_tdd;
CREATE TABLE activacion_tdd(
                id integer,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                codigo integer,
                descripcion varchar(45),
                authorizacion varchar(45),
                correcta boolean
);


DROP TABLE IF EXISTS saldo_tdd;
CREATE TABLE saldo_tdd(
                id integer,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                codigo integer,
                descripcion varchar(45),
                saldo double,
                correcta boolean
);


DROP TABLE IF EXISTS bloqueo_tdd;
CREATE TABLE bloqueo_tdd(
                id integer,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                codigo integer,
                descripcion varchar(45),
                autorizacion varchar(45),
                correcta boolean
);

DROP TABLE IF EXISTS bloqueo_temporal_tdd;
CREATE TABLE bloqueo_temporal_tdd(
                id integer,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                peticion text,
                folio varchar(45),
                respuesta text,
                correcta boolean
);

DROP TABLE IF EXISTS deposito;
CREATE TABLE deposito(
                id integer,
                tarjeta varchar(45),
                peticion text,
                fecha timestamp without time zone,
                codigo Integer,
                descripcion text,
                autorizacion varchar(45),
                saldo_antes_abono double,
                saldo_despues_abono double,
                correcto boolean
);

DROP TABLE IF EXISTS modificacion_demograficos;
CREATE TABLE modificardatosdemograficos(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo Integer,
                descripcion varchar(45),
                correcto boolean
);


DROP TABLE IF EXISTS transacciones_tdd;
CREATE TABLE transacciones_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo Integer,
                descripcion varchar(45),
                correcto boolean,
                idoperacionsaicoop integer
);

DROP table IF EXISTS transaccion_tdd;
CREATE TABLE transaccion_tdd(
                 idoperacionsaicoop integer,
                 tarjeta varchar(45),
                 tipotransaccion integer,
                 monto double,
                 codigo Integer,
                 descripcion varchar(45),
                 fecha varchar(45),
                 saldodisponible double,
                 CONSTRAINT fk_transaccion_tdd
                 FOREIGN KEY (idoperacionsaicoop)
                 REFERENCES customers (idoperacionsaicoop)
);


DROP TABLE IF EXISTS reemplazo_tdd;/**/
CREATE TABLE reemplazo_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo Integer,
                autorizacion varchar(45),
                tarjetanueva varchar(45),
                fechaexpiracion varchar(45),
                descripcion varchar(45),
                status varchar(45),
                tipo varchar(20),
                correcto boolean
);


DROP TABLE IF EXISTS asignacionnip_tdd;/**/
CREATE TABLE asignacionnip_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo Integer,
                descripcion varchar(45),
                correcto boolean
);



DROP TABLE IF EXISTS informacion_tdd;/**/
CREATE TABLE informacion_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                nombre varchar(45),
                direccion varchar(45),
                direccion2 varchar(45),
                colonia varchar(45),
                localidad varchar(45),
                estado varchar(45),
                codigopostal varchar(45),
                telefono varchar(45),
                telefono2 varchar(45),
                telefono3 varchar(45),
                correcto boolean
);

DROP TABLE IF EXISTS asignar_tdd;
CREATE TABLE asignar_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo integer,
                descripcion varchar(45),
                folio varchar(45),
                numerocuenta varchar(45),
                numerocliente(45),
                nombrecliente varchar(45),
                clabeinterbancaria varchar(45),
                correcto boolean
);



DROP TABLE IF EXISTS retiro_tdd;
CREATE TABLE retiro_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo integer,
                autorizacion varchar(45),
                descripcion varchar(45),
                saldo_antes_retiro double,
                saldo_despues_retiro double,
                correcto boolean
);


DROP TABLE IF EXISTS eliminar_limite_tdd;
CREATE TABLE retiro_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo integer,
                autorizacion varchar(45),
                descripcion varchar(45),
                correcto boolean
);


DROP TABLE IF EXISTS modificar_limite_tdd;
CREATE TABLE modificar_limite_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo integer,
                autorizacion varchar(45),
                descripcion varchar(45),
                correcto boolean
);


DROP TABLE IF EXISTS guardarbitsinformacion_tdd;
CREATE TABLE guardarbitsinformacion_tdd(
                id integer,
                peticion text,
                tarjeta varchar(45),
                fecha timestamp without time zone,
                codigo integer,
                autorizacion varchar(45),
                descripcion varchar(45),
                correcto boolean
);
















