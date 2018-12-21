package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.*;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import br.com.ipsamambaia.cadastromembrosserver.util.DTOUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApiModel(value = "Cadastro básico")
public class CadastroBasicoDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do membro")
    private Long id;

    @ApiModelProperty(notes = "Nome", required = true)
    @NotBlank
    @Size(min = 1, max = 150)
    private String nome;

    @ApiModelProperty(notes = "Data de nascimento")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @ApiModelProperty(notes = "Sexo")
    private Integer sexo;

    @ApiModelProperty(notes = "CPF")
    @Size(min = 11, max = 11)
    private String cpf;

    @ApiModelProperty(notes = "Registro Geral")
    @Size(min = 1, max = 15)
    private String rg;

    @ApiModelProperty(notes = "Naturalidade")
    @Size(min = 1, max = 150)
    private String naturalidade;

    @ApiModelProperty(notes = "UF da naturalidade")
    private String ufNaturalidade;

    @ApiModelProperty(notes = "Órgão emissor do Registro Geral")
    @Size(min = 1, max = 10)
    private String orgaoEmissor;

    @ApiModelProperty(notes = "Escolaridade")
    private Integer escolaridade;

    @ApiModelProperty(notes = "Informações adicionais sobre o membro")
    @Size(max = 500)
    private String informacaoAdicional;

    @ApiModelProperty(notes = "Tipo de alocação")
    private Integer alocacao;

    @ApiModelProperty(notes = "Profissão")
    private Long profissao;

    @ApiModelProperty(notes = "Credenciais no sistema")
    private UsuarioDTO usuario;

    @ApiModelProperty(notes = "Estado civil")
    private Integer estadoCivil;

    private List<TelefoneDTO> telefones = new ArrayList<>();

    private List<EnderecoDTO> enderecos = new ArrayList<>();

    public CadastroBasicoDTO() {
        // default constructor
    }

    public CadastroBasicoDTO(Membro membro,
                             Optional<Profissao> profissao,
                             Optional<Usuario> usuario,
                             Optional<EstadoCivil> estadoCivil,
                             Optional<List<Telefone>> telefones,
                             Optional<List<Endereco>> enderecos) {
        this.id = membro.getId();
        this.nome = membro.getNome();
        this.dataNascimento = membro.getDataNascimento();
        this.sexo = membro.getSexo().getId();
        this.cpf = membro.getCpf();
        this.rg = membro.getRg();
        this.naturalidade = membro.getNaturalidade();
        this.ufNaturalidade = membro.getUfNaturalidade().getSigla();
        this.orgaoEmissor = membro.getOrgaoEmissor();
        this.escolaridade = membro.getEscolaridade().getId();
        this.informacaoAdicional = membro.getInformacaoAdicional();
        this.alocacao = membro.getAlocacao().getId();
        profissao.ifPresent(p -> this.profissao = membro.getProfissao().getId());
        usuario.ifPresent(u -> this.usuario = new UsuarioDTO(u));
        telefones.ifPresent(tels -> {
            tels.forEach(t -> this.telefones.add(new TelefoneDTO(t)));
        });
        enderecos.ifPresent(ends -> {
            ends.forEach(e -> this.enderecos.add(new EnderecoDTO(e)));
        });
    }

    public Membro toEntity(Long id) {
        Membro membro = new Membro();
        membro.setId(id);
        membro.setNome(this.nome);
        membro.setDataNascimento(this.dataNascimento);
        membro.setSexo(Sexo.fromId(this.sexo));
        membro.setNaturalidade(this.naturalidade);
        membro.setUfNaturalidade(UF.fromSigla(this.ufNaturalidade));
        membro.setRg(this.rg);
        membro.setCpf(this.cpf);
        membro.setOrgaoEmissor(this.orgaoEmissor);
        membro.setEscolaridade(TipoEscolaridade.fromId(this.escolaridade));
        membro.setInformacaoAdicional(this.informacaoAdicional);
        membro.setAlocacao(TipoAlocacao.fromId(this.alocacao));
        membro.setProfissao(new Profissao(this.profissao));
        if (DTOUtil.valid(this.usuario)) {
            membro.setUsuario(new Usuario(this.usuario.getId(),
                    this.usuario.getEmail(), this.usuario.getSenha()));
        }
        return membro;
    }

    public Optional<EstadoCivil> toEstadoCivilEntity(Membro membro) {
        if (this.estadoCivil != null) {
            return Optional.of(new EstadoCivilDTO().toEntity(membro, this.estadoCivil));
        }

        return Optional.empty();
    }

    public Optional<List<Telefone>> toTelefonesEntities(Membro membro) {
        Stream<Telefone> telefoneStream = this.telefones.stream()
                .map(t -> t.toEntity(membro));

        return Optional.of(telefoneStream.collect(Collectors.toList()));
    }

    public Optional<List<Endereco>> toEnderecosEntities(Membro membro) {
        Stream<Endereco> enderecosStream = this.enderecos.stream()
                .map(e -> e.toEntity(membro));

        return Optional.of(enderecosStream.collect(Collectors.toList()));
    }

    @Override
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

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getUfNaturalidade() {
        return ufNaturalidade;
    }

    public void setUfNaturalidade(String ufNaturalidade) {
        this.ufNaturalidade = ufNaturalidade;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public Integer getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Integer alocacao) {
        this.alocacao = alocacao;
    }

    public Long getProfissao() {
        return profissao;
    }

    public void setProfissao(Long profissao) {
        this.profissao = profissao;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
