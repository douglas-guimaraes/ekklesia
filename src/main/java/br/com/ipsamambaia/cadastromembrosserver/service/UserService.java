package br.com.ipsamambaia.cadastromembrosserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ipsamambaia.cadastromembrosserver.entity.User;
import br.com.ipsamambaia.cadastromembrosserver.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}
