package org.jrc.gerenciador;

import javafx.beans.property.SimpleStringProperty;

public class orcamento {
    private final SimpleStringProperty servico;
    private final SimpleStringProperty valor; 
    private final SimpleStringProperty observacoes;

    

    public orcamento(String servico, String valor, String observacoes) {
        this.servico = new SimpleStringProperty(servico);
        this.valor = new SimpleStringProperty(valor);
        this.observacoes = new SimpleStringProperty(observacoes);
    }

    public String getServico() {return servico.get();}
    public String getValor() {return valor.get();}
    public String getObservacoes() {return observacoes.get();}

    public SimpleStringProperty servicoProperty() {return servico;}
    public SimpleStringProperty valorProperty() {return valor;}
    public SimpleStringProperty observacoesProperty() {return observacoes;}

    
}
