package org.jrc.gerenciador.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.jrc.gerenciador.Orcamento;
import org.jrc.gerenciador.Models.orcamentoModel;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class orcamentoDao {
    
    public Boolean create(List<Orcamento> items, orcamentoModel Morca) {
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;

        try {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("INSERT INTO ORCAMENTO (CLIENTE, DATA, SERVICO_MATERIAL, VALOR, OBSERVACOES) VALUES (?, ?, ?, ? ,?)");
            stmt.setString(1, Morca.getCliente());
            stmt.setObject(2, Morca.getData());

            for (Orcamento orc : items) {
                stmt.setString(3, orc.getServico());
                stmt.setDouble(4, orc.getValor());
                stmt.setString(5, orc.getObservacoes());

                stmt.addBatch();
            }
            stmt.executeUpdate();
            stmt.executeBatch();
            con.commit();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Operação concluida com sucesso");
            alert.showAndWait();

            System.out.println("Dados salvos com suscesso");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            System.err.println(e);
            alert.setTitle("Erro");
            alert.setHeaderText("Falha durante a operação" + e);
            alert.showAndWait();
        } finally {
            connection.closeConnection(con, stmt);
        }

        return true;
    }
    
}
