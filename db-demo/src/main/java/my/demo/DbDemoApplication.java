package my.demo;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import my.demo.entity.Student;
import my.demo.repository.StudentRepository;
import my.demo.service.MyEncryptablePropertyDetector;
import my.demo.service.MyEncryptablePropertyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


/**
 * @author nid
 */
@SpringBootApplication
@RestController
@EnableEncryptableProperties
public class DbDemoApplication {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        HashMap map;
        SpringApplication.run(DbDemoApplication.class, args);
    }

    @RequestMapping("/test01")
    public Student test01(@RequestParam(value = "id", defaultValue = "1") int id) {
        Student student = studentRepository.findById(id);
        return student;
    }

    //  注册这两个bean
    @Bean(name = "encryptablePropertyDetector")
    public EncryptablePropertyDetector encryptablePropertyDetector() {
        return new MyEncryptablePropertyDetector();
    }

    @Bean(name = "encryptablePropertyResolver")
    public EncryptablePropertyResolver encryptablePropertyResolver() {
        return new MyEncryptablePropertyResolver();
    }


}
