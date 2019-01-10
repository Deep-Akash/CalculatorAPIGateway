package com.calculator.calculatorapigateway.model;


import com.calculator.calculatorapigateway.enums.CalculatorOperationsENUM;

import java.io.Serializable;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class CalculationRequest implements Serializable{
    private static final long serialVersionUID = 7156526077883281623L;

    private Double firstNumber;
    private Double secondNumber;
    private CalculatorOperationsENUM operation;
    private String userEmail;

    public CalculationRequest() {
    }

    public CalculationRequest(Double firstNumber, Double secondNumber, CalculatorOperationsENUM operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public CalculationRequest(Double firstNumber, Double secondNumber, CalculatorOperationsENUM operation, String userEmail) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.userEmail = userEmail;
    }

    public CalculationRequest(Double firstNumber, Double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(CalculatorOperationsENUM operation) {
        this.operation = operation;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public CalculatorOperationsENUM getOperation() {
        return operation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operation=" + operation +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
