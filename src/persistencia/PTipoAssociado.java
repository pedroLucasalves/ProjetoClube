/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.sun.corba.se.spi.logging.CORBALogDomains;
import entidade.TipoAssociado;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class PTipoAssociado {

    public void incluir(TipoAssociado parametro) throws SQLException {
        // cria a conexão para o banco
        Connection cnn = util.Conexao.getConexao();
        //cria a instrução SQL para inserção no banco
        String sql = "INSERT INTO tipoassociado"
                + "(descricao, valormensalidade) VALUES"
                + "(?,?);";
        //cria o procedimento armazenado a partir da conexão
        PreparedStatement ps = cnn.prepareStatement(sql);
        //seta os valores para o procedimento
        ps.setString(1, parametro.getDescricao());
        ps.setDouble(2, parametro.getValorMensalidade());
        //executar o comando no banco de dados]
        ps.execute();
        //cria o sql para recuperar o codigo gerado
        String sq12 = "SELECT currval('tipoassociado_codigo_seq') as codigo";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sq12);

        if (rs.next()) {
            int codigo = rs.getInt("codigo");
            parametro.setCodigo(codigo);
        }
        rs.close();
        cnn.close();
    }

    public void alterar(TipoAssociado parametro) throws SQLException {
        String sql = "UPDATE tipoassociado SET descricao = ?, valormensalidade = ? WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sql);

        psd.setInt(1, parametro.getCodigo());
        psd.setDouble(2, parametro.getValorMensalidade());
        psd.setString(3, parametro.getDescricao());

        cnn.close();
        psd.close();
    }

    public void excluir(int codigo) throws SQLException {
        String sql = "DELETE FROM tipoassociado WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sql);

        psd.setInt(1, codigo);
       

        psd.execute();

        psd.close();
        cnn.close();
    }

    public TipoAssociado consultar(int codigo) throws SQLException {
        String sql = "SELECT * FROM tipoassociado WHERE codigo = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sql);
        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        TipoAssociado objeto = null;
        if (rs.next()) {
            objeto = new TipoAssociado();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValorMensalidade(rs.getDouble("valormensalidade"));
        }
        psd.close();
        rs.close();
        cnn.close();
        return objeto;
    }

    public ArrayList<TipoAssociado> listar() throws SQLException {
        String sql = "SELECT * FROM tipoassociado ORDER BY codigo;";
        Connection cnn = util.Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        ArrayList<TipoAssociado> lista = new ArrayList<TipoAssociado>();
        while (rs.next()) {
            TipoAssociado objeto = new TipoAssociado();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValorMensalidade(rs.getDouble("valormensalidade"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        cnn.close();
        return lista;

    }
}
