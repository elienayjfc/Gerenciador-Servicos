package org.jrc.gerenciador;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class financeiro {
    
    private final SimpleStringProperty dtaOrcamento;
    private final SimpleStringProperty dtaServico; 
    private final SimpleStringProperty cliente; 
    private final SimpleDoubleProperty valor;
    private final SimpleStringProperty status;

    public financeiro(String dtaOrcamento,String dtaServico,String cliente,Double valor, String status) {
        this.dtaOrcamento = new SimpleStringProperty(dtaOrcamento);
        this.dtaServico = new SimpleStringProperty(dtaServico);
        this.cliente = new SimpleStringProperty(cliente);
        this.valor = new SimpleDoubleProperty(valor);
        this.status = new SimpleStringProperty(status);
    }

    public String getDtaOrcamento() {return dtaOrcamento.get();}
    public String getDtaServico() {return dtaServico.get();}
    public String getClinte() {return cliente.get();}
    public Double getValor() {return valor.get();}
    public String getStatus() {return status.get();}

    public SimpleStringProperty dtaOrcamentoProperty() {return dtaOrcamento;}
    public SimpleStringProperty dtaServicoProperty() {return dtaServico;}
    public SimpleStringProperty clienteProperty() {return cliente;}
    public SimpleDoubleProperty valorProperty() {return valor;}
    public SimpleStringProperty statusProperty() {return status;}

    
    
}
