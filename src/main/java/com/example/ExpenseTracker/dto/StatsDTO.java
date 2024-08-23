package com.example.ExpenseTracker.dto;

import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.entity.Income;

public class StatsDTO {
    private Double totalExpense;
    private Double totalIncome;
    private Income latestIncome;
    private Expense latestExpense;
    private Double balance; // Add a balance field
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;

    // Method to set the total sum of expenses
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    // Method to set the total sum of income
    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    // Method to get the total sum of expenses
    public Double getTotalExpense() {
        return totalExpense;
    }

    // Method to get the total sum of income
    public Double getTotalIncome() {
        return totalIncome;
    }

    // Method to set the latest income (Income entity)
    public void setLatestIncome(Income income) {
        this.latestIncome = income;
    }

    // Method to set the latest expense (Expense entity)
    public void setLatestExpense(Expense expense) {
        this.latestExpense = expense;
    }

    // Method to get the latest income
    public Income getLatestIncome() {
        return latestIncome;
    }

    // Method to get the latest expense
    public Expense getLatestExpense() {
        return latestExpense;
    }

    // Method to set the balance (income - expense)
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // Method to get the balance
    public Double getBalance() {
        return balance;
    }

    // Method to set the minimum income
    public void setMinIncome(Double minIncome) {
        this.minIncome = minIncome;
    }

    // Method to get the minimum income
    public Double getMinIncome() {
        return minIncome;
    }

    // Method to set the maximum income
    public void setMaxIncome(Double maxIncome) {
        this.maxIncome = maxIncome;
    }

    // Method to get the maximum income
    public Double getMaxIncome() {
        return maxIncome;
    }

    // Method to set the minimum expense
    public void setMinExpense(Double minExpense) {
        this.minExpense = minExpense;
    }

    // Method to get the minimum expense
    public Double getMinExpense() {
        return minExpense;
    }

    // Method to set the maximum expense
    public void setMaxExpense(Double maxExpense) {
        this.maxExpense = maxExpense;
    }

    // Method to get the maximum expense
    public Double getMaxExpense() {
        return maxExpense;
    }
}
