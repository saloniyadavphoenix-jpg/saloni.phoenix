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

    // GET
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // PUT
    public Student updateStudent(Long id, Student student) {
        Student existing = repository.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return repository.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
