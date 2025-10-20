package coutinho.daniel.trabalho.tarefas.controller;

import coutinho.daniel.trabalho.tarefas.dto.TarefaDTO;
import coutinho.daniel.trabalho.tarefas.model.TarefaModel;
import coutinho.daniel.trabalho.tarefas.repository.TarefaRepository;
import coutinho.daniel.trabalho.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/tarefas", "/tarefas/"})
public class TarefaController {

    TarefaRepository tarefaRepository;

    @Autowired
    TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaRepository tarefaRepository) {this.tarefaRepository = tarefaRepository;}

    @GetMapping
    public ResponseEntity<List<TarefaModel>> getAllTarefas(){
        return ResponseEntity.ok(tarefaRepository.findAll());
    }

    @RequestMapping(value = { "/{tarefaId}", "/{tarefaId}/" }, method = RequestMethod.GET)
    public ResponseEntity<TarefaModel> getTarefaByID(@PathVariable long tarefaId){
        return tarefaRepository.findById(tarefaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "/{tarefaId}", "/{tarefaId}/" }, method = RequestMethod.PUT)
    public ResponseEntity<TarefaModel> updateTarefaById(@PathVariable long tarefaId, @RequestBody TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = tarefaService.getTarefaModel(tarefaDTO);
        tarefaModel.setId(tarefaId);
        return ResponseEntity.ok(tarefaRepository.save(tarefaModel));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TarefaModel> insertTarefa(@RequestBody @Valid TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = tarefaService.getTarefaModel(tarefaDTO);
        TarefaModel salvo = tarefaRepository.save(tarefaModel);
        return ResponseEntity.created(URI.create("tarefas/"+salvo.getId())).body(salvo);
    }

    @RequestMapping(value = { "/{tarefaId}", "/{tarefaId}/" }, method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteTarefaById(@PathVariable long tarefaId){
        if(!tarefaRepository.existsById(tarefaId)){
            return ResponseEntity.notFound().build();
        }
        tarefaRepository.deleteById(tarefaId);
        return ResponseEntity.noContent().build();
    }
}



