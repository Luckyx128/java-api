package com.api.Nfe.repository;

import com.api.Nfe.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Produtos, Long> {
}
