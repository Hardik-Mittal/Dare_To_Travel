/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Server {

    public static void main(String args[]) {
        ServerSocket serverSocket;
        Socket socket;
        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(5436);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true) {
            try {
                socket = serverSocket.accept();
                Thread t1 = new Thread(new handleLogin(socket));
                Thread t2 = new Thread(new handleNewUser(socket));
                Thread t3 = new Thread(new handleAdmin(socket));
                t1.start();
                t2.start();
                t3.start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }
    }
    public static boolean checkl = false;

    
    public void checkdblogin
            (String uname1, String pass1)
            throws IOException {

        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `user_details` WHERE `username` =? AND `password` =?";
        try {
            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname1);
            ps.setString(2, pass1);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                System.out.println("User "+uname1+" active now");
                
                Home_Screen hs = new Home_Screen(uname1);
                hs.setVisible(true);
                hs.pack();
                hs.setLocationRelativeTo(null);
//                hs.username.setText("Welcome < "+uname+ " >");
//                this.dispose();

            checkl = true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed!", HEIGHT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
            
            
     public void newuserreg
        (String firstname, String lastname, String username, String password, String email, String contact, String passwordck, String gender)
        {
        
        try{
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            
            String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
            try {
              con = (Connection) DriverManager.getConnection(databaseUrl, "root","anand1234");
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
            String insertQuery = "insert into user_details values(null,'"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+email+"','"+contact+"','"+passwordck+"','"+gender+"')";
            
            Statement stat = (Statement) con.createStatement();
            int x = stat.executeUpdate(insertQuery);
            System.out.print(x);
            
            if(x==1){
                Registration.infoMessage("Registered Successfully!", "Alert");
            }
            
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
        
     public void checkdbadmindlogin
            (String uname1, String pass1)
            throws IOException {
                
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `admin_details` WHERE `username` =? AND `password` =?";
        try {
            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname1);
            ps.setString(2, pass1);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                System.out.println("Admin "+uname1+" active now");
//                BookForm bof = new BookForm(uname1);
                AdminControl ac = new AdminControl(uname1);
                ac.setVisible(true);
                ac.pack();
                ac.setLocationRelativeTo(null);
//                hs.username.setText("Welcome < "+uname+ " >");
//                this.dispose();
                checkl=true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed!", HEIGHT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                
     }

}