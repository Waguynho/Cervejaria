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

    private int codigo;
    private String nome;
    private boolean importada;

    public Cerveja(int codigo_cerveja, String nome, Boolean importada) {
        this.codigo = codigo_cerveja;
        this.nome = nome;
        this.importada = importada;
    }
    /**
     * @return the codigo_cerveja
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param ano the codigo_cerveja to set
     */
    public void setAno(int ano) {
        this.codigo = ano;
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
