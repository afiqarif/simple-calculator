package com.example.handlers;

import com.google.gson.JsonParser;
import com.example.models.DataModel;
import com.google.gson.JsonObject;

public class JsonParserClass {
    public DataModel parseJson(String jsonFile) {
        JsonObject jsonObject = JsonParser.parseString(jsonFile).getAsJsonObject();
        double _num1 = jsonObject.get("number_1").getAsDouble();
        double _num2 = jsonObject.get("number_2").getAsDouble();
        String _operator = jsonObject.get("operator").getAsString();   
        DataModel data = new DataModel(_num1, _num2, _operator);
        return data;
    }
}
