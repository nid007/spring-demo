package demo;

import my.starter.MyLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Valid
public class HelloController {
    private String _abc;

    @Value("${test.msg:test2}")
    private String msg;

    @RequestMapping("/")
    @MyLog
    public String index(HttpServletRequest request) {
        return "Greetings from Spring Boot! 0.2.0" + msg;
    }

}
