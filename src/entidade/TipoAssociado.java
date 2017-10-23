/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author aluno
 */
public class TipoAssociado {

    public TipoAssociado() {
    }

    
    
    public TipoAssociado(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    
    private int codigo;
    private String descricao;
    private double valorMensalidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    @Override
    public String toString(){
        return this.descricao;
    }
    
    
}
