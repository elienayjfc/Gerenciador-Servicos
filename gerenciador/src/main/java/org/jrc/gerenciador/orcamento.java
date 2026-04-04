package org.jrc.gerenciador;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class orcamento {
    private final SimpleIntegerProperty item;
    private final SimpleStringProperty servico;
    private final SimpleDoubleProperty valor; 
    private final SimpleStringProperty observacoes;

    

    public orcamento(Integer item, String servico, Double valor, String observacoes) {
        this.item = new SimpleIntegerProperty(item);
        this.servico = new SimpleStringProperty(servico);
        this.valor = new SimpleDoubleProperty(valor);
        this.observacoes = new SimpleStringProperty(observacoes);
    }

    public Integer getItem() {return item.get();}
    public String getServico() {return servico.get();}
    public Double getValor() {return valor.get();}
    public String getObservacoes() {return observacoes.get();}

    public SimpleIntegerProperty itemProperty() {return item;}
    public SimpleStringProperty servicoProperty() {return servico;}
    public SimpleDoubleProperty valorProperty() {return valor;}
    public SimpleStringProperty observacoesProperty() {return observacoes;}

    
}
