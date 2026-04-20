package org.jrc.gerenciador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class financeiroController {
    
    @FXML
    private ComboBox <String> cliente;

    @FXML
    private DatePicker dta_ini;

    @FXML
    private DatePicker dta_fi; 

    @FXML 
    private Button buscar;

    @FXML
    private TableView <financeiro> tabela;

    @FXML
    private TableColumn <financeiro, String> dta_orcamento;

    @FXML
    private TableColumn <financeiro, String> dta_servico;

    @FXML
    private TableColumn <financeiro, String> clientes;

    @FXML
    private TableColumn <financeiro, Double> valor;

    @FXML
    private TableColumn <financeiro, String> status; 

    @FXML
    private Button exportar;

    @FXML
    private Button voltar;


    @FXML
    public void back(ActionEvent event) {
        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Gerenciador");
            stage.show();
        } catch (Exception e) {
            System.err.println("ERRO AO CARREGAR TELA" + e);
        }


    }




    
}
