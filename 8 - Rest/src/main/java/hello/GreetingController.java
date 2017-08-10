package hello;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/greeting/{idUsuario}")
    public Greeting hola(@PathVariable String idUsuario){

        return new Greeting(counter.incrementAndGet(), String.format(template,idUsuario));
    }
}