package my.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate template;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void send() {
        template.convertAndSend("queue","hello,rabbit~" + format.format(new Date()) );
    }
    public void sendFanout() {
        template.convertAndSend("fanoutExchange","","fanout,rabbit~" + format.format(new Date()) );
    }
    public void sendTopic() {
        template.convertAndSend("exchange","topic.message","topic,rabbit~" + format.format(new Date()) );
    }

}
