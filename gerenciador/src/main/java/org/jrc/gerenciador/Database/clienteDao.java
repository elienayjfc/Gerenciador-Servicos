package org.jrc.gerenciador.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jrc.gerenciador.Models.ClienteModel;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class clienteDao {
    
    public void create(ClienteModel cliente) {
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO CLIENTES (NOME, CPF_CNPJ, ENDERECO, NUMERO, BAIRRO, CIDADE, CEP, TIPO_IMOVEL, TELEFONE, OBSERVACOES) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getNumero());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getTipoImovel());
            stmt.setString(9, cliente.getTelefone());
            stmt.setString(10, cliente.getObservacoes());

            stmt.executeUpdate();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Operação concluida com sucesso");
            alert.showAndWait();

            System.out.println("Dados salvos com suscesso");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setHeaderText("Houve um erro durante a execução" + e);
            alert.showAndWait();
            System.err.println("Erro ao inserir dados");
        } finally {
            connection.closeConnection(con, stmt);
        }
    }

    public List<ClienteModel> read() {
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteModel> clienteList = new ArrayList<>();

        try {
            stmt= con.prepareStatement("SELECT NOME FROM CLIENTES");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setNome(rs.getString("nome"));
                clienteList.add(cliente);
            }


        } catch (Exception e) {
            System.err.println("Erro ao carregar lista " + e);
        } finally {
            connection.closeConnection(con, stmt, rs);
        }

        return clienteList;
    }
}
