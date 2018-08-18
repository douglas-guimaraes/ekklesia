package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Procedencia;

@Repository
public interface ProcedenciaRepository extends JpaRepository<Procedencia, Long> {

    List<Procedencia> findAll();
}
