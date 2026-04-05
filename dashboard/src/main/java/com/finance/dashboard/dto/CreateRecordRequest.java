package com.finance.dashboard.dto;

import java.time.LocalDate;

import com.finance.dashboard.entity.RecordType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateRecordRequest {

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private RecordType type;

    private String category;

    @NotNull
    private LocalDate date;

    private String notes;

  
    public CreateRecordRequest() {
    }

    
    public CreateRecordRequest(Double amount, RecordType type, String category,
                               LocalDate date, String notes) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

   

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}