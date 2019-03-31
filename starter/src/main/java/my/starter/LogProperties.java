package my.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "mylog")
@Slf4j
public class LogProperties {

    @Value("${exclude:abc,def}")
    private String exclude;

    private String[] excludeArr;

    @PostConstruct
    public void init() {
        log.info("---LogProperties init---");
        log.info(exclude);
        this.excludeArr = StringUtils.split(exclude, ",");
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String[] getExcludeArr() {
        return excludeArr;
    }
}