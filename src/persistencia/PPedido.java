/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

public class PPedido {

    public void incluir(Pedido parametro) throws SQLException {
        try {

            Connection cnn = util.Conexao.getConexao();
            String sq1 = "INSERT INTO pedido"
                    + "SET datahorapedido = now(),"
                    + "valortotal = ? WHERE = ?;";
            PreparedStatement ps = cnn.prepareStatement(sq1);

            ps.setDouble(1, parametro.getValorTotal());
            ps.setDate(2, (Date) parametro.getDataHoraPedido());

            ps.execute();

            String sq2 = "SELECT currval('identificador') as codigo;";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sq2);

            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                parametro.setIdentificador(codigo);
            }
            rs.close();
            ps.close();
            cnn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void alterar(Pedido parametro) throws SQLException {
        String sq1 = "UPDATE pedido SET valortotal = ? ,datahorapedido = ? , WHERE identificador = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setDouble(1, (double) parametro.getValorTotal());
        psd.setDate(2, (Date) parametro.getDataHoraPedido());
    }

    public void excluir(int codigo) throws SQLException {
        String sq1 = "DELETE FROM pedido WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        psd.execute();

        psd.close();
        cnn.close();
    }

    public Pedido consultar(int codigo) throws SQLException {
        String sq1 = "SELECT * FROM pedido WHERE codigo = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);
        ResultSet rs = psd.executeQuery();

        Pedido objeto = null;
        if (rs.next()) {
            objeto.setIdentificador(rs.getInt("identificador"));
            objeto.setValorTotal(rs.getDouble("valortotal"));
            objeto.setDataHoraPedido(rs.getDate("datahorapedido"));
        }
        cnn.close();
        psd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<Pedido> listar() throws SQLException {
        String sq1 = "SELECT * FROM pedido ORDEY BY codigo;";

        Connection cnn = util.Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq1);

        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        while (rs.next()) {
            Pedido objeto = new Pedido();
            objeto.setIdentificador(rs.getInt("identificador"));
            objeto.setValorTotal(rs.getDouble("valortotal"));
            objeto.setDataHoraPedido(rs.getDate("datahorapedido"));
            lista.add(objeto);
        }
        cnn.close();
        stm.close();
        rs.close();
        return lista;
    }
}
