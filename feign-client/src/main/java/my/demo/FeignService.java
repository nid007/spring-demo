package my.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "eurka-client",path = "/"
        ,configuration = FeignConfiguration.class
        ,fallback = FeignServiceFallback.class
        )
public interface FeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String test01(@RequestParam String name);

}