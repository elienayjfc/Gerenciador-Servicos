package org.jrc.gerenciador;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class HelloController {
  @FXML
  private Button newCliente;

  @FXML
  private Button newAtendimento;

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


  


    
}
