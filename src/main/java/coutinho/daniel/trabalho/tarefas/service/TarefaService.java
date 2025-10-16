package coutinho.daniel.trabalho.tarefas.service;

import coutinho.daniel.trabalho.tarefas.dto.TarefaDTO;
import coutinho.daniel.trabalho.tarefas.model.TarefaModel;
import coutinho.daniel.trabalho.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    public TarefaModel getTarefaModel(TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = new TarefaModel();
        tarefaModel.setNome(tarefaDTO.getNome());
        tarefaModel.setResponsavel(tarefaDTO.getResponsavel());
        tarefaModel.setDataEntrega(tarefaDTO.getDataEntrega());
        return tarefaModel;
    }

}
