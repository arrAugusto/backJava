package models;

import SQL.ConexionSQL;
import Struct.TipoCambioDiaStruct;
import controlador.ConsumoSoap;
import java.sql.Connection;
import java.sql.Statement;
import wsBancoGuatemala.VarDolar;

public class GuardarServiciosSOAP {

    public GuardarServiciosSOAP() {
    }

    public static VarDolar guardarTipoCambioDia() {
        //Invocamos la clase consumo soap
        ConsumoSoap consumoSoap = new ConsumoSoap();
        //Obtenemos el resultado de la funcion consumoSoap
        VarDolar arrayDolar = consumoSoap.getTipoCambioDia();
        //Instanciar el struct TipoCambioDia
        TipoCambioDiaStruct tipoCambioDiaStruct = new TipoCambioDiaStruct();
        //Seteando fecha response
        tipoCambioDiaStruct.setFecha(arrayDolar.getFecha());
        //Setenado tipo de cambio
        tipoCambioDiaStruct.setTipoCambio(arrayDolar.getReferencia());
        
        //Instanciar la conexion sql
        ConexionSQL conexionSQL = new ConexionSQL();
        //Obtener la conexion sql
        Connection regConn = conexionSQL.getConnection();
        
        String query = "CALL `spNewTipoCambioDia` ("+tipoCambioDiaStruct.getFecha()+", "+tipoCambioDiaStruct.getTipoCambio()+")";
        try {
            Statement statement = regConn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
  
        }
       return arrayDolar;
    }
}
