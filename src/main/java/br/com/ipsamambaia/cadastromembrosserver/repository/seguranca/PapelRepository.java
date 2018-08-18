package br.com.ipsamambaia.cadastromembrosserver.repository.seguranca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {

    List<Papel> findAll();
}
