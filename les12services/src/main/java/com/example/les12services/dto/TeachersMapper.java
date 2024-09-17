package com.example.les12services.dto;

import com.example.les12services.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeachersMapper {

  public Teacher toEntity(TeacherDto teacherDto) {
    Teacher teacher = new Teacher();
    teacher.setFirstName(teacherDto.getFirstName());
    teacher.setLastName(teacherDto.getLastName());
    teacher.setDob(teacherDto.getDob());
    teacher.setSalary(teacherDto.getSalary());
    return teacher;
  }


  public TeacherDto toDto(Teacher teacher) {
    TeacherDto teacherDto = new TeacherDto();
    teacherDto.setFirstName(teacher.getFirstName());
    teacherDto.setLastName(teacher.getLastName());
    teacherDto.setDob(teacher.getDob());
    teacher.setSalary(teacher.getSalary());
    return  teacherDto;
  }
}
