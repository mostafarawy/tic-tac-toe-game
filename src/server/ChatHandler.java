/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import clientgui.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
class ChatHandler extends Thread{

DataInputStream dis;
PrintStream ps;
 
static Vector<ChatHandler> clientsVector =
new Vector<ChatHandler>();
public ChatHandler(Socket cs) throws IOException
{
    dis = new DataInputStream(cs.getInputStream());
    ps = new PrintStream(cs.getOutputStream());
    clientsVector.add(this);
    start();
}

   @Override
    public void run()
    {
        while(true)
        {
            String str;
            try {
                str = dis.readLine();
                
                sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public void sendMessageToAll(String msg)
    {
        for(ChatHandler ch : clientsVector)
        {
            System.out.println(msg);
            ch.ps.println(msg);
        }
    }
    
    
}