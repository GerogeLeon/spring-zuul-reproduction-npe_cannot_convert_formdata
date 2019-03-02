package problem.reproduction.springcloud.zuul.npe_cannot_convert_formdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NpeCannotConvertFormdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(NpeCannotConvertFormdataApplication.class, args);
    }

}
