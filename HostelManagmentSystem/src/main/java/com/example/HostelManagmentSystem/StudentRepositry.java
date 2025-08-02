package com.example.HostelManagmentSystem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends JpaRepository<StudentRegistration,Long>{

	Optional<StudentRegistration> findByStudentName(String name);

}
