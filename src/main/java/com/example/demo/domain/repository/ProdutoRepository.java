package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
