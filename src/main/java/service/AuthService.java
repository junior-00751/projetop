package service;

import dto.RegisterRequest;
import model.Usuario;
import repository.UserRepository;
import security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .cpf(request.getCpf())
                .endereco(request.getEndereco())
                .role("USER")
                .build();

        repository.save(usuario);

        // Cast explícito para UserDetails
        return jwtService.generateToken((UserDetails) usuario);
    }
}
