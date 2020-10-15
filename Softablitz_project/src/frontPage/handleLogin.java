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
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                login login = (login) objectInputStream.readObject();
                System.out.println("User received");
                System.out.println(login);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }


}
