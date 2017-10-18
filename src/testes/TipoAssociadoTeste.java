/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidade.TipoAssociado;
import java.sql.SQLException;
import persistencia.PTipoAssociado;

/**
 *
 * @author Pedro
 */
public class TipoAssociadoTeste {

    public static void main(String[] args) throws SQLException {
        TipoAssociado tipo = new TipoAssociado();
        PTipoAssociado per = new PTipoAssociado();
        
         //incluir na tabela
       // tipo.setDescricao("alterado");
       // tipo.setValorMensalidade(456.00);
        //per.incluir(tipo);
        
        // escluir dados da tabela
       // per.excluir(7);
        
        // altera algo da tabela
        //tipo.setDescricao("alterado");
       // tipo.setValorMensalidade(456.00);
       // tipo.setCodigo(4);
       // per.alterar(tipo);
       
        if (tipo.getCodigo() != 0);
        System.out.println("deu certo");
    }
}
