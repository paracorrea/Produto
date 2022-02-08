package com.tutotiais.spring1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutotiais.spring1.models.ProdutoModel;

// ao implementar essa interface com a anotation @Repositoty os metodos findAll(), 
// fundByID(Long id), save(S, entity), delete(S, entity) não necessitam serem implementados

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

}
