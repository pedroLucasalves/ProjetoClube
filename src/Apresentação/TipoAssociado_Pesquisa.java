/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentação;

import entidade.TipoAssociado;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NTipoAssociado;

/**
 *
 * @author Pedro
 */
public class TipoAssociado_Pesquisa extends javax.swing.JInternalFrame {
    JDesktopPane jDesktoPanePrincipal;
    /**
     * Creates new form TipoAssociado_Pesquisa
     */
    public TipoAssociado_Pesquisa() {
        initComponents();
        preencherTabela();
    }
    public TipoAssociado_Pesquisa(JDesktopPane jDesktopPanePrincipal){
        this();
        
        this.jDesktoPanePrincipal = jDesktopPanePrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisar = new javax.swing.JTable();

        setTitle("´Pesquisa Tipo Associado");

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTablePesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePesquisarMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePesquisar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        try {
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTablePesquisarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePesquisarMousePressed
        try {
            int linha = jTablePesquisar.getSelectedRow();
            String codigo = jTablePesquisar.getValueAt(linha, 0).toString();
            
            TipoAssociado tipo = new NTipoAssociado().consultar(Integer.parseInt(codigo));
            
            TipoAssociado_Cadastro  tela02 = new TipoAssociado_Cadastro(jDesktoPanePrincipal, tipo);
            
            jDesktoPanePrincipal.add(tela02);
            tela02.setVisible(true);
            
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTablePesquisarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePesquisar;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        try {
            //Cria o cabeçalho da tabela
            Vector<String> cabecalho = new Vector();
            cabecalho.add("Identeficador");
            cabecalho.add("Descrição");
            cabecalho.add("Valor Mensalidade");
            
            Vector detalhes = new Vector();
            
            for(TipoAssociado detalhe : new NTipoAssociado().listar()){
                //criando linha da tabela
                Vector<String> linha = new Vector();
                linha.add(detalhe.getCodigo() + "");
                linha.add(detalhe.getDescricao());
                linha.add(detalhe.getValorMensalidade() + "");
                
                detalhes.add(linha);
            }
           jTablePesquisar.setModel(new DefaultTableModel(detalhes, cabecalho));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
          }
}
