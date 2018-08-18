package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(value = "Usuário", description = "Repesenta um usuário no sistema")
public class UsuarioDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do usuário")
    private Long id;

    @ApiModelProperty(notes = "E-mail utilizado como credencial para acesso ao sistema")
    @Pattern(regexp = "\\w+((-|\\+|\\.)\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,})+")
    @Size(min = 1, max = 150)
    private String email;

    @ApiModelProperty(notes = "Senha")
    @Size(min = 6, max = 45)
    private String senha;

    public UsuarioDTO() {
        // default constructor
    }

    public UsuarioDTO(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public Usuario toEntity() {
        return new Usuario(this.id, this.email, this.senha);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
