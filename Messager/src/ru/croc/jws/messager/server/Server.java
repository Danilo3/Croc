package ru.croc.jws.messager.server;

import ru.croc.jws.messager.common.Chat;
import ru.croc.jws.messager.common.GroupChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Server {

    private Chat chat = new GroupChat("main");

    ArrayList<Chat> chats = new ArrayList<>();

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public static void main(String[] args) throws IOException {
        try( ServerSocket server = new ServerSocket(7777)) {
           while(true) {
               try (Socket socket = server.accept()) {
                   InputStream in = socket.getInputStream();
                   // OutputStream out = socket.getOutputStream();

                   Scanner s = new Scanner(in);
                   if(!s.hasNextInt()) {
                       throw new IllegalStateException("wrong fromat");
                   }

                   int command = s.nextInt();
                   switch (command){
                       case 0: { // send message
                           String username = s.nextLine();
                           String message = s.nextLine();

                           Date now = new Date();
                           System.out.println("" + now + " [" + username + "]: "  + message );

                           break;
                       }
                   }
               }
           }
        }
    }
}
