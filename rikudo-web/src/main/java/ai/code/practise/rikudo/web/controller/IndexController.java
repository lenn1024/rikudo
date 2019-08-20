package ai.code.practise.rikudo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RestController 只能用到Spring boot里?
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello rikudo!";
    }
}
