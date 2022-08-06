package CollableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

// import com.mysql.cj.jdbc.CollableDb;

// import java.sql.*;

public class collableDb {

    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3307/emp", "root","toor");
    }

    private int callCalculate(int num1,int num2){
        int res;
        res = num1 + num2;
        Connection con = null;
        CallableStatement st = null;


        try{
            con = collableDb.getConnection();
            st = (CallableStatement) con.prepareCall("{call details()}");
            st.setInt(1,num1);
            st.setInt(2,num2);

        }catch(Exception e){
            e.printStackTrace();
        }

        return res;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        collableDb ob = new collableDb();
        System.out.println("the addition is "+ob.callCalculate(num1, num2));
        // sc.close();


    }
}