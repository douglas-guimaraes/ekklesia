package br.com.ipsamambaia.cadastromembrosserver.entity.seguranca;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Transient
    private String confirmacaoSenha;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_papel", schema = "seguranca",
            joinColumns = {
                    @JoinColumn(name = "id_usuario")
            }, inverseJoinColumns = {
            @JoinColumn(name = "id_papel")
    })
    private List<Papel> papeis;

    public Usuario() {
        // default constructor
    }

    public Usuario(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public void addPapel(Papel papel) {
        if (papeis == null) {
            this.papeis = new ArrayList<>();
        }

        this.papeis.add(papel);
    }

    public boolean isSenhasIguais() {
        return this.senha.equals(confirmacaoSenha);
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

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }
}
