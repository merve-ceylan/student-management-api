package com.studentvalidation.controller;

import com.studentvalidation.dto.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {

    private final List<StudentDTO> students = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> registerStudent(@Valid @RequestBody StudentDTO studentDTO) {
        students.add(studentDTO);
        return ResponseEntity.ok("Student registered successfully: " + studentDTO.getName());
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    // GET single student by index (simple for demo)
    @GetMapping("/{index}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int index) {
        if (index < 0 || index >= students.size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students.get(index));
    }
    @PutMapping("/{index}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int index, @Valid @RequestBody StudentDTO studentDTO) {
        if (index < 0 || index >= students.size()) {
            return ResponseEntity.notFound().build();
        }
        students.set(index, studentDTO);
        return ResponseEntity.ok(studentDTO);
    }
    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int index) {
        if (index < 0 || index >= students.size()) {
            return ResponseEntity.notFound().build();
        }
        students.remove(index);
        return ResponseEntity.noContent().build();
    }
}

