package com.mendonca;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connections on port 8080 .....");
        while(true){
            try (Socket client = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
