package com.api.Nfe.controller;

import com.api.Nfe.model.Produtos;
import com.api.Nfe.repository.Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public Produtos obterProduto(@PathVariable Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
}
