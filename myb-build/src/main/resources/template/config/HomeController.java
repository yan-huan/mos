package ${project_name}.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {
    @RequestMapping("Home.jhtml")
    public ModelAndView home(HttpServletRequest request){
        return new ModelAndView("Home");
    }
}
