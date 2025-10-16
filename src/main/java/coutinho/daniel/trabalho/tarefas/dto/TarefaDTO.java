package coutinho.daniel.trabalho.tarefas.dto;

import coutinho.daniel.trabalho.tarefas.model.TarefaModel;

import java.util.Date;

public class TarefaDTO{

    String nome;
    String responsavel;
    Date dataEntrega;

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
