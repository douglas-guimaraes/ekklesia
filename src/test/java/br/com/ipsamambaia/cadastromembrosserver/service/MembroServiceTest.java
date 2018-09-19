package br.com.ipsamambaia.cadastromembrosserver.service;

import br.com.ipsamambaia.cadastromembrosserver.CadastroMembrosServerApplication;
import br.com.ipsamambaia.cadastromembrosserver.dto.corporativo.*;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.*;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.ProfissaoRepository;
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

    @Autowired
    private MembroService membroService;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    private Profissao profissao;

    @Before
    public void setup() {
        profissao = new Profissao();
        profissao.setId(10L);
        profissao.setNome("Programador");
        profissaoRepository.save(profissao);
    }

    @Test
    public void testarSalvarCadastroBasico() {
        CadastroBasicoDTO cadastro = membroService.save(criarCadastroBasico());
        assertNotNull(cadastro.getId());

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
    }

    private CadastroBasicoDTO criarCadastroBasico() {
        CadastroBasicoDTO cdDTO = new CadastroBasicoDTO();
        cdDTO.setNome("Membro 1 IPS");
        cdDTO.setDataNascimento(LocalDate.of(1989, 12, 25));
        cdDTO.setSexo(Sexo.MASCULINO);
        cdDTO.setCpf("11111111111");
        cdDTO.setRg("1234556");
        cdDTO.setNaturalidade("Brasília");
        cdDTO.setUfNaturalidade(UF.DF);
        cdDTO.setOrgaoEmissor("SSP/DF");
        cdDTO.setEscolaridade(TipoEscolaridade.ALFABETIZADO);
        cdDTO.setProfissao(criarProfissao());
        cdDTO.setEstadoCivil(criarEstadoCivil());
        cdDTO.setTelefones(criarTelefones());
        cdDTO.setEnderecos(criarEnderecos());
        cdDTO.setInformacaoAdicional("Nenhuma");
        return cdDTO;
    }

    private ProfissaoDTO criarProfissao() {
        return new ProfissaoDTO(profissao);
    }

    private EstadoCivilDTO criarEstadoCivil() {
        EstadoCivilDTO estadoCivilDTO = new EstadoCivilDTO();
        estadoCivilDTO.setDataCasamento(LocalDate.of(2015, 5, 6));
        estadoCivilDTO.setEstadoCivil(TipoEstadoCivil.CASADO);
        return estadoCivilDTO;
    }

    private List<TelefoneDTO> criarTelefones() {
        TelefoneDTO tel1 = new TelefoneDTO();
        tel1.setDdd("61");
        tel1.setNumero("987654321");
        tel1.setTipoTelefone(TipoTelefone.CELULAR);
        TelefoneDTO tel2 = new TelefoneDTO();
        tel2.setDdd("61");
        tel2.setNumero("33552266");
        tel2.setTipoTelefone(TipoTelefone.FIXO);
        return Arrays.asList(tel1, tel2);
    }

    private List<EnderecoDTO> criarEnderecos() {
        EnderecoDTO e1 = new EnderecoDTO();
        e1.setCep("72130450");
        e1.setBairro("Taguatinga Norte");
        e1.setCidade("Taguatinga");
        e1.setComplemento("Casa 10");
        e1.setNumero("45");
        e1.setPontoReferencia("Próximo ao shopping");
        e1.setRua("Quadra XPTO");
        e1.setUf(UF.DF);
        EnderecoDTO e2 = new EnderecoDTO();
        e2.setCep("11556285");
        e2.setBairro("Boa Vista");
        e2.setCidade("São Paulo");
        e2.setComplemento("Apartamento 1155");
        e2.setNumero("47");
        e2.setPontoReferencia("Ao lado da escola");
        e2.setRua("Quadra Grande");
        e2.setUf(UF.SP);
        return Arrays.asList(e1, e2);
    }
}
