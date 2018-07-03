package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.User;
import br.com.ipsamambaia.cadastromembrosserver.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MembroController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
