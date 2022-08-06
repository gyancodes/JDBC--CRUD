package CollableStatement;

import java.sql.*;

public class StoreProcedures {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3307/emp";
        String user = "root";
        String password = "toor";

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection(dbUrl,user,password);
            System.out.println("Database connection seccessful");

            String sql = "{call emp.details()}";

            callableStatement = connection.prepareCall(sql);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("age") + " " + resultSet.getString("name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            assert connection != null;
            connection.close();
        }



    }
}
