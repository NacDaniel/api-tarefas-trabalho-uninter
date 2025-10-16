package coutinho.daniel.trabalho.tarefas.controller;

import coutinho.daniel.trabalho.tarefas.dto.TarefaDTO;
import coutinho.daniel.trabalho.tarefas.model.TarefaModel;
import coutinho.daniel.trabalho.tarefas.repository.TarefaRepository;
import coutinho.daniel.trabalho.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tarefas", "/tarefas/"})
public class TarefaController {

    TarefaRepository tarefaRepository;

    @Autowired
    TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping
    public List<TarefaModel> getAllUsers(){
        return tarefaRepository.findAll();
    }

    @RequestMapping(value = { "/{tarefaId}", "/{tarefaId}/" }, method = RequestMethod.GET)
    public TarefaModel getUserByID(@PathVariable long tarefaId){
        return tarefaRepository.findById(tarefaId).get();
    }

    @RequestMapping(value = { "/{tarefaId}", "/{tarefaId}/" }, method = RequestMethod.POST)
    public TarefaModel updateUserById(@PathVariable long tarefaId, @RequestBody TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = tarefaService.getTarefaModel(tarefaDTO);
        tarefaModel.setId(tarefaId);
        return tarefaRepository.save(tarefaModel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TarefaModel insertUser(@RequestBody TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = tarefaService.getTarefaModel(tarefaDTO);
        return tarefaRepository.save(tarefaModel);
    }

}
