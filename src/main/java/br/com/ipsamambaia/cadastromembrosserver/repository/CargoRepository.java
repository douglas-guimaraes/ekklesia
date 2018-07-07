package br.com.ipsamambaia.cadastromembrosserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findAll();
}
