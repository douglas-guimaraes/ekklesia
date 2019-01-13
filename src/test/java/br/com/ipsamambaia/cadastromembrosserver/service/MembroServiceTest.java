package br.com.ipsamambaia.cadastromembrosserver.service;

import br.com.ipsamambaia.cadastromembrosserver.CadastroMembrosServerApplication;
import br.com.ipsamambaia.cadastromembrosserver.dto.corporativo.*;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Endereco;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Telefone;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.*;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EnderecoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EstadoCivilRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.ProfissaoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.TelefoneRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CadastroMembrosServerApplication.class)
public class MembroServiceTest {

    private static final int IMPAR = 1;
    private static final int PAR = 2;

    @Autowired
    private MembroService membroService;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private Profissao profissao1;
    private Profissao profissao2;

    @Before
    public void setup() {
        profissao1 = new Profissao();
        profissao1.setId(10L);
        profissao1.setNome("Programador");
        profissaoRepository.save(profissao1);
        profissao2 = new Profissao();
        profissao2.setId(20L);
        profissao2.setNome("Gerente de Projetos");
        profissaoRepository.save(profissao2);
    }

    @Test
    public void testarSalvarCadastroBasico() {
        CadastroBasicoDTO cadastro = membroService.save(criarCadastroBasico(IMPAR));
        assertNotNull(cadastro.getId());
        aplicarAssercoes(cadastro);
    }

    @Test
    public void testarUpdateCadastroBasico() {
        CadastroBasicoDTO cadastro = membroService.save(criarCadastroBasico(IMPAR));
        CadastroBasicoDTO cadastroAtualizado = criarCadastroBasico(PAR);
        cadastroAtualizado.setId(cadastro.getId());
        membroService.update(membroService.findById(cadastro.getId()).get(), cadastroAtualizado);
        aplicarAssercoes(cadastroAtualizado);
    }

    @Test
    public void testarDelecao() {
        CadastroBasicoDTO cadastro = membroService.save(criarCadastroBasico(PAR));
        Optional<Membro> membro = membroService.findById(cadastro.getId());
        membroService.delete(membro.get());
        assertFalse(membroService.findById(cadastro.getId()).isPresent());
    }

    private CadastroBasicoDTO criarCadastroBasico(int valor) {
        CadastroBasicoDTO cdDTO = new CadastroBasicoDTO();
        cdDTO.setNome("Membro 1 IPS" + valor);
        cdDTO.setDataNascimento(LocalDate.of(1989 + valor, 10 + valor, 25 + valor));
        cdDTO.setIdSexo(impar(valor) ? Sexo.MASCULINO.getId() : Sexo.FEMININO.getId());
        cdDTO.setCpf("1111111111" + valor);
        cdDTO.setRg("123455" + valor);
        cdDTO.setNaturalidade("Brasília" + valor);
        cdDTO.setSiglaUfNaturalidade(impar(valor) ? UF.DF.getSigla() : UF.SP.getSigla());
        cdDTO.setOrgaoEmissor("SSP/DF" + valor);
        cdDTO.setIdEscolaridade(TipoEscolaridade.ALFABETIZADO.getId());
        cdDTO.setProfissao(criarProfissao(valor));
        cdDTO.setEstadoCivil(criarEstadoCivil(valor));
        cdDTO.setTelefones(criarTelefones(valor));
        cdDTO.setEnderecos(criarEnderecos(valor));
        cdDTO.setInformacaoAdicional("Nenhuma" + valor);
        return cdDTO;
    }

    private ProfissaoDTO criarProfissao(int valor) {
        if (impar(valor)) {
            return new ProfissaoDTO(profissao1);
        } else {
            return new ProfissaoDTO(profissao2);
        }
    }

    private EstadoCivilDTO criarEstadoCivil(int valor) {
        EstadoCivilDTO estadoCivilDTO = new EstadoCivilDTO();
        estadoCivilDTO.setDataCasamento(LocalDate.of(2015 + valor, 5 + valor, 6 + valor));
        estadoCivilDTO.setEstadoCivil(impar(valor) ? TipoEstadoCivil.CASADO : TipoEstadoCivil.SOLTEIRO);
        return estadoCivilDTO;
    }

    private List<TelefoneDTO> criarTelefones(int valor) {
        TelefoneDTO tel1 = new TelefoneDTO();
        tel1.setDdd("6" + valor);
        tel1.setNumero("98765432" + valor);
        tel1.setTipoTelefone(impar(valor) ? TipoTelefone.CELULAR : TipoTelefone.FIXO);
        TelefoneDTO tel2 = new TelefoneDTO();
        tel2.setDdd("6" + valor);
        tel2.setNumero(valor + "3552266");
        tel2.setTipoTelefone(impar(valor) ? TipoTelefone.FIXO : TipoTelefone.CELULAR);
        return Arrays.asList(tel1, tel2);
    }

    private List<EnderecoDTO> criarEnderecos(int valor) {
        EnderecoDTO e1 = new EnderecoDTO();
        e1.setCep("7213045" + valor);
        e1.setBairro("Taguatinga Norte" + valor);
        e1.setCidade("Taguatinga" + valor);
        e1.setComplemento("Casa 10" + valor);
        e1.setNumero("45" + valor);
        e1.setPontoReferencia("Próximo ao shopping" + valor);
        e1.setRua("Quadra XPTO" + valor);
        e1.setUf(impar(valor) ? UF.DF : UF.RS);
        EnderecoDTO e2 = new EnderecoDTO();
        e2.setCep(valor + "1556285");
        e2.setBairro(valor + "Boa Vista");
        e2.setCidade(valor + "São Paulo");
        e2.setComplemento(valor + "Apartamento 1155");
        e2.setNumero(valor + "47");
        e2.setPontoReferencia(valor + "Ao lado da escola");
        e2.setRua(valor + "Quadra Grande");
        e2.setUf(impar(valor ) ? UF.SP: UF.PE);
        return Arrays.asList(e1, e2);
    }

    private boolean impar(int valor) {
        return valor % 2 == 1;
    }

    private void aplicarAssercoes(CadastroBasicoDTO cadastro) {
        Optional<Membro> membroDB = membroService.findById(cadastro.getId());
        assertTrue(membroDB.isPresent());
        assertEquals(membroDB.get().getId(), cadastro.getId());
        assertEquals(membroDB.get().getNome(), cadastro.getNome());
        assertEquals(membroDB.get().getDataNascimento(), cadastro.getDataNascimento());
        assertEquals(membroDB.get().getSexo(), cadastro.getSexo());
        assertEquals(membroDB.get().getNaturalidade(), cadastro.getNaturalidade());
        assertEquals(membroDB.get().getUfNaturalidade(), cadastro.getUfNaturalidade());
        assertEquals(membroDB.get().getRg(), cadastro.getRg());
        assertEquals(membroDB.get().getCpf(), cadastro.getCpf());
        assertEquals(membroDB.get().getOrgaoEmissor(), cadastro.getOrgaoEmissor());
        assertEquals(membroDB.get().getEscolaridade(), cadastro.getEscolaridade());
        assertEquals(membroDB.get().getInformacaoAdicional(), cadastro.getInformacaoAdicional());
        assertEquals(membroDB.get().getAlocacao(), cadastro.getAlocacao());
        assertEquals(membroDB.get().getProfissao().getId(), cadastro.getProfissao().getId());
        assertNotNull(estadoCivilRepository.findByMembro(membroDB.get()));

        List<Telefone> telefones = telefoneRepository.findByMembro(membroDB.get());
        assertEquals(telefones.size(), cadastro.getTelefones().size());

        List<Endereco> enderecos = enderecoRepository.findEnderecoByMembro(membroDB.get());
        assertEquals(enderecos.size(), cadastro.getEnderecos().size());
    }
}
