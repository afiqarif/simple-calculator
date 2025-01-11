package com.example;

import com.sun.net.httpserver.HttpServer;
import com.example.handlers.ApiHandler;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("192.168.0.105", 8000), 0);
        server.createContext("/api/data", new ApiHandler());
        server.setExecutor(null);
        server.start();
    }
}