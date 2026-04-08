package org.jrc.gerenciador;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class orcamentoController {
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
    private TableView <orcamento> tabela;

    @FXML
    private TableColumn <orcamento, Integer> item; 

    @FXML
    private TableColumn <orcamento, String> serv; 

    @FXML
    private TableColumn <orcamento, Double> v1;

    @FXML
    private TableColumn <orcamento, String> obse;

    @FXML
    private Label valorT; 

    @FXML
    private Button salvar; 

    @FXML
    private Button cancelar;  

    @FXML
    private ObservableList<orcamento> listaOrcamentos = FXCollections.observableArrayList();

    
    @FXML //TODO: MÉTODO QUE FAZ O GET DOS TEXT FIELD E ADICIONA
    void adicionaItem() {
        String serv = servico.getText();
        String v1 = valor.getText();
        String observacoes = obs.getText();

        if (!serv.isEmpty() && !v1.isEmpty() && !observacoes.isEmpty() ) {
            listaOrcamentos.add(new orcamento( serv, v1, observacoes));            
        }

    }

   

    @FXML //TODO: Event que cancela orçamento e volta para tela principal
    public void cancel(ActionEvent event) {
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

    @FXML //TODO: Event que adiciona itens na tabela
    public void Add (ActionEvent event) {
        item.setCellFactory(column -> {
            return new TableCell<orcamento, Integer>() {
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
    }

    
     













}
