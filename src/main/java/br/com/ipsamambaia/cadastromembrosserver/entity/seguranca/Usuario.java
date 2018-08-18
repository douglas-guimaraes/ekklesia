package br.com.ipsamambaia.cadastromembrosserver.entity.seguranca;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "usuario", schema = "seguranca")
public class Usuario extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "seguranca.sq_usuario", sequenceName = "seguranca.sq_usuario", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seguranca.sq_usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Usuario() {
        // default constructor
    }

    public Usuario(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
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
