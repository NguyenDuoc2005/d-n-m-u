/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.duanmau.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Nguyen duoc
 */
public class JdbcHelper {
     
    //start 
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=DUANMAU";
    private static String user = "sa";
    private static String pass = "123456";
    // nạp driver 
    static {
        try {
           Class.forName(driver);
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);  
        }
    }
    // xây dựng preparestatement
    public static PreparedStatement getStmt(String sql , Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null; 
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }else {
            pstmt = connection.prepareStatement(sql);   
        }
        for(int i = 0 ; i<  args.length; i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    // update 
    public static int update(String sql , Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate(); 
            }finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // truy vấn 
    public static ResultSet query(String sql , Object...args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException();   
        }
    }
    public static Object values(String sql , Object... args){
            try {
            ResultSet rs = query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
            return null; 
    }
    
    
}

