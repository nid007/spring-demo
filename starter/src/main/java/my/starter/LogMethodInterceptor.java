package my.starter;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


import java.util.Arrays;
import java.util.List;
@Slf4j
public class LogMethodInterceptor implements MethodInterceptor {
    private List<String> exclude;

    public LogMethodInterceptor(String[] exclude) {
        this.exclude = Arrays.asList(exclude);
    }
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("=== info test");
        String methodName = invocation.getMethod().getName();
        if (exclude.contains(methodName)) {
            return invocation.proceed();
        }
        long start = System.currentTimeMillis();
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        log.info("====method({}), cost({}) ", methodName, (end - start));
        return result;
    }
}