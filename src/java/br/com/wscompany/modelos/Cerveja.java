/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.modelos;

/**
 *
 * @author Wagner
 */
public class Cerveja {

    private int ano;
    private String nome;
    private boolean importada;

    public Cerveja(int ano, String nome, Boolean importada) {
        this.ano = ano;
        this.nome = nome;
        this.importada = importada;
    }
    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the importada
     */
    public Boolean getImportada() {
        return importada;
    }

    /**
     * @param importada the importada to set
     */
    public void setImportada(Boolean importada) {
        this.importada = importada;
    }
    
}
