/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import clientgui.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ahmed
 */
public class ChatServer{

ServerSocket serverSocket;
public ChatServer() throws IOException
{
serverSocket = new ServerSocket(5008);
while(true)
{
    Socket s = serverSocket.accept();
    new ChatHandler(s);
}
}
public static void main(String[] args) throws IOException
{
new ChatServer();
}
}
