package com.example.ExpenseTracker.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.entity.Income;
import java.time.LocalDate;
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
     List<Expense> findByDateBetween(LocalDate startDate,LocalDate endDate);
 
      @Query("SELECT SUM(e.amount) FROM Expense e")
       Double sumAllAmounts();

       Optional<Expense> findFirstByOrderByDateDesc();
}