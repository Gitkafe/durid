package com.exam.durid.dao.master;

import com.exam.durid.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentMapper {

    List<Student> getAll();

}
