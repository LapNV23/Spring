package com.example.projectdemospring.entity;

import org.junit.jupiter.api.Test;

class studentTest {
    @Test
    public void testCreateStudent(){
        Student  st = Student.builder()
                .rollNumber("A001")
                .fullName("Lap")
                .build();
        System.out.println(st);
    }
}