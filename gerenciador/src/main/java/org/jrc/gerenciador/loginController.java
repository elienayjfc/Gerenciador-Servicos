package org.jrc.gerenciador;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class loginController {
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private Button entrar;

    @FXML
    private Button cancel;

    @FXML
    private Label mensagem;
    

    @FXML
    private void fechar (ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("Fechando Janela");
        stage.close();
    } 

    private final autenticacao autenticacao = new autenticacao();

    @FXML
    public void acess(ActionEvent event) {
        String usuario = this.login.getText();
        String Senha = this.senha.getText(); 

        if (autenticacao.validar(usuario, Senha)) {
            System.err.println("Entrou");
            mensagem.setText("Acesso permitido");
            mensagem.setStyle("-fx-text-fill: green; -fx-alignment: center; -fx-font-weight: bold");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();
                Scene novaCena = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(novaCena);
                stage.setTitle("Gerenciador");
                stage.show();

            } catch (IOException e) {
                System.err.println("Erro ao carregar nova tela:"+ e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario ou senha incorretos");
            mensagem.setText("Usuario ou senha incorretos");
            mensagem.setStyle("-fx-text-fill: red; -fx-alignment: center; -fx-font-weight: bold");
            
        }
    }



}
