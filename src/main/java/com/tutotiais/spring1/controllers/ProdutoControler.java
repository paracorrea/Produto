package com.tutotiais.spring1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tutotiais.spring1.models.ProdutoModel;
import com.tutotiais.spring1.repositories.ProdutoRepository;

@RestController
public class ProdutoControler {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	// Metodo getAllProdutos para obter em uma lista todos os produtos
	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoModel>> getAllProdutos(){
		List<ProdutoModel> produtoList = produtoRepository.findAll();
		if(produtoList.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ProdutoModel>>(produtoList,HttpStatus.OK);
		}
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<ProdutoModel> getOneProdutos(@PathVariable(value="id") long id){
		Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
		
		if(!produtoO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ProdutoModel>(produtoO.get(),HttpStatus.OK);
		}
			
	}
	
}
