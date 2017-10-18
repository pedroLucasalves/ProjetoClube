/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Associado;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PAssociado;


/**
 *
 * @author Pedro
 */
public class NAssociado {
    
    PAssociado per;

    public NAssociado() {
        per = new PAssociado();
    }

    public void salvar(Associado asso) throws SQLException {
        if (asso.getCodigo() == 0) {
            per.incluir(asso);
        } else {
            per.alterar(asso);
        }
    }

    public void excluir(int codigo) throws SQLException {
        per.excluir(codigo);
    }

    public Associado consultar(int codigo) throws SQLException {
        return per.consultar(codigo);
    }

    public ArrayList<Associado> listar() throws SQLException {
        return per.listar();
    }
}
