package com.api.Nfe.repository;

import com.api.Nfe.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByNome(String nome);
}
