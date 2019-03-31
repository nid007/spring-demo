package my.starter;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    @MyLog
    public void test(){
        System.out.println("--test--");
    }

    @MyLog
    public void test2(){
        System.out.println("--test 2222222222222--");
    }
}
