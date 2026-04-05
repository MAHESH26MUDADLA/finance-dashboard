package com.finance.dashboard.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.service.FinancialService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class FinancialController {

    private final FinancialService service;

   
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateRecordRequest req) {

       
        User user = new User();
        user.setId(1L);

        return ResponseEntity.ok(service.create(req, user));
    }

//get all records
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // filter
    @GetMapping("/filter")
    public ResponseEntity<?> filter(
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end,
            @RequestParam(required = false) String category) {

        return ResponseEntity.ok(service.filter(start, end, category));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}