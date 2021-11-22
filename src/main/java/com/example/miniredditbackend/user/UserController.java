package com.example.miniredditbackend.user;
import com.example.miniredditbackend.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private UserService userSer;

    @Autowired
    public UserController(UserService userSer){
        this.userSer = userSer;
    }

    @PostMapping("/newuser")
    public String createUser(@RequestBody UserModel newUser, HttpServletResponse response){
        int x = userSer.createUser(new User(newUser.getName(), newUser.getPassword()));
        switch (x){
            case(0):
            response.setStatus(409);
            return "User already exists!";

            case(1):
            return "User created!";

            default:
            response.setStatus(500);
            return "Something went wrong!";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser, HttpServletResponse response){
        String token = userSer.loginUser(loginUser);
        if (token == null) {
            response.setStatus(406);
            return null;
        }
        return token;
    }

    @PostMapping("/logout")
    public void logoff(@RequestBody Token token){
        userSer.logoff(token);
    }

    @PostMapping("/auth")
    public String checkAuth(@RequestBody String token){
        String x = userSer.checkAuth(token);
        return x;
    }



}
