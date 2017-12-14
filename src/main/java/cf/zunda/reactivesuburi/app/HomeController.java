package cf.zunda.reactivesuburi.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ykonno
 * @since 2017/12/10
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/reactive")
    public String react(){
        return "reactive";
    }

}
