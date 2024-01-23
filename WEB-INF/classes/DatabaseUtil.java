package databases;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import databases.MyCon;

public class DatabaseUtil {

    public  static Connection co() throws Exception{
    return  MyCon.getMySQLCon() ;
    }
    public static <T> void insertEntity(T entity, String tableName) throws Exception {
        String insertQuery = generateInsertQuery(entity, tableName);
        System.out.println("Generated SQL: " + insertQuery);  
        MyCon connection = new MyCon();
    
        try (PreparedStatement preparedStatement = co().prepareStatement(insertQuery)) {
            setPreparedStatementValues(preparedStatement, entity);
            preparedStatement.executeUpdate();
            co().close();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public static <T> void setPreparedStatementValues(PreparedStatement preparedStatement, T entity) throws SQLException, IllegalAccessException, Exception {
        Field[] fields = entity.getClass().getDeclaredFields();
    
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
    
            if (i > 0) {
                preparedStatement.setObject(i, fields[i].get(entity));
            }
        }
    }
            
    public static <T> String generateInsertQuery(T entity, String tableName)throws Exception {
        List<Field> fieldsList = Arrays.asList(entity.getClass().getDeclaredFields());

        String columns = fieldsList.stream()
                .skip(1)
                .map(Field::getName)
                .collect(Collectors.joining(", "));

        String values = IntStream.range(0, fieldsList.size())
                .skip(1)
                .mapToObj(i -> "?")
                .collect(Collectors.joining(", "));

        return "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
    }
    public static ResultSet select(String tableName)throws Exception {
        ResultSet resultSet = null;
        try {
            MyCon connection = new MyCon();
            String query = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = co().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            co().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static ResultSet getMaladie(int loha,int lelo,int tenda,int kibo,int caca,int fatigue,int temperature)throws Exception {
        ResultSet resultSet = null;
        try {
            MyCon connection = new MyCon();
            String query = "SELECT maladie," +
            "loha - " + loha + " AS loha2 , lelo - " + lelo + " AS lelo2 , tenda - " + tenda + " AS tenda2, " +
            "kibo - " + kibo + " AS kibo2, caca - " + caca + " AS caca2, fatigue - " + fatigue + " AS fatigue2, " +
            "temperature - " + temperature + " AS temperature2 " +
            "FROM maladie " +
            "ORDER BY ABS( loha2 - lelo2 - tenda2 - kibo2 - caca2 - fatigue2 - temperature2) " +
            "LIMIT 1";
        PreparedStatement preparedStatement = co().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            co().close();
            System.out.println("Generated SQL: " + query);  

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static ResultSet getMedicament(int loha,int lelo,int tenda,int kibo,int caca,int fatigue,int temperature)throws Exception {
        ResultSet resultSet = null;
        try {
            MyCon connection = new MyCon();
           String query = "SELECT medicament, " +
               "loha + " + loha + " AS loha2, lelo + " + lelo + " AS lelo2, tenda + " + tenda + " AS tenda2, " +
               "kibo + " + kibo + " AS kibo2, caca + " + caca + " AS caca2, fatigue + " + fatigue + " AS fatigue2, " +
               "temperature + " + temperature + " AS temperature2, prix " +
               "FROM medicament " +
               "ORDER BY  ABS( loha2 + lelo2 + tenda2 + kibo2 + caca2 + fatigue2 + temperature2) DESC , prix ASC " +
               "LIMIT 1";
               PreparedStatement preparedStatement = co().prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             co().close();
            System.out.println("Generated SQL: " + query);  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
