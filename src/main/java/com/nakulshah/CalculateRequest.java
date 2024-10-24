package com.nakulshah;

public class CalculateRequest {
    int num1;
    int num2;
    String operator;

    public CalculateRequest(int num1, int num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public CalculateRequest() {
        this.num1 = 0;
        this.num2 = 0;
        this.operator = "";
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
