package com.morotti.tarefas.service;

import com.morotti.tarefas.entity.TarefasEntity;
import com.morotti.tarefas.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {
    @Autowired
    private TarefasRepository tarefasRepository;

    public TarefasEntity criarTarefa(TarefasEntity entity){
        return tarefasRepository.save(entity);
    }

    public List<TarefasEntity> findAll(){
        return tarefasRepository.findAll();
    }

    public TarefasEntity buscaPorId(Long id){
        return tarefasRepository.findById(id).get();
    }

    public void deletar(Long id){
        tarefasRepository.deleteById(id);
    }
}
