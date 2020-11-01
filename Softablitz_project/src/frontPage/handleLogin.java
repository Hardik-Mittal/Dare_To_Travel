/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class handleLogin implements Runnable {
    private Socket socket;
    ObjectInputStream objectInputStream;

    
    
    public handleLogin(Socket socket) {
        this.socket = socket;
        try {
              System.out.print(this);
              objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
//            e.printStackTrace();
//              System.out.println("Client Disconnected");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Login l = (Login) objectInputStream.readObject();
                System.out.println("User received");
                System.out.println(l);
            } catch (Exception e) {
                System.out.println("Client Disconnected");
//                e.printStackTrace();
                return;
            }
        }
    }


}
