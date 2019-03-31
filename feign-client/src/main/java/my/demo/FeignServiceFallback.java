package my.demo;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String test01(String name) {
        return "fallback";
    }
}
