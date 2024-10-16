/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistemaproduto;

/**
 *
 * @author luana_gutkneckt
 */
public class SistemaProduto {

    public static void main(String[] args) {
        //*  Produto produto1 = new Produto("001", "Dell", "top", "muito top", 3560, 10);

        //* ProdutoDAO pdao = new ProdutoDAO();
        //* pdao.inserirProduto(produto1); //*
        //* Produto produto2 = new Produto("002", "Hp", "desktop", "top", 2985, 3);
        //*ProdutoDAO pdao = new ProdutoDAO();
        //*  pdao.inserirProduto(produto2);
        //*Produto produto3 = new Produto("003", "acer", "note", "top", 3261, 10);
        //*pdao.inserirProduto(produto3);
        //Produto produto4 = new Produto("004", "Hell", "hell", "topp", 4500, 20);
        //ProdutoDAO pdao = new ProdutoDAO();
        //pdao.inserirProduto(produto4);
        // Criar um objeto Produto com os novos valores
        // Código do produto que você deseja atualizar
        String codigoDoProdutoParaAtualizar = "0002";

        // Criar uma instância do ProdutoDAO
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Chamar o método buscarProduto para obter o produto existente
        Produto produtoExistente = produtoDAO.buscarProduto(codigoDoProdutoParaAtualizar);

        // Verificar se o produto foi encontrado
        if (produtoExistente != null) {
            // Mostrar informações do produto antes da atualização
            System.out.println("Produto antes da atualização:");
            System.out.println("Código: " + produtoExistente.getCodigo());
            System.out.println("Marca: " + produtoExistente.getMarca());
            System.out.println("Modelo: " + produtoExistente.getModelo());
            System.out.println("Descrição: " + produtoExistente.getDescricao());
            System.out.println("Preço: " + produtoExistente.getPreco());
            System.out.println("Quantidade em estoque: " + produtoExistente.getqntEstoque());

            // Modificar os campos desejados do produto existente
            produtoExistente.setMarca("Mac");
            produtoExistente.setModelo("Book");
            produtoExistente.setDescrição("Charlotte meiga");
            produtoExistente.setPreço(5);
            produtoExistente.setqntEstoque(10);

            // Chamar o método atualizarProduto com o produto existente modificado
            produtoDAO.atualizarProduto(produtoExistente);

            // Mostrar informações do produto após a atualização
            System.out.println("\nProduto após a atualização:");
            System.out.println("Código: " + produtoExistente.getCodigo());
            System.out.println("Marca: " + produtoExistente.getMarca());
            System.out.println("Modelo: " + produtoExistente.getModelo());
            System.out.println("Descrição: " + produtoExistente.getDescricao());
            System.out.println("Preço: " + produtoExistente.getPreco());
            System.out.println("Quantidade em estoque: " + produtoExistente.getqntEstoque());
        } else {
            // Informar que o produto não foi encontrado
            System.out.println("Produto não encontrado.");
        }

        // Código do produto que você deseja excluir
        String codigoDoProdutoParaExcluir = "0001";

        // Chamar o método excluirProduto
        produtoDAO.excluirProduto(codigoDoProdutoParaExcluir);

        System.out.println("Produto excluído com sucesso!");
    }

}
