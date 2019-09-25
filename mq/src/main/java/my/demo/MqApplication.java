package my.demo;



import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);

    }


    @Bean
    public Queue queue() {
        return new Queue("queue");
    }




}
