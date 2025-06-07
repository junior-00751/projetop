package service;

import entity.User;
import repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dto.LoginRequest;
import dto.RegisterRequest;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User register(RegisterRequest request) {
    User user = new User();
    user.setNome(request.getNome());
    user.setEmail(request.getEmail());
    user.setSenha(request.getSenha()); 
    user.setCpf(request.getCpf());
    user.setEndereco(request.getEndereco());
    user.setRole(request.getRole());
    return userRepository.save(user);
  }

  public User login(LoginRequest request) {
    return userRepository.findByEmail(request.getEmail())
            .filter(u -> u.getSenha().equals(request.getSenha()))
            .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
  }
}
