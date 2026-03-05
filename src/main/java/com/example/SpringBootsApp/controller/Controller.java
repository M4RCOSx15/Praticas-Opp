package com.example.SpringBootsApp.controller;

import com.example.SpringBootsApp.entity.Product;
import com.example.SpringBootsApp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teste")
public class Controller {
    private final Service service;
    @Autowired
    public Controller(Service service){
        this.service = service;
    }
    @PostMapping("/salvar")
        public ResponseEntity<String> Salvar(@RequestBody Product product){
        Product NovoProd = service.Salvar(product);
        return ResponseEntity.ok("Produto cadastrado com sucesso \n"+NovoProd.toString());
    }
    @DeleteMapping("/delete/All")
    public ResponseEntity<String> DeletarAll(){
        service.DeleteAll();
        return ResponseEntity.ok("Todos os dados foram deletados ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Deletar(@PathVariable Long id){

        if(service.Ler(id).isPresent()){
            service.Delete(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/Ler/{id}")
    public ResponseEntity<Product> Ler(@PathVariable Long id){
        Optional<Product> NovoProd= service.Ler(id);
        return NovoProd.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> Atualizar(@RequestBody Product product, @PathVariable Long id){
        Product NovoProd = service.Atualizar(product, id);
        return ResponseEntity.ok("Produto atualizado com sucesso\n"+NovoProd.toString());
    }
    @GetMapping("/lerall")
    public List<Product> LerAll(){
        return service.LerAll();
    }


}
