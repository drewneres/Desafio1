package com.loja.model;

public class ItemCarrinho {
    private Estoque produto;
    private int quantidade;

    public ItemCarrinho(Estoque produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e Setters
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
}
