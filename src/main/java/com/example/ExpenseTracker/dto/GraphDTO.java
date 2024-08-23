package com.example.ExpenseTracker.dto;

import lombok.Data;
import java.util.List;

import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.entity.Income;

@Data

public class GraphDTO{
    private List<Expense>expenseList;
    private List<Income>incomeList;
}