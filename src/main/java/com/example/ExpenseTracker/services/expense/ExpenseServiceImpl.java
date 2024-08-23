package com.example.ExpenseTracker.services.expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ExpenseTracker.dto.ExpenseDTO;
import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private static final String Optional = null;
    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO) {
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).collect(Collectors.toList());
    }
     
    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
               return optionalExpense.get();
        }else{
            throw new EntityNotFoundException("Expense not present with id" + id);
        }
    }

    
    public Expense updateExpense( Long id, ExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(),expenseDTO);
        }else{
            throw new EntityNotFoundException("expense not present with id"+id);
        }
    }
 
      public void deleteExpense(Long id){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id "+id);
        }

      }

     
}
