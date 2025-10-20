package coutinho.daniel.trabalho.tarefas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name="name", nullable = false)
    String nome;

    @Column(name="responsavel", nullable = false)
    String responsavel;

    @Column(name="data", nullable = false)
    LocalDate dataEntrega;

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

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
