package com.example.SpringBootsApp.service;

import com.example.SpringBootsApp.entity.Product;
import com.example.SpringBootsApp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;
    @Autowired
    public Service (Repository repository){
        this.repository=repository;
    }

    public Product Salvar(Product product){

         return repository.save(product);
    }
    public void DeleteAll(){
        repository.deleteAll();
    }
    public void Delete(Long id){
        repository.deleteById(id);
    }
    public List<Product> LerAll(){
        return  repository.findAll();
    }
    public Optional<Product> Ler(Long id){
        return repository.findById(id);
    }
    public Product Atualizar(Product productActual, Long id){
        Optional<Product> produtoatualizado = repository.findById(id);
        if(produtoatualizado.isPresent()){
            Product product = produtoatualizado.get();
            product.setNome(productActual.getNome());
            product.setIdade(productActual.getIdade());
            return repository.save(product);
        }else{
            throw new RuntimeException("Produto não encontrafo");
        }
    }

}
