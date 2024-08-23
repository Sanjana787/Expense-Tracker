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

import com.example.ExpenseTracker.dto.IncomeDTO;
import com.example.ExpenseTracker.entity.Income;
import com.example.ExpenseTracker.services.Income.IncomeService;
// import com.example.ExpenseTracker.services.Income.IncomeServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {
    private final IncomeService incomeService;
    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
        Income createdIncome=incomeService.postIncome(incomeDTO);
        if(createdIncome!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")  
    public ResponseEntity<?> getAllIncomes(){
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable Long id,@RequestBody IncomeDTO incomeDTO ){
        try{
            return ResponseEntity.ok(incomeService.updateIncome(id,incomeDTO));
        }
        catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/{id}")  
    public ResponseEntity<?> getIncomeById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        }catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
       
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long id){
        try{
            incomeService.deleteIncome(id);
            return ResponseEntity.ok(null);
        }catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
       
    }
}