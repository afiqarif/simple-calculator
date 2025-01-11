package com.example.models;

public class DataModel {
    @SuppressWarnings("unused")
    private double _resultCalc;

    public DataModel(double _num1, double _num2, String _operator) {
        if(_operator.equals("+"))
            _resultCalc = _num1 + _num2;
        else if(_operator.equals("-"))
            _resultCalc = _num1 - _num2;
        else if(_operator.equals("*"))
            _resultCalc = _num1 * _num2;
        else if(_operator.equals("/"))
            _resultCalc = _num1 / _num2;
    }

}
