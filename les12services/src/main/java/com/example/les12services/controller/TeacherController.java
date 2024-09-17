package com.example.les12services.controller;

import com.example.les12services.dto.TeacherDto;
import com.example.les12services.model.Teacher;
import com.example.les12services.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getTeachers() {
        /*Dit compiled niet, want we gebruiken in de controller geen repository*/
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id) {
        TeacherDto tdto = teacherService.getTeacher(id);

        return ResponseEntity.ok(tdto);
    }
    @PostMapping
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody TeacherDto tdto, BindingResult br) {

        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = teacherService.createTeacher(tdto);
        tdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(tdto);
    }

//    @GetMapping("/before")
//    public ResponseEntity<Iterable<Teacher>> getTeachersBefore(@RequestParam LocalDate date) {
//        return ResponseEntity.ok(repos.findByDobBefore(date));
//    }
}
