package com.example.ExpenseTracker.dto;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ExpenseDTO {
    private String title;
    private LocalDate date;
    private Integer amount;
    private String category;
    private String description;
}
