package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

@Entity
@Table(name = "batismo", schema = "corporativo")
public class Batismo extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_batismo", sequenceName = "corporativo.sq_batismo", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_batismo", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "data")
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;
    
    @ManyToOne
    @JoinColumn(name = "id_pastor_batismo", referencedColumnName = "id")
    private Membro pastorBatismo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
    
}
