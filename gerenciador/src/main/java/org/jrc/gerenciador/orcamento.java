package org.jrc.gerenciador;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Orcamento {
    private final SimpleStringProperty servico;
    private final SimpleDoubleProperty valor; 
    private final SimpleStringProperty observacoes;
    private final SimpleBooleanProperty selecao;

    

    public Orcamento(String servico, Double valor, String observacoes) {
        this.servico = new SimpleStringProperty(servico);
        this.valor = new SimpleDoubleProperty(valor);
        this.observacoes = new SimpleStringProperty(observacoes);
        this.selecao = new SimpleBooleanProperty(false);
    }

    public String getServico() {return servico.get();}
    public Double getValor() {return valor.get();}
    public String getObservacoes() {return observacoes.get();}
    public Boolean getSelecao() {return selecao.get();}

    public SimpleStringProperty servicoProperty() {return servico;}
    public SimpleDoubleProperty valorProperty() {return valor;}
    public SimpleStringProperty observacoesProperty() {return observacoes;}
    public SimpleBooleanProperty selecaoProperty() {return selecao;}

    
}
