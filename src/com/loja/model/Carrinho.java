package com.loja.model;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private final Map<Long, ItemCarrinho> itens = new HashMap<>();

    // Método para adicionar um produto ao carrinho
    public void adicionarProduto(Estoque produto, int quantidade) {
        if (itens.containsKey(produto.getId())) {
            ItemCarrinho item = itens.get(produto.getId());
            item.setQuantidade(item.getQuantidade() + quantidade); // Atualiza quantidade
        } else {
            itens.put(produto.getId(), new ItemCarrinho(produto, quantidade)); // Adiciona novo produto
        }
    }

    // Método para atualizar a quantidade de um produto no carrinho
    public void atualizarQuantidade(Long idProduto, int quantidade) {
        if (itens.containsKey(idProduto)) {
            ItemCarrinho item = itens.get(idProduto);
            item.setQuantidade(quantidade); // Atualiza quantidade
        }
    }

    // Método para remover um produto do carrinho
    public void removerProduto(Long idProduto) {
        itens.remove(idProduto);
    }

    // Método para calcular o valor total do carrinho
    public double calcularValorTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens.values()) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    // Método para listar os produtos no carrinho com nome e preço
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio!");
        } else {
            System.out.println("Itens no Carrinho:");
            for (ItemCarrinho item : itens.values()) {
                System.out.println("Produto: " + item.getProduto().getNome() +
                        " | Preço: R$ " + item.getProduto().getPreco() +
                        " | Quantidade: " + item.getQuantidade() +
                        " | Total: R$ " + item.getTotal());
            }
        }
    }

    // Classe interna para representar os itens no carrinho
    private static class ItemCarrinho {
        private Estoque produto;
        private int quantidade;

        public ItemCarrinho(Estoque produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Estoque getProduto() {
            return produto;
        }

        public void setProduto(Estoque produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getTotal() {
            return produto.getPreco() * quantidade;
        }
    }
}
