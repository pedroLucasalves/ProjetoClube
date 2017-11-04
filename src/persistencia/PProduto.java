/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class PProduto {

    public void incluir(Produto prod) throws SQLException {
        //cria uma conexão para o banco
        Connection cnn = util.Conexao.getConexao();
        //cria uma intrução SQL para inserção no banco
        String sq1 = "INSERT INTO produto"
                + "(nome, valorvenda) VALUES"
                + "(?,?);";
        PreparedStatement ps = cnn.prepareStatement(sq1);
        //seta os valores para os procedimentos
        ps.setString(1, prod.getNome());
        ps.setDouble(2, prod.getValorVenda());

        ps.execute();

        String sq2 = "SELECT currval('pedido_codigo_seq') as codigo;";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq2);

        if (rs.next()) {
            int codigo = rs.getInt("codigo");
            prod.setCodigo(codigo);
        }
        rs.close();
        cnn.close();
        ps.close();
    }

    public void alterar(Produto prod) throws SQLException {
        String sq1 = " UPDATE produto SET nome = ?, valorvenda = ? WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setString(1, prod.getNome());
        psd.setDouble(2, prod.getValorVenda());
        psd.setInt(3, prod.getCodigo());

        psd.execute();

        cnn.close();
        psd.close();
    }

    public void excluir(int codigo) throws SQLException {
        String sq1 = "DELETE FROM produto WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        psd.execute();

        psd.close();
        cnn.close();
    }

    public Produto consultar(int codigo) throws SQLException {
        String sq1 = "SELECT * FROM produto WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        Produto objeto = null;
        if (rs.next()) {
            objeto = new Produto();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setNome(rs.getString("nome"));
            objeto.setValorVenda(rs.getDouble("valorvenda"));
        }
        psd.close();
        cnn.close();
        rs.close();
        return objeto;
    }
    public ArrayList<Produto> listar()throws SQLException {
        String sq1 = "SELECT * FROM produto ORDER BY codigo;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq1);
        
        ArrayList<Produto> lista =  new ArrayList<Produto>();
        while(rs.next()){
            Produto objeto = new Produto();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setNome(rs.getString("nome"));
            objeto.setValorVenda(rs.getDouble("valorvenda"));
            lista.add(objeto);
        }
        stm.close();
        cnn.close();
        rs.close();
        return lista;
    }
}
