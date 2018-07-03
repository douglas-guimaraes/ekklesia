package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

//@Entity
//@Table(name = "membro", schema = "corporativo")
public class Membro extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_membro", sequenceName = "corporativo.sq_membro", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    private String nome;
    
    private LocalDate dataNascimento;
    
    private String naturalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
