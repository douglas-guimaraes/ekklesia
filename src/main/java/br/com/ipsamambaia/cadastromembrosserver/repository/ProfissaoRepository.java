package br.com.ipsamambaia.cadastromembrosserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

    List<Profissao> findAll();
}
