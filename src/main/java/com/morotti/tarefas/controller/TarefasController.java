package com.morotti.tarefas.controller;

import com.morotti.tarefas.entity.TarefasEntity;
import com.morotti.tarefas.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    @Autowired
    private TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasEntity> criarTarefa(@RequestBody TarefasEntity entity){
        TarefasEntity tarefa = tarefasService.criarTarefa(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefasEntity>> findAll(){
        List<TarefasEntity> entities = tarefasService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefasEntity> buscarPorId(@PathVariable Long id){
        try {
            TarefasEntity entity = tarefasService.buscaPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        tarefasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
