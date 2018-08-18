package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "profissao", schema = "corporativo")
public class Profissao extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_profissao", sequenceName = "corporativo.sq_profissao", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_profissao", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Profissao() {
        // default constructor
    }

    public Profissao(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
