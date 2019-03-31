package my.starter;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
@EnableConfigurationProperties(LogProperties.class)
public class MyAutoConfiguration extends AbstractPointcutAdvisor {
    private Pointcut pointcut;

    private Advice advice;
    @Autowired
    private LogProperties logProperties;

    @PostConstruct
    public void init() {
        log.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, MyLog.class);
        this.advice = new LogMethodInterceptor(logProperties.getExcludeArr());
        log.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

}

