package models;

import SQL.ConexionSQL;
import Struct.TipoCambioDiaStruct;
import controlador.ConsumoSoap;
import java.sql.Connection;
import java.sql.Statement;
import wsBancoGuatemala.InfoVariable;

public class GuardarServiciosSOAP {

    public GuardarServiciosSOAP() {
    }

    public static boolean guardarTipoCambioDia() {
        //Invocamos la clase consumo soap
        ConsumoSoap consumoSoap = new ConsumoSoap();
        //Obtenemos el resultado de la funcion consumoSoap
        InfoVariable resultado = consumoSoap.getTipoCambioDia();
        //Instanciar el struct TipoCambioDia
        TipoCambioDiaStruct tipoCambioDiaStruct = new TipoCambioDiaStruct();
        tipoCambioDiaStruct.setFecha("sfdsfd");
        //Instanciar la conexion sql
        ConexionSQL conexionSQL = new ConexionSQL();
        //Obtener la conexion sql
        Connection regConn = conexionSQL.getConnection();
        
        String query = "CALL `spNewTipoCambioDia` ()";

        try {
            Statement statement = regConn.createStatement();
            statement.executeUpdate(query);
            
        } catch (Exception ex) {

        }

        return true;
    }
}
