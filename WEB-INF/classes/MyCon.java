package databases;
import java.sql.*;
public class MyCon {
    public static Connection getPostgreSQLCon() throws Exception {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://postgresql-itu.alwaysdata.net:5432/itu_instrument", "itu", "MENDRIKAmalal");
            return con;
        } catch (Exception e) {
            throw e;
        }
    }
    public static Connection getMySQLCon() throws Exception {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/docteur", "men", "123");
            return con;
        } catch (Exception e) {
            throw e;
        }
    }
}
