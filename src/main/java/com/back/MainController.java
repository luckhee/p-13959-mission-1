package com.back;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableJpaAuditing
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
