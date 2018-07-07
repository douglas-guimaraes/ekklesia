package br.com.ipsamambaia.cadastromembrosserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {

    List<EstadoCivil> findAll();
}
