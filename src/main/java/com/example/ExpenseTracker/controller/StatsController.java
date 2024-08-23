package com.example.ExpenseTracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseTracker.dto.GraphDTO;
import com.example.ExpenseTracker.services.stats.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
 
    
    private final StatsService statsService;
    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getCharDetails(){
        return ResponseEntity.ok(statsService.getCharData());
    }
    @GetMapping
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }
}
