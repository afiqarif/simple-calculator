package com.example.handlers;

import com.google.gson.JsonParser;
import com.example.models.DataModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class JsonParserClass {
    public DataModel parseJson(String jsonFile) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonFile).getAsJsonObject();

            // Check if keys exist before trying to access them
            if (!jsonObject.has("number_1") || !jsonObject.has("number_2") || !jsonObject.has("operator")) {
                System.out.println("Missing required keys in JSON: number_1, number_2, operator");
                return null; // Or throw an exception with a clear message
            }

            // Check if values are valid (number_1 and number_2 should be doubles, operator should be a string)
            double _num1 = jsonObject.get("number_1").getAsDouble();
            double _num2 = jsonObject.get("number_2").getAsDouble();
            String _operator = jsonObject.get("operator").getAsString();

            // If everything is valid, return the populated DataModel
            return new DataModel(_num1, _num2, _operator);

        } catch (JsonSyntaxException e) {
            // Catch JSON parsing errors and log them
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null; // Or throw an exception
        } catch (NumberFormatException e) {
            // Handle any invalid number format
            System.out.println("Invalid number format in JSON: " + e.getMessage());
            return null; // Or throw an exception
        } catch (Exception e) {
            // Catch other unexpected errors
            System.out.println("Error processing JSON: " + e.getMessage());
            return null; // Or throw an exception
        }
    }
}
