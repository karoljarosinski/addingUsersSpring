package pl.kj.mvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    public String add(@RequestParam(name = "imie", defaultValue = "") String name,
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
    public String list() {
        List<User> userList = userRepository.getAll();
        StringBuilder builder = new StringBuilder();
        for (User user : userList) {
            builder.append(user.toString()).append("<br/>");
        }
        return builder.toString();
    }
}
