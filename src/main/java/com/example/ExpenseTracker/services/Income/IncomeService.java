package com.example.ExpenseTracker.services.Income;

import java.util.List;

import com.example.ExpenseTracker.dto.IncomeDTO;
import com.example.ExpenseTracker.entity.Income;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncomes();
    // public Income updateIncome(Long id,IncomeDTO incomeDTO );
    Object updateIncome(Long id, IncomeDTO incomeDTO);
    public IncomeDTO getIncomeById(Long id);
    public void deleteIncome(Long id);
}