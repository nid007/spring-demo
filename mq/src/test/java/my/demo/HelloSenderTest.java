package my.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloSenderTest {
    @Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }
    @Test
    public void testFanout() {
        helloSender.sendFanout();
    }
    @Test
    public void testTopic(){
        helloSender.sendTopic();
    }
}