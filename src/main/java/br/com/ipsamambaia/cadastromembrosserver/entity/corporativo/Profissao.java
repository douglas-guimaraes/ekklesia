package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
