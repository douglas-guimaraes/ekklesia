package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "membro", schema = "corporativo")
public class Membro extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_membro", sequenceName = "corporativo.sq_membro", allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "tp_sexo")
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    @Column(name = "naturalidade")
    private String naturalidade;

    @Column(name = "uf_naturalidade")
    @Enumerated(EnumType.ORDINAL)
    private UF ufNaturalidade;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "orgao_emissor_rg")
    private String orgaoEmissor;

    @Column(name = "tp_escolaridade")
    @Enumerated(EnumType.ORDINAL)
    private TipoEscolaridade escolaridade;

    @Column(name = "info_adicional")
    private String informacaoAdicional;

    @Column(name = "tp_alocacao")
    @Enumerated(EnumType.ORDINAL)
    private TipoAlocacao alocacao;

    @ManyToOne
    @JoinColumn(name = "id_profissao", referencedColumnName = "id")
    private Profissao profissao;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    public Membro() {
        // default constructor
    }

    public Membro(Long id) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
