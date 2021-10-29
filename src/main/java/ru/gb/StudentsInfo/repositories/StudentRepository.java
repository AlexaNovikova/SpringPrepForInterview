package ru.gb.StudentsInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import ru.gb.StudentsInfo.models.Student;

import java.util.Optional;


@Component
public interface StudentRepository extends JpaRepository<Student, Long> {

        Optional<Student> findOneById(Long id);

}
