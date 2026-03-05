package com.example.SpringBootsApp.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private short idade;
    @Override
    public String toString(){
        return "{ Name:"+getNome()+
                "\n idade:"+getIdade()+
                "\n id:"+getId()+" }";
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }
}
