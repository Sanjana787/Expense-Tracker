package com.example.ExpenseTracker.services.stats;

import com.example.ExpenseTracker.dto.GraphDTO;
import com.example.ExpenseTracker.dto.StatsDTO;
import com.example.ExpenseTracker.entity.Expense;
import com.example.ExpenseTracker.entity.Income;
import com.example.ExpenseTracker.repository.ExpenseRepository;
import com.example.ExpenseTracker.repository.IncomeRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
   private final IncomeRepository incomeRepository;
   private final ExpenseRepository expenseRepository;

   public GraphDTO getCharData() {
      LocalDate endDate = LocalDate.now();
      LocalDate startDate = endDate.minusDays(27);

      GraphDTO graphDTO = new GraphDTO();
      graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
      graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));
      return graphDTO;
   }

   public StatsDTO getStats() {
      Double totalIncome = incomeRepository.sumAllAmounts();
      Double totalExpense = expenseRepository.sumAllAmounts();

      Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
      Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

      StatsDTO statsDTO = new StatsDTO();
      statsDTO.setTotalExpense(totalExpense);
      statsDTO.setTotalIncome(totalIncome);

      optionalIncome.ifPresent(statsDTO::setLatestIncome);
      optionalExpense.ifPresent(statsDTO::setLatestExpense);

      // Set balance (total income - total expense)
      statsDTO.setBalance(totalIncome - totalExpense);

      List<Income> incomeList = incomeRepository.findAll();
      List<Expense> expenseList = expenseRepository.findAll();

      OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
      OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

      OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
      OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

      statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
      statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);

      statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
      statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);

      return statsDTO;
   }
}
