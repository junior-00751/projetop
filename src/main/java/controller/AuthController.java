package controller;

import entity.User;
import service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import dto.LoginRequest;
import dto.RegisterRequest;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
    User user = userService.register(request);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody LoginRequest request) {
    User user = userService.login(request);
    return ResponseEntity.ok(user);
  }
}