package org.jrc.gerenciador;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class HelloController {
  @FXML
  private Button newCliente;

  @FXML
  private Button orcamento;

  @FXML
  private Button financeiro;

  @FXML
  private Button nfe; 

  @FXML
  private Button exit;

  @FXML
  private void sair(ActionEvent event){
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  public void clicar(ActionEvent event){
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("client-view.fxml"));
      Parent root = loader.load();
      Scene novaTela = new Scene(root);

      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(novaTela);
      stage.setTitle("Novo Cliente");
      stage.show();

    } catch (Exception e) {
      System.err.println(e + "ERRO AO CARREGAR PAGINA");
    }

  }
  @FXML
  public void AbrirOrc(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("orcamento-view.fxml"));
      Parent root = loader.load();
      Scene telaOrc = new Scene(root);
      
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(telaOrc);
      stage.setTitle("Novo orçamento");
      stage.show();

    } catch (Exception e) {
      System.err.println(e + "ERRO AO ABRIR TELA");
    }
  
  }

  @FXML
  public void abrirFinanceiro(ActionEvent event) {
    try {
      FXMLLoader loader =  new FXMLLoader(getClass().getResource("financeiro-view.fxml"));
      Parent root = loader.load();
      Scene telaFinanceiro = new Scene(root);

      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(telaFinanceiro);
      stage.setTitle("Financeiro");
      stage.show();
      
    } catch (Exception e) {
      System.err.println("Erro ao carregar a tela" + e);
    }
  }
}
