package com.finance.dashboard.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.FinancialRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialService {

    private final FinancialRecordRepository repo;

    public FinancialRecord create(CreateRecordRequest req, User user) {

        FinancialRecord record = new FinancialRecord();

        record.setAmount(req.getAmount());
        record.setType(req.getType());
        record.setCategory(req.getCategory());
        record.setDate(req.getDate());
        record.setNotes(req.getNotes());
        record.setCreatedBy(user);

        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public List<FinancialRecord> filter(LocalDate start, LocalDate end, String category) {

        if (start != null && end != null) {
            return repo.findByDateBetween(start, end);
        }

        if (category != null) {
            return repo.findByCategory(category);
        }

        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}