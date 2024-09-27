package az.userrest.service;

import az.userrest.entity.User;
import az.userrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updateUser) {
    User oldUser= userRepository.findById(id)
            .orElseThrow(()->new RuntimeException("User with id "+id+" not found"));

    oldUser.setUsername(updateUser.getUsername());
    oldUser.setPassword(updateUser.getPassword());
    return userRepository.save(oldUser);
    }
}
