/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Pedro
 */
public class ItemPedido {
    private int identificador;
    private double precoEpoca;
    private double quantidade;
    private Pedido pedido;
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ItemPedido(int identificador, double precoEpoca, double quantidade) {
        this.identificador = identificador;
        this.precoEpoca = precoEpoca;
        this.quantidade = quantidade;
    }
    
    

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getPrecoEpoca() {
        return precoEpoca;
    }

    public void setPrecoEpoca(double precoEpoca) {
        this.precoEpoca = precoEpoca;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
}
