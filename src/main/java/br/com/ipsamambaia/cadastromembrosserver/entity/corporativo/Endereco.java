package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mockito.NotExtensible;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "endereco", schema = "corporativo")
@ApiModel(description = "Repesenta o endereço de um membro")
public class Endereco extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do endereço")
    @Id
    @SequenceGenerator(name = "corporativo.sq_endereco", sequenceName = "corporativo.sq_endereco", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_endereco", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "CEP")
    @NotBlank
    @Size(min = 8, max = 8)
    @Column(name = "cep")
    private String cep;
    
    @ApiModelProperty(notes = "Número (se houver)")
    @Size(max = 15)
    @Column(name = "numero")
    private String numero;
    
    @ApiModelProperty(notes = "Rua (ou logradouro)")
    @NotBlank
    @Size(min = 1, max = 150)
    @Column(name = "rua")
    private String rua;
    
    @ApiModelProperty(notes = "Complemento (se houver)")
    @Size(max = 150)
    @Column(name = "complemento")
    private String complemento;
    
    @ApiModelProperty(notes = "Ponto de referência")
    @Size(max = 150)
    @Column(name = "ponto_referencia")
    private String pontoReferencia;
    
    @ApiModelProperty(notes = "UF")
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "uf")
    private UF uf;
    
    @ApiModelProperty(notes = "Cidade")
    @NotBlank
    @Size(min = 1, max = 150)
    @Column(name = "cidade")
    private String cidade;
    
    @ApiModelProperty(notes = "Bairro")
    @NotBlank
    @Size(min = 1, max = 150)
    @Column(name = "bairro")
    private String bairro;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
    
}
