package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	
}