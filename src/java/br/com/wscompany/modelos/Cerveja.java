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
    private int ano;
    private boolean importada;

    public Cerveja(int codigo_cerveja, String nome, int ano) {
        this.codigo = codigo_cerveja;
        this.nome = nome;
        this.ano = ano;
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
        this.setCodigo(ano);
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

    public int getAno() {
        return ano;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    
}
