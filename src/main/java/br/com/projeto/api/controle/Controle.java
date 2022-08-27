package br.com.projeto.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio repositorio;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return repositorio.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return repositorio.findAll();
    }

    @GetMapping("")
    public String mensagem(){
        return "Hello World!!";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo, " + nome + "!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
    
}
