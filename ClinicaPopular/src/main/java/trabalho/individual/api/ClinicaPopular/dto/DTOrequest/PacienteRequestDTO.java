package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class PacienteRequestDTO{

   @NotNull(message = "O nome é obrigatório.Por favor preencha!")
   @NotBlank(message = "O nome é obrigatório.Por favor preencha! ")
   @Size(max = 100, message = "O maximo é de 100 caracteres")
   private String nome;

   @NotNull(message = "CPF é obrigatório.Por favor preencha!")
   @NotBlank(message = "CPF é obrigatório.Por favor preencha!")
   @Size(min = 14, max = 14, message = "O CFP deve conter 14 dígitos")
   @CPF(message = "Formato inválido,preencha corretamente.exemplo: 123.456.789-10")
   private String cpf;

   @NotNull(message ="Data de Nascimento é obrigatória.Por Favor preencha!" )
   private String dataNascimento;

   @NotNull(message ="O Email é obrigatório.Por Favor preencha!" )
   @NotBlank(message ="O Email é obrigatório.Por Favor preencha!" )
   @Email(message = "O email tem que estar no formato email. Exemplo: email@example.com")
   private String email;

   @NotNull(message = "O Telefone é obrigatório.Por favor preencha!")
   @NotBlank(message = "O Telefone é obrigatório.Por favor preencha!")
   private String telefone;

    public PacienteRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
