package cz.cellar.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {


    private String appMode;
//constructor injection for app-mode (from application.properties)
    @Autowired
    public ViewController(Environment environment){
        appMode=environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Štěpán Cellar");
        model.addAttribute("mode", appMode );
        return "index";
    }
}
