/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class handleNewUser implements Runnable {
    private Socket socket;
    ObjectInputStream objectInputStream;

    
    
    public handleNewUser(Socket socket) {
        this.socket = socket;
        System.out.println(this);
//        try {
//            objectInputStream = new ObjectInputStream(socket.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                NewUser1 nu = (NewUser1) objectInputStream.readObject();
                System.out.println("User received");
                System.out.println(nu);
            } catch (Exception e) {
                System.out.println("Client Disconnected");
//                e.printStackTrace();
                return;
            }
        }
    }


}
