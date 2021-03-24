package pl.kj.mvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    private UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    public String home(@RequestParam(name = "imie", required = false, defaultValue = "") String name,
                       @RequestParam(name = "nazwisko") String lastName,
                       @RequestParam(name = "wiek") Integer age) {
        if (name.equals("")) {
            return "redirect:err.html";
        } else {
            User user = new User(name, lastName, age);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @ResponseBody
    @RequestMapping("/users")
    public String users() {
        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user1 : userList) {
            result += user1.getFirstName() + " " + user1.getLastName() + " " + user1.getAge() + "<br/>";
        }
        return result;
    }
}
