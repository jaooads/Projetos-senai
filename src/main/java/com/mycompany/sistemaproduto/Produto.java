/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaproduto;

/**
 *
 * @author luana_gutkneckt
 */
public class Produto {

    private String codigo;
    private String marca;
    private String modelo;
    private String descrição;
    private double preço;
    private int qntEstoque;

    public Produto(String codigo, String marca, String modelo, String descrição, double preço, int qntEstoque) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descrição = descrição;
        this.preço = preço;
        this.qntEstoque = qntEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return descrição;
    }

    public double getPreco() {
        return preço;
    }

    public int getqntEstoque() {
        return qntEstoque;
    }

    public void setCodigo(String novoCodigo) {
        codigo = novoCodigo;
    }

    public void setMarca(String novaMarca) {
        marca = novaMarca;
    }

    public void setModelo(String novoModelo) {
        modelo = novoModelo;
    }

    public void setDescrição(String novaDescricao) {
        descrição = novaDescricao;
    }

    public void setPreço(double novoPreco) {
        preço = novoPreco;
    }

    public void setqntEstoque(int novaQnt) {
        qntEstoque = novaQnt;
    }

    public void mostrarinformacoes() {
        System.out.println("O código do produto é: " + codigo + ", A marca do produto é: " + marca
                + ", O modelo do produto é: " + modelo + ", A quantidade em estoque é: " + qntEstoque);
    }

    public String adicionarEstoque(int quantidade) {
        qntEstoque += quantidade;
        return quantidade + " unidades adicionadas ao estoque. " + "Nova quantidade de estoque: " + qntEstoque;
    }
}