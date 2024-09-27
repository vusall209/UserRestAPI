package az.userrest.controller;

import az.userrest.entity.User;
import az.userrest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("u/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/c")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return userService.updateUser(id,updateUser);
    }
}
