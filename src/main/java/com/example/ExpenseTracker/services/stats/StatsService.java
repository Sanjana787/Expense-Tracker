package com.example.ExpenseTracker.services.stats;

import com.example.ExpenseTracker.dto.GraphDTO;
import com.example.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getCharData();
    StatsDTO getStats();
    
}