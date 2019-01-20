package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Endereco;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Endereço")
public class EnderecoDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do endereço")
    private Long id;

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    @ApiModelProperty(notes = "Número (se houver)")
    @Size(max = 15)
    private String numero;

    @ApiModelProperty(notes = "Rua (ou logradouro)")
    @NotBlank
    @Size(min = 1, max = 150)
    private String rua;

    @ApiModelProperty(notes = "Complemento (se houver)")
    @Size(max = 150)
    private String complemento;

    @ApiModelProperty(notes = "Ponto de referência")
    @Size(max = 150)
    private String pontoReferencia;

    @ApiModelProperty(notes = "UF")
    @NotNull
    private UF uf;

    @ApiModelProperty(notes = "Cidade")
    @NotBlank
    @Size(min = 1, max = 150)
    private String cidade;

    @ApiModelProperty(notes = "Bairro")
    @NotBlank
    @Size(min = 1, max = 150)
    private String bairro;
    
    private String siglaUf;

    public EnderecoDTO() {
        // default constructor
    }

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.rua = endereco.getRua();
        this.complemento = endereco.getComplemento();
        this.pontoReferencia = endereco.getPontoReferencia();
        this.siglaUf = endereco.getUf().getSigla();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
    }

    public Endereco toEntity(Membro membro) {
        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setNumero(this.numero);
        endereco.setRua(this.rua);
        endereco.setComplemento(this.complemento);
        endereco.setPontoReferencia(this.pontoReferencia);
        endereco.setUf(UF.fromSigla(this.siglaUf));
        endereco.setCidade(this.cidade);
        endereco.setBairro(this.bairro);
        endereco.setMembro(membro);
        return endereco;
    }

    @Override
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
    
    public String getSiglaUf() {
		return siglaUf;
	}
    
    public void setSiglaUF(String siglaUf) {
		this.siglaUf = siglaUf;
	}
}
