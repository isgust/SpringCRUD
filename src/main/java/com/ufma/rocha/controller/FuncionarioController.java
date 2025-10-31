package com.ufma.rocha.controller;

import com.ufma.rocha.model.Funcionario;
import com.ufma.rocha.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;

    //Rota 01 - Create
    @PostMapping // Responde as requisições POST para a API
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        //Metodo save() herdado da Interface JPA
        return repository.save(funcionario);
    }

    //Rota 02 -  Read
    @GetMapping // Responde as requisições GET  para a API
    public List<Funcionario> listarTodos(){
        // Metodo findAll() herdado da Interface JPA
        return repository.findAll();
    }

    //Rota 03 - Read where ID Funcionario
    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        // Metodo findById herdado da Interface JPA
        return repository.findById(id).orElse(null);
    }

    //Rota 04 - Update
    @PutMapping("/{id}") // Responde as requisições PUT para a API
    public  Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario detalhesFuncionario){
        Funcionario funcionario  = repository.findById(id).orElse(null);

        if(funcionario != null){
            funcionario.setNome(detalhesFuncionario.getNome());
            funcionario.setCargo(detalhesFuncionario.getCargo());
            funcionario.setSalario(detalhesFuncionario.getSalario());
            return repository.save(funcionario);
        }

        return null;
    }

    // Rota 5: DELETE (DELETAR)
    @DeleteMapping("/{id}") // Responde a requisições DELETE para a API
    public String deletarFuncionario(@PathVariable Long id) {

        // O deleteById() deleta o registro
        repository.deleteById(id);

        return "Funcionário com ID " + id + " deletado com sucesso!";
    }

}
