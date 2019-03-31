package my.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring boot application class
 *
 * @author nidliang
 * @date 2019/03/21
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("** Application start ** ");
        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyService service = context.getBean(MyService.class);
        service.test();
        service.test2();
    }
}
