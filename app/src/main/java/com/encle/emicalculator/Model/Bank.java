package com.encle.emicalculator.Model;

public class Bank {
    private int id;
    private String name;
    private int logo;
    private String balanceNumber;
    private String statementNumber;
    private String careNumber;

    public Bank(int id, String name, int logo, String balanceNumber, String statementNumber, String careNumber) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.balanceNumber = balanceNumber;
        this.statementNumber = statementNumber;
        this.careNumber = careNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLogo() {
        return logo;
    }

    public String getBalanceNumber() {
        return balanceNumber;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public String getCareNumber() {
        return careNumber;
    }
}
