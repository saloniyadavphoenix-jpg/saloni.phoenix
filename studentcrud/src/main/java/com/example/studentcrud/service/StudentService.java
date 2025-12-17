package com.example.studentcrud.service;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // POST
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET BY ID
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // GET BY EMAIL (Custom Query)
    public Student getStudentByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    // PUT
    public Student updateStudent(Long id, Student student) {
        Student existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            return repository.save(existing);
        }
        return null;
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
