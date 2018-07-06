package br.com.ipsamambaia.cadastromembrosserver.entity.seguranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario", schema = "seguranca")
@ApiModel(description = "Repesenta um usuário no sistema")
public class Usuario extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do usuário")
    @Id
    @SequenceGenerator(name = "seguranca.sq_usuario", sequenceName = "seguranca.sq_usuario", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seguranca.sq_usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "E-mail utilizado como credencial para acesso ao sistema")
    @Pattern(regexp = "\\w+((-|\\+|\\.)\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,})+")
    @Size(min = 1, max = 150)
    @Column(name = "email")
    private String email;
    
    @ApiModelProperty(notes = "Senha")
    @Size(min = 6, max = 45)
    @Column(name = "senha")
    private String senha;

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
