package com.example.ExpenseTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseTracker.dto.ExpenseDTO;
import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.services.expense.ExpenseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?>postExpense(@RequestBody ExpenseDTO dto){
        Expense createdExpense = expenseService.postExpense(dto); 
        if(createdExpense != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);

        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")
        public ResponseEntity<?> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getExpensesById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(expenseService.getExpenseById(id));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING WENT WRONG");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@PathVariable Long id,@RequestBody ExpenseDTO dto){
      try{
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
      }catch(EntityNotFoundException ex){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
      }
      catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
      }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){
        try{
          expenseService.deleteExpense(id);
          return ResponseEntity.ok(null);
        }catch(EntityNotFoundException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
      }

      
    
}