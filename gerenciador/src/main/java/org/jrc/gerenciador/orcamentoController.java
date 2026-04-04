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
//import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView <orcamento> servicos;

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

    
    @FXML
    void adicionaItem() {
        String servico = serv.getText();
        String valor = v1.getText();
        Double conver =  Double.valueOf(valor);
        String observacoes = obse.getText();

        if (!servico.isEmpty() && !valor.isEmpty() && !observacoes.isEmpty() ) {
            listaOrcamentos.add(new orcamento(null, servico, conver, observacoes));            
        }

    }

   

    @FXML
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

    @FXML
    public void Add (ActionEvent event) {
        adicionaItem();
    }

    /* @FXML
    public void initialize(){
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
        serv.setCellValueFactory(new PropertyValueFactory<>("Serviço/Material"));
        v1.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        obse.setCellValueFactory(new PropertyValueFactory<>("Observações"));

        servicos.setItems(listaOrcamentos);

    }


     */













}
