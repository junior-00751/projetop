package security;

import lombok.RequiredArgsConstructor;
import model.Usuario;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getRole()) // ou .authorities()
                .build();
    }
}
