package coutinho.daniel.trabalho.tarefas.model;

import coutinho.daniel.trabalho.tarefas.dto.TarefaDTO;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@Entity
public class TarefaModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    Long id;

    @Column(name="name", nullable = false)
    String nome;

    @Column(name="responsavel", nullable = false)
    String responsavel;

    @Column(name="data", nullable = false)
    Date dataEntrega;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
