package softuni.org.project00.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 18:38.
 */

@Controller
@RequestMapping("/customers")
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

}
