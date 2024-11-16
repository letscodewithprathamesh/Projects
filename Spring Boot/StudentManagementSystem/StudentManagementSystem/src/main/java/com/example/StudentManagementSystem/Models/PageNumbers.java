package com.example.StudentManagementSystem.Models;

import org.springframework.context.annotation.Bean;

public class PageNumbers {
    private int pageNumb;

    public PageNumbers(int pageNumb) {
        this.pageNumb = pageNumb;
    }
    public PageNumbers() {

    }

    public int getPageNumbers() {
        return pageNumb;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumb = pageNumbers;
    }

    @Override
    public String toString() {
        return "PageNumbers{" +
                "pageNumbers=" + pageNumb +
                '}';
    }
}
