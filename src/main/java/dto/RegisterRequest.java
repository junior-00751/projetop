// dto/RegisterRequest.java
package dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
}

