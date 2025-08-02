package com.example.HostelManagmentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentRestcontroller {
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
	    return ResponseEntity.ok("API is working");
	}


    private final studentService studentService;

    @Autowired
    public StudentRestcontroller(studentService studentService) {
        this.studentService = studentService;
    }

    // Register student with photo and fee file
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(
            @RequestPart("student") StudentRegistration student,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "fees", required = false) MultipartFile fees
    ) throws IOException {
        return studentService.registerStudent(student, photo, fees);
    }

    // Get all students
    @GetMapping("/all")
    public List<StudentRegistration> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Optional<StudentRegistration> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Get student by name
    @GetMapping("/by-name/{name}")
    public Optional<StudentRegistration> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    // Update student
    @PutMapping("/{id}")
    public StudentRegistration updateStudent(
            @PathVariable Long id,
            @RequestBody StudentRegistration updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
}
