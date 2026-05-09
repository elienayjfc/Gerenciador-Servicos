package org.jrc.gerenciador.Models;

import java.time.LocalDate;

public class orcamentoModel {
    private String cliente;
    private LocalDate data;
    private String servico_Material;
    private Double valor;
    private String observacoes; 

    public String getCliente() {return cliente;}

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {return data;}

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getServico_Material() {return servico_Material;}

    public void setServico_Material(String servico_material) {
        this.servico_Material = servico_material;
    }

    public Double getValor() {return valor;}

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacoes() {return observacoes;}

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
