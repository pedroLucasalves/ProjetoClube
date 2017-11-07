/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Associado;
import entidade.TipoAssociado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class PAssociado {

    public PAssociado(int i, String selencione) {

    }

    public PAssociado() {

    }

    public void incluir(Associado parametro) throws SQLException {
        //criando conexao com banco
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            //cria a introdução SQL para inserir no banco
            String sql = "INSERT INTO associado"
                    + "(nome, cpf, rg, fone, endereco, cod_tipoassociado) values"
                    + "(?,?,?,?,?,?);";

            //cria um procedimento que armazena a partir da conexao
            PreparedStatement ps = cnn.prepareStatement(sql);
            //seta os valores para puxa pro banco
            ps.setString(1, parametro.getNome());
            ps.setString(2, parametro.getCpf());
            ps.setString(3, parametro.getRg());
            ps.setInt(4, parametro.getFone());
            ps.setString(5, parametro.getEndereco());
            ps.setInt(6, parametro.getTipoAssociado().getCodigo());

            //executa o arquivo dentro do banco
            ps.execute();
            cnn.commit();
            //cria um sql pra recupera o codigo gerado
            String sq2 = "SELECT currval('associado_codigo_seq') as codigo";

            Statement stm = cnn.createStatement();

            ResultSet rs = stm.executeQuery(sq2);
            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                parametro.setCodigo(codigo);
            }
            rs.close();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
        cnn.close();
    }

    public void alterar(Associado parametro) throws SQLException {
        String sq1 = "UPDATE associado SET nome = ?, cpf = ?, rg = ?,"
                + "fone = ?, endereco = ?, cod_tipoassociado = ? WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(sq1);

            psd.setString(1, parametro.getNome());
            psd.setString(2, parametro.getCpf());
            psd.setString(3, parametro.getRg());
            psd.setInt(4, parametro.getFone());
            psd.setString(5, parametro.getEndereco());
            psd.setInt(6, parametro.getTipoAssociado().getCodigo());
            psd.setInt(7, parametro.getCodigo());

            psd.execute();

            psd.close();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
        cnn.close();
    }

    public void excluir(int codigo) throws SQLException {
        String sq1 = "DELETE FROM associado WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(sq1);

            psd.setInt(1, codigo);

            psd.execute();

            psd.close();
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
        cnn.close();
    }

    public Associado consultar(int codigo) throws SQLException {
        String sq1 = "SELECT * FROM associado WHERE codigo =?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        Associado objeto = null;
        if (rs.next()) {
            objeto = new Associado();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setNome(rs.getString("nome"));
            objeto.setCpf(rs.getString("cpf"));
            objeto.setRg(rs.getString("rg"));
            objeto.setFone(rs.getInt("fone"));
            objeto.setEndereco(rs.getString("endereco"));
            objeto.setTipoAssociado(new PTipoAssociado().consultar(rs.getInt("cod_tipoassociado")));

        }
        rs.close();
        cnn.close();
        psd.close();
        return objeto;
    }

    public ArrayList<Associado> listar() throws SQLException {
        String sq1 = "SELECT * FROM associado ORDER BY codigo;";
        Connection cnn = util.Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq1);

        ArrayList<Associado> lista = new ArrayList<Associado>();
        while (rs.next()) {
            Associado objeto = new Associado();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setNome(rs.getString("nome"));
            objeto.setCpf(rs.getString("cpf"));
            objeto.setRg(rs.getString("rg"));
            objeto.setFone(rs.getInt("fone"));
            objeto.setEndereco(rs.getString("endereco"));
            objeto.setTipoAssociado(new PTipoAssociado().consultar(rs.getInt("cod_tipoassociado")));
            lista.add(objeto);
        }
        stm.close();
        cnn.close();
        rs.close();
        return lista;
    }
}
