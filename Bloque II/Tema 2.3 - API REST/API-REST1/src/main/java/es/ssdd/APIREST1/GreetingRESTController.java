package es.ssdd.APIREST1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRESTController {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World!";
    }
}