package br.com.ipsamambaia.cadastromembrosserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

}
