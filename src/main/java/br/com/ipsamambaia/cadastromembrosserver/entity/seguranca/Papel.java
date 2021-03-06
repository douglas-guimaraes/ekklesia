package br.com.ipsamambaia.cadastromembrosserver.entity.seguranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

@Entity
@Table(name = "papel", schema = "seguranca")
public class Papel extends BaseEntity<Long> {

    public static final Papel NOME_PAPEL = new Papel(1L);

    @Id
    @SequenceGenerator(name = "seguranca.sq_papel", sequenceName = "seguranca.sq_papel", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seguranca.sq_papel", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome")
    private String nome;

    public Papel() {
        // default constructor
    }

    public Papel(Long id) {
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
