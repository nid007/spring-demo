package my.demo.repository;

import my.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentRepository {

    Student findById(int id);
    int insert(Student student);
    int update(Student student);
    int delete(int id);
}
