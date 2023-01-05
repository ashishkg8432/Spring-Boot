package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Ashish", "Gupta");
       // return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Ashish").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents()
    {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Ashish","Gupta"));
        students.add(new Student(2,"Gaurav","Sharma"));
        students.add(new Student(3,"Sameer","Gupta"));
        students.add(new Student(4,"Ram","Sharma"));
        return ResponseEntity.ok(students);

    }
    //to handle this kind of data use Path Variable
    //http://localhost:8080/student/2/ashish/gupta
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId,@PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName)
    {
        Student student=new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //to handle this kind of data use Request Param
    //http://localhost:8080/student?id=2&firstName=Ashish&lastName=Gupta , ?- it is called query parameter
    @GetMapping("/query")
    public Student getStudentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName)
    {
        return new Student(id,firstName,lastName);
    }
    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId)
    {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
