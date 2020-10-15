/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;
import com.mysql.jdbc.PreparedStatement;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
                Thread t = new Thread(new handleLogin(socket));
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }
    }
    
    public void checkdb
            (String uname1, String pass1)
            throws IOException {
//        ObjectOutputStream objectOutputStream =
//                new ObjectOutputStream(socket.getOutputStream());
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `user_details` WHERE `username` =? AND `password` =?";
        try {
            ps = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
            
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
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed!", HEIGHT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}