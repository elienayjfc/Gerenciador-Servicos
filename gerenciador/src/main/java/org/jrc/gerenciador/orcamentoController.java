package org.jrc.gerenciador;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class orcamentoController implements Initializable {
    @FXML
    private ComboBox <String> cliente; 

    @FXML
    private DatePicker date;

    @FXML
    private TextField servico; 

    @FXML
    private TextField valor; 

    @FXML
    private TextArea obs;

    @FXML
    private Button add;

    @FXML
    private TableView <Orcamento> tabela;

    @FXML
    private TableColumn <Orcamento, Integer> item; 

    @FXML
    private TableColumn <Orcamento, String> serv; 

    @FXML
    private TableColumn <Orcamento, String> v1;

    @FXML
    private TableColumn <Orcamento, String> obse;

    @FXML
    private TableColumn <Orcamento, Boolean> selecao;

    @FXML
    private Label valorT; 

    @FXML
    private Button salvar; 

    @FXML
    private Button cancelar;  

    @FXML
    private ObservableList<Orcamento> listaOrcamentos = FXCollections.observableArrayList();

    @FXML 
    private Button delete;
 
    @FXML //TODO: MÉTODO QUE FAZ O GET DOS TEXT FIELD E ADICIONA
    void adicionaItem() {
        String serv = servico.getText();
        String v1 = valor.getText();
        String observacoes = obs.getText();

        if (!serv.isEmpty() && !v1.isEmpty()) {
            listaOrcamentos.add(new Orcamento( serv, v1, observacoes));            
        }

    }

   

    @FXML //TODO: Event que cancela orçamento e volta para tela principal
    public void cancel(ActionEvent event) throws IOException{
        
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene TelaAnterior = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(TelaAnterior);
        stage.setTitle("Gerenciador");
        stage.show();
        
       } catch (Exception e) {
        System.err.println(e + "ERRO AO CARREGAR TELA");
       } 
    }

    //TODO: inicializa a tabela com o campo de seleção vazio
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        selecao.setCellValueFactory(new PropertyValueFactory<>("selecao"));
        selecao.setCellFactory(CheckBoxTableCell.forTableColumn(selecao)); 
        valorT.setText(somarValores());
    }

    @FXML //TODO: Event que adiciona itens na tabela
    public void Add (ActionEvent event) {
        item.setCellFactory(column -> {
            return new TableCell<Orcamento, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean vazio) {
                    super.updateItem(item, vazio);
                    if (vazio) {
                        setText(null);
                    } else {
                        setText(String.valueOf(getIndex() + 1 ));
                    }
                } 
            };
        });
        serv.setCellValueFactory(new PropertyValueFactory<>("Servico"));
        v1.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        obse.setCellValueFactory(new PropertyValueFactory<>("Observacoes"));
        

        tabela.setItems(listaOrcamentos);
        adicionaItem();
        servico.clear();
        valor.clear();
        obs.clear();
        servico.requestFocus();
        
    }
    //TODO: remove um item da tabela
    @FXML
    public void delete (ActionEvent event) {
        tabela.getItems().removeIf(orcamento -> orcamento.getSelecao());
    }

    public String somarValores() {
        
        Double ValorTotal = 0.0;
        
        
        for (Orcamento item : tabela.getItems()) {
            Double ValorConvertido = Double.parseDouble(item.getValor().replace(",", "."));
            ValorTotal += ValorConvertido;
        }
        System.out.println(ValorTotal);
        return  String.valueOf(ValorTotal);
    }
}
