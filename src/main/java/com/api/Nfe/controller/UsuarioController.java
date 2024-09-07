package com.api.Nfe.controller;

import com.api.Nfe.model.Usuarios;
import com.api.Nfe.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;
    private final List<Usuarios> usuarios = new ArrayList<>();

    @GetMapping
    public List<Usuarios> listar_usuario(){
        return userRepository.findAll();
    }

    @PostMapping
    public Usuarios cadastrar_usuario(@RequestBody @NotNull Usuarios usuarios){
        return  userRepository.save(usuarios);
    }
    @GetMapping("/{id}")
    public Optional<Usuarios> consultar_usuario(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar_usuario(@PathVariable Long id){

        userRepository.deleteById(id);//Deleta o usuario do id

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario deletado com sucesso");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/autenticar")
    public boolean autenticar_usuario(@RequestBody @NotNull Usuarios usuarios){
        String nome = usuarios.getNome();
        String senha = usuarios.getSenha();
        System.out.println(nome);
        Optional<Usuarios> user = userRepository.findByNomeAndSenha(nome,senha);
        if (user.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
