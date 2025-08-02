package com.example.HostelManagmentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    private StudentRepositry studentRepository;

    // Save a new student
    public StudentRegistration saveStudent(StudentRegistration student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<StudentRegistration> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<StudentRegistration> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Get student by name
    public Optional<StudentRegistration> getStudentByName(String name) {
        return studentRepository.findByStudentName(name);
    }

    // Update existing student
    public StudentRegistration updateStudent(Long id, StudentRegistration updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setStudentName(updatedStudent.getStudentName());
            student.setCollegeName(updatedStudent.getCollegeName());
            student.setBranch(updatedStudent.getBranch());
            student.setClassYear(updatedStudent.getClassYear());
            student.setAge(updatedStudent.getAge());
            student.setContactNo(updatedStudent.getContactNo());
            student.setNativeAddress(updatedStudent.getNativeAddress());
            student.setParentsName(updatedStudent.getParentsName());
            student.setpContact(updatedStudent.setpContact(id));
            student.setPhotoPath(updatedStudent.getPhotoPath());
            student.setFeesPath(updatedStudent.getFeesPath());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Delete student
    public ResponseEntity<String> deleteStudent(Long id) {
        studentRepository.deleteById(id);
		return null;
    }

    public ResponseEntity<String> registerStudent(StudentRegistration student, MultipartFile photo, MultipartFile fees) {
        try {
            // Save files to disk (or cloud) - example: saving to local filesystem
            String photoPath = null;
            String feesPath = null;

            if (photo != null && !photo.isEmpty()) {
                photoPath = "uploads/photos/" + photo.getOriginalFilename();
                photo.transferTo(new java.io.File(photoPath));
            }

            if (fees != null && !fees.isEmpty()) {
                feesPath = "uploads/fees/" + fees.getOriginalFilename();
                fees.transferTo(new java.io.File(feesPath));
            }

            // Set the file paths
            student.setPhotoPath(photoPath);
            student.setFeesPath(feesPath);

            // Save student to database
            studentRepository.save(student);

            return ResponseEntity.ok("Student registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error registering student: " + e.getMessage());
        }
    }

}
