/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PPedido;

/**
 *
 * @author Pedro
 */
public class NPedido {

    PPedido ped;

    public NPedido() {
        ped = new PPedido();
    }

    public void salvar(Pedido parametro) throws SQLException {
        if (parametro.getIdentificador() == 0) {
            ped.incluir(parametro);
        } else {
            ped.alterar(parametro);
        }
    }

    public void excluir(int codigo) throws SQLException {
        ped.excluir(codigo);
    }

    public Pedido consultar(int codigo) throws SQLException {
        return ped.consultar(codigo);
    }

    public ArrayList<Pedido> listar() throws SQLException {
        return ped.listar();
    }
}
