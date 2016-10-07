

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BHUSHAN
 */
public class Salesclerk extends Employee
  {
    public static int login(String name,String password)
      {
        int slno = 0;
        try
          {
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas", "root", "password");
            String sql = "select * from salesclerk";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String tempname,temppass;
            int number=0;
            while(rs.next()){
                tempname = rs.getString("username");
                temppass = rs.getString("password");
                slno = rs.getInt("slno");
                if(tempname.equals(name) && temppass.equals(password)){
                    number = 1;
                    break;
                }
            }
            if(number == 1) return slno;
            else return 0;
          } catch (ClassNotFoundException | SQLException ex)
          {
            Logger.getLogger(Salesclerk.class.getName()).log(Level.SEVERE, null, ex);
          }
        return 0;               
      }
    
    public static boolean changepassword(int sl,String initial,String fnl)
      {
          int tempsl;
        try
          {
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas", "root", "password");
            String sql = "select * from salesclerk";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String temppass;
            int number=0;
            while(rs.next()){
                tempsl = rs.getInt("slno");
                temppass = rs.getString("password");
                if(temppass.equals(initial) && tempsl == sl){
                    number = 1;
                    break;
                }
            }
            if(number==0) return false;
            String sql2 = "UPDATE salesclerk " + "  SET password = ? " + "WHERE password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, fnl);
            pstmt.setString(2, initial);
            pstmt.executeUpdate();
            return true;
          } catch (ClassNotFoundException | SQLException ex)
          {
            Logger.getLogger(Salesclerk.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false;
      }
    
  }
