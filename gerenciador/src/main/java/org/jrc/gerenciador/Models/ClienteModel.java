package org.jrc.gerenciador.Models;

public class ClienteModel {
    private String nome;
    private String cpf_cnpj;
    private String Endereco; 
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String tipoImovel; 
    private String telefone;
    private String observacoes; 


    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {return cpf_cnpj;}

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEndereco() {return Endereco;}

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public int getNumero() {return numero;}

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {return cep;}

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoImovel() {return tipoImovel;}

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getObservacoes() {return observacoes;}

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
