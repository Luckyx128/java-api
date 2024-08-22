package com.api.Nfe.controller;

import com.api.Nfe.model.Produtos;
import com.api.Nfe.repository.Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <h2>Nfe Api</h2>
 * <b>Note:</b> Ler atentamente essa documentação
 * @author Lucas
 * @version 1.0
 * @since 22/08/2024
 * **/
@RestController
@RequestMapping("/api/controller")
public class MainController {

    @Autowired
    private Repository repository;
    private final List<Produtos> produtos = new ArrayList<>();
    /**
     * <b>Route</b>: "/" <br>
     * <b>Method</b>: GET<br>
     * <b>return</b> List com todos os Produtos
     */
    @GetMapping
    public List<Produtos> listarProdutos() {
        return repository.findAll();
    }
    /**
     * <b>Route</b>: "/" <br>
     * <b>Method</b>: Post<br>
     * <b>return</b>  Produto cadastrado
     * @param produto Body proveniente da requisição
     */
    @PostMapping
    public Produtos adicionarProduto(@RequestBody @NotNull Produtos produto) {

        return repository.save(produto);
    }
    /**
     * <b>Route</b>: "/{id}" <br>
     * <b>Method</b>: Get<br>
     * <b>return</b>  Produtos com id enviado
     * @param id identificação do produto desejado
     */
    @GetMapping("/{id}")
    public Optional<Produtos> obterProduto(@PathVariable Long id) {
        return repository.findById(id);
    }
    /**
     * <b>Route</b>: "/{id}" <br>
     * <b>Method</b>: Delete<br>
     * <b>return</b>  Metodo Void
     * @param id identificação do produto a ser deletado
     */
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
