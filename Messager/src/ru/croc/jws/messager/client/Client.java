package ru.croc.jws.messager.client;

import ru.croc.jws.messager.common.Session;
import ru.croc.jws.messager.common.User;
import ru.croc.jws.messager.server.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {

//    private User user;
//
//    public Session connect(Server server){
//        // TODO
//        return new Session();
//    }

    private static final String HOST = "localhost";

    private static final int PORT = 7777;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.next();
        while(true) {
            System.out.print("> ");
            String message = scanner.next();



            if (message != null) {
                message = message.replaceAll("\n", " ");
            }
            if(message.equals(".")){
                break;
            }

            try (Socket socket = new Socket(HOST, PORT)) {
                OutputStream out = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(out);
                writer.write(Integer.toString(0));
                writer.write("\n");
                writer.write(username);
                writer.write("\n");
                writer.write(message);
                writer.write("\n");
                writer.flush();
            }
        }
    }
}
