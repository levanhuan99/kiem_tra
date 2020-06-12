package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3306/test";
    private static final String account="root";
    private static final String password="123456";
    private Connection connection;

    private static DBConnection dbConnection;
    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection= DriverManager.getConnection(url,account,password);
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static DBConnection getInstance(){
        if (dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return this.connection;
    }

}
