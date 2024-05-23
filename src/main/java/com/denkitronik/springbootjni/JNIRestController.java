package com.denkitronik.springbootjni;

import ejemplojni.lib.JavaCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jni-service")
public class JNIRestController {
    private JavaCalculator miCalculadora;

    public JNIRestController() {
        this.miCalculadora = new JavaCalculator();
    }

    @GetMapping("/suma/{num1}/{num2}")
    public int suma(@PathVariable int num1, @PathVariable int num2){
        return miCalculadora.sum(num1, num2);
    }

}
