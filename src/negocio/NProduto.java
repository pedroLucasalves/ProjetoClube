/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PProduto;

/**
 *
 * @author Pedro
 */
public class NProduto {

    PProduto prod;

    public NProduto() {
        prod = new PProduto();
    }

    public void salvar(Produto produto) throws SQLException {
        if (produto.getCodigo() == 0) {
            prod.incluir(produto);
        } else {
            prod.alterar(produto);
        }

    }

    public void excluir(int codigo) throws SQLException {
        prod.excluir(codigo);
    }

    public Produto consultar(int codigo) throws SQLException {
        return prod.consultar(codigo);
    }

    public ArrayList<Produto> listar() throws SQLException {
        return prod.listar();
    }
}
