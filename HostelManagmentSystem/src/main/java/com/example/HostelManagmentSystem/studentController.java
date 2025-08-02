package com.example.HostelManagmentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/students") // Note: This path might conflict with /api/students if both are active
public class studentController {

    @Autowired
    private studentService studentService; // Inject the service

    // Register student with photo and fee document
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(
            @RequestPart("student") StudentRegistration student,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "fees", required = false) MultipartFile fees
    ) throws IOException {
        // Delegate the logic to the studentService
        return studentService.registerStudent(student, photo, fees);
    }

    // ... (other methods in studentController, if any, should also delegate to service)
}
