package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "membro", schema = "corporativo")
@ApiModel(description = "Repesenta um membro")
public class Membro extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do membro")
    @Id
    @SequenceGenerator(name = "corporativo.sq_membro", sequenceName = "corporativo.sq_membro", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(notes = "Nome", required = true)
    @NotBlank
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    
    @ApiModelProperty(notes = "Data de nascimento")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @ApiModelProperty(notes = "Sexo")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_sexo")
    private Sexo sexo;
    
    @ApiModelProperty(notes = "Naturalidade")
    @Size(min = 1, max = 150)
    @Column(name = "naturalidade")
    private String naturalidade;

    @ApiModelProperty(notes = "UF da naturalidade")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "uf_naturalidade")
    private UF ufNaturalidade;

    @ApiModelProperty(notes = "Registro Geral")
    @Size(min = 1, max = 15)
    @Column(name = "rg")
    private String rg;
    
    @ApiModelProperty(notes = "Órgão emissor do Registro Geral")
    @Size(min = 1, max = 10)
    @Column(name = "orgao_emissor_rg")
    private String orgaoEmissor;
    
    @ApiModelProperty(notes = "Escolaridade")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_escolaridade")
    private TipoEscolaridade escolaridade;
    
    @ApiModelProperty(notes = "Informações adicionais sobre o membro")
    @Size(min = 0, max = 500)
    @Column(name = "info_adicional")
    private String informacaoAdicional;
    
    @ApiModelProperty(notes = "Tipo de alocação")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_alocacao")
    private TipoAlocacao alocacao;
    
    @ApiModelProperty(notes = "Profissão")
    @ManyToOne
    @JoinColumn(name = "id_profissao", referencedColumnName = "id")
    private Profissao profissao;
    
    @ApiModelProperty(notes = "Credenciais no sistema")
    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public UF getUfNaturalidade() {
        return ufNaturalidade;
    }

    public void setUfNaturalidade(UF ufNaturalidade) {
        this.ufNaturalidade = ufNaturalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public TipoEscolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(TipoEscolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public TipoAlocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(TipoAlocacao alocacao) {
        this.alocacao = alocacao;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}