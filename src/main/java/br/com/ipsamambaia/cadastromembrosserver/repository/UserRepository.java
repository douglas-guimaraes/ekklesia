package br.com.ipsamambaia.cadastromembrosserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAll();

}
