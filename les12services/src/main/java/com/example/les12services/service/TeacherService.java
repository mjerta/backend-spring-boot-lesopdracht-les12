package com.example.les12services.service;

import com.example.les12services.dto.TeacherDto;
import com.example.les12services.dto.TeachersMapper;
import com.example.les12services.exception.DuplicateNamesFound;
import com.example.les12services.exception.ResourceNotFoundException;
import com.example.les12services.model.Teacher;
import com.example.les12services.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeachersMapper teachersMapper;

    public TeacherService(TeacherRepository teacherRepository, TeachersMapper teachersMapper) {
        this.teacherRepository = teacherRepository;
        this.teachersMapper = teachersMapper;
    }

    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teachersMapper::toDto).collect(Collectors.toList());
    }

    public Long createTeacher(TeacherDto tdto) {
        boolean existingTeacher =  teacherRepository.existsTeacherByFirstNameAndLastName(tdto.getFirstName(), tdto.getLastName());
        if(existingTeacher) {
            throw new DuplicateNamesFound("The following combination is already found " + tdto.getFirstName() + " " +  tdto.getLastName());
        }

        // mapping
        Teacher t = new Teacher();
        t.setFirstName(tdto.firstName);
        t.setLastName(tdto.lastName);
        t.setDob(tdto.dob);
        t.setSalary(tdto.getSalary());

        teacherRepository.save(t);

        return t.getId();
    }

    public TeacherDto getTeacher(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        // mapping
        TeacherDto tdto = new TeacherDto();
        tdto.id = t.getId();
        tdto.firstName = t.getFirstName();
        tdto.lastName = t.getLastName();
        tdto.dob = t.getDob();

        return tdto;
    }
}
