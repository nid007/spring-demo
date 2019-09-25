package my.demo.repository;

import my.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE )
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFind() {
        Student student = studentRepository.findById(1);

        assertEquals(1, student.getId().intValue());
    }

    @Test
    public void testStudent() {
        String title = "hello";
        String titleUpdated = "world";
        //测试 insert
        Student student = new Student();
        student.setTitle(title);
        int c = studentRepository.insert(student);
        assertEquals(true,student.getId()>0);
        assertEquals(c,1);

        //测试 select
        Student findStudent = studentRepository.findById(student.getId());
        assertEquals(title,findStudent.getTitle());

        //测试 update
        student.setTitle(titleUpdated);
        studentRepository.update(student);
        Student updatedStudent = studentRepository.findById(student.getId());
        assertEquals(updatedStudent.getTitle(),titleUpdated);

        //测试 delete
        int dc = studentRepository.delete(student.getId());
        Student deletedStudent = studentRepository.findById(student.getId());
        assertEquals(true,deletedStudent==null);
        assertEquals(dc,1);

        System.out.println("======" + student.getId());
    }
}
