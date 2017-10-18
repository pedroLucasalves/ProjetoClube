/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.TipoAssociado;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PTipoAssociado;

/**
 *
 * @author Pedro
 */
public class NTipoAssociado {

    PTipoAssociado per;

    public NTipoAssociado() {
        per = new PTipoAssociado();
    }

    public void salvar(TipoAssociado tipoAssociado) throws SQLException {
        if (tipoAssociado.getCodigo() == 0) {
            per.incluir(tipoAssociado);
        } else {
            per.alterar(tipoAssociado);
        }
    }

    public void excluir(int codigo) throws SQLException {
        per.excluir(codigo);
    }

    public TipoAssociado consultar(int codigo) throws SQLException {
        return per.consultar(codigo);
    }

    public ArrayList<TipoAssociado> listar() throws SQLException {
        return per.listar();
    }
}
