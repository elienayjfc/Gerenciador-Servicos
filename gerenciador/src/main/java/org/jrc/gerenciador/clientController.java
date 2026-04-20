package org.jrc.gerenciador;


import java.net.URL;
import java.util.ResourceBundle;

import org.jrc.gerenciador.Database.clienteDao;
import org.jrc.gerenciador.Models.ClienteModel;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class clientController implements Initializable{

    @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private TextField endereco;

    @FXML
    private TextField numero;

    @FXML
    private TextField bairro;

    @FXML
    private ComboBox <String> cidade;
    
    @FXML
    private TextField cep;

    @FXML
    private ComboBox <String> imovel;

    @FXML
    private TextField telefone;

    @FXML
    private TextArea observacoes;

    @FXML
    private Button salvar;

    @FXML
    private Button salvar_orcamento;

    @FXML
    private Button cancelar; 

    @FXML
    public void cancel (ActionEvent event) {
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
    public void salvar(ActionEvent event) {
        ClienteModel cliente = new ClienteModel();
        clienteDao cDao = new clienteDao();

        cliente.setNome(nome.getText());
        cliente.setCpf_cnpj(cpf.getText());
        cliente.setEndereco(endereco.getText());
        cliente.setNumero(Integer.parseInt(numero.getText()));
        cliente.setBairro(bairro.getText());
        cliente.setCidade(cidade.getValue());
        cliente.setCep(cep.getText());
        cliente.setTipoImovel(imovel.getValue());
        cliente.setTelefone(telefone.getText());
        cliente.setObservacoes(observacoes.getText());

        cDao.create(cliente);
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        ObservableList<String> listaCidade = FXCollections.observableArrayList("Vespasiano", "Belo Horizonte", "Lagoa Santa", "Santa Luzia", "Ribeirão das Neves");
        cidade.setItems(listaCidade);

        ObservableList<String> listaImovel = FXCollections.observableArrayList("Residencial","Industrial", "Comercial");
        imovel.setItems(listaImovel);
        
    }  
}