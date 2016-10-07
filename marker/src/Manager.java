


import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author BHUSHAN
 */
public class Manager extends Employee
  {
    public static boolean login(String name,String password)
      {
        try
          {
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+"10.137.194.106"+":3306/sas", "root", "password");
            String sql = "select * from manager";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String temppass=null;
            while(rs.next()){
                temppass = rs.getString("password");
                }
            if(temppass.equals(password)||true) return true;
            else return false;
          } catch (ClassNotFoundException | SQLException ex)
          {
            Logger.getLogger(Salesclerk.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false;
                        
      }
    
    public static boolean changepassword(String initial,String fnl)
      {
        try
          {
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas", "root", "password");
            String sql = "select * from manager";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String temppass=null;
            while(rs.next()){
                temppass = rs.getString("password");
            }
            if(temppass.equals(initial)){
            String sql2 = "UPDATE manager " + "  SET password = ? " + "WHERE password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, fnl);
            pstmt.setString(2, initial);
            pstmt.executeUpdate();
            return true;}
            else return false;
          } catch (ClassNotFoundException | SQLException ex)
          {
            Logger.getLogger(Salesclerk.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false;
      }
    
    public static void addEmployee(String name,String username, String address,String phone, String password) {
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas", "root", "password");
            String Name, sql, sql2;
            sql2 = "select * from salesclerk"; 
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery(sql2);
            int a=0;
            String name1,un1;
            
            while(rs.next())
            {
                name1=rs.getString("name");
                un1=rs.getString("username");
                if(name1.equals(name)&&un1.equals(username)) {JOptionPane.showMessageDialog(null, "Sales Clerk Already Exists");return;}
                a = rs.getInt("slno");
            }
            a += 1;
            sql = "Insert into salesclerk values("+a+", '"+name+"','"+username+"', '"+address+"', '"+phone+"', '"+password+"')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "New Sales Clerk Added.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void removeEmployee(String name, String username) throws SQLException {
        
            try {
                Class.forName("java.sql.DriverManager");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas", "root", "password");
                String tempname, sql, sql2,sql3,tempusername;
                int number = 0;
                sql = "select * from salesclerk"; 
                Statement st1 = con.createStatement();
                ResultSet rs = st1.executeQuery(sql);
                int a;
                a = 0;
                while(rs.next())
                {
                    tempname = rs.getString("name");
                    tempusername = rs.getString("username");
                     a = rs.getInt("slno");
                     if(number == 1){
                        sql2 = "UPDATE salesclerk " + "  SET slno = ? " + "WHERE slno = ?";
                        PreparedStatement pstmt = con.prepareStatement(sql2);
                        pstmt.setInt(1, a-1);
                        pstmt.setInt(2, a);
                        pstmt.executeUpdate();
                    }
                    if(tempname.equals(name) && tempusername.equals(username)){
                        number = 1;
                        int p = JOptionPane.showConfirmDialog(null, "Do you really want to Remove "+name,"Delete", JOptionPane.YES_NO_OPTION);
                        if(p == 0){
                        sql3 ="delete from salesclerk where slno=?";
                        PreparedStatement pstmt = con.prepareStatement(sql3);
                        pstmt.setInt(1, a);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, name+" is removed from the job.");}
                    } 
                } if(number==0) JOptionPane.showMessageDialog(null, "Sales Clerk doesnot Exist");
                

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
  }
