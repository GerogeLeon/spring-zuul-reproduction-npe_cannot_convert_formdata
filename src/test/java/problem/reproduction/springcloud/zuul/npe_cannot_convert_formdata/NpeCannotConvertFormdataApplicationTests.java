package problem.reproduction.springcloud.zuul.npe_cannot_convert_formdata;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;


public class NpeCannotConvertFormdataApplicationTests {

    /**
     * when there is a same key in query params as in multipart, the NPE occurs
     */
    @Test
    public void reproduceProblem() throws UnirestException {
        String url = "http://localhost:8080/reproduce/post?username";//exception, because the key 'username' is the same as in multipart
//        String url = "http://localhost:8080/reproduce/post";//normal
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(url)
                .field("username", "Johnson")// there is the multipart key 'username'
                .field("aFile", new File("hello.txt"))
                .asString();


        int status = response.getStatus();
        String jsonBody = response.getBody();
        System.out.println("statusCode = " + status);
        System.out.println("responseBody = " + jsonBody);
        Assert.assertEquals(200, status);


    }


}
