package com.example.doctor_management.models.dto;

import com.example.doctor_management.models.entity.Patient;

import java.util.List;

public class PaginationResponse<Patient> {
    private List<Patient> data;
    private int totalPage;
    private long totalElement;
    private int currentPage;

    public PaginationResponse() {
    }

    public PaginationResponse(List<Patient> data, int totalPage, long totalElement, int currentPage) {
        this.data = data;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.currentPage = currentPage;
    }

    public List<Patient> getData() {
        return data;
    }

    public void setData(List<Patient> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
