package com.example;

import com.sun.net.httpserver.HttpServer;
import com.example.handlers.ApiHandler;
import java.io.IOException;
import java.net.InetSocketAddress;  

public class Main {
    public static void main(String[] args) throws IOException {
        String port = System.getenv("PORT");
        int serverPort = (port != null) ? Integer.parseInt(port) : 8000; // Fallback to 8000 if PORT is not set
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        //HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/data", new ApiHandler());
        server.setExecutor(null);
        server.start();
    }
}