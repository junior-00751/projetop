package dto;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;
import entity.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
  private String nome;
  private String email;
  private String senha;
  private String cpf;
  private String endereco;
  private Role role;
}
