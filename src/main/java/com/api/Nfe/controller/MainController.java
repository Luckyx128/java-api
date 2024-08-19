package com.api.Nfe.controller;

import com.api.Nfe.model.Produtos;
import com.api.Nfe.repository.Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controller")
public class MainController {
    @Autowired
    private Repository repository;

    private final List<Produtos> produtos = new ArrayList<>();

    @GetMapping
    public List<Produtos> listarProdutos() {
        return repository.findAll();
    }

    @PostMapping
    public Produtos adicionarProduto(@RequestBody @NotNull Produtos produto) {

        return repository.save(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produtos> obterProduto(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
