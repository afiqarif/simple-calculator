package com.example.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.example.models.DataModel;
import com.google.gson.Gson;

public class ApiHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        JsonParserClass jsonParser = new JsonParserClass();

        //  Handle POST request
        if ("POST".equals(exchange.getRequestMethod())) {
            Scanner scanner = new Scanner(exchange.getRequestBody());
            StringBuilder requestBody = new StringBuilder();
            while (scanner.hasNext())
                requestBody.append(scanner.nextLine());
            scanner.close();

            System.out.println("Request Body: " + requestBody.toString());

            DataModel receivedData = jsonParser.parseJson(requestBody.toString());
            String response = gson.toJson(receivedData);
            System.out.println(response);

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "https://afiqarif.github.io");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "content-type");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        //  Handle other request
        else if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "https://afiqarif.github.io");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
            exchange.sendResponseHeaders(204, -1); // No Content
        } 

        //  Handle unsupported request
        else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
    
}
