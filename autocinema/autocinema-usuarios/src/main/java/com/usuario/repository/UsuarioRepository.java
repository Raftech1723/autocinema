package com.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
