package SQL;

//HANCIENDO CONEXIÓN ALA BASE DE DATOS
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usser = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/db_banco_guatemala";

    //CONSTRUCTOR DE LA CLASE
    public ConexionSQL() {
        conn = null;
        try {
            //INICIIANDO LA SESION
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usser, pass);
            if (conn != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar " + e);
        }
    }

    //RETORNADO LA CONEXION ALA BASE DE DATOS.
    public Connection getConnection() {
        return conn;
    }

    //Desconectando de la base de datos
    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion Finalizada");
        }
    }
}
