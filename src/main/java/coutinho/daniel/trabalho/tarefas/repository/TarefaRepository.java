package coutinho.daniel.trabalho.tarefas.repository;

import coutinho.daniel.trabalho.tarefas.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
