package br.com.osmestanza.telas;

//Import da biblioteca Mysql, Modulo de conexao, e Biblioteca de gerenciamento das tabelas.
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaConsultaCliente extends javax.swing.JInternalFrame {

    // Declaração das variáveis de conexão ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TelaConsultaCliente() {
        initComponents();
        // Chamada do metodo conector
        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        // Consulta dados do banco de dados e preenche a tabela
        String sql = "SELECT Nome_Cliente AS 'Nome', CPF_Cliente AS 'CPF', Fone_Cliente AS 'Telefone', Endereco_Cliente AS 'Endereco' FROM tbl_Clientes WHERE Nome_Cliente LIKE ?;";
        try {
            pst = conexao.prepareStatement(sql);
            // Linha que pesquisa atraves da funcao com filtro
            pst.setString(1, txtConsultar.getText() + '%');
            rs = pst.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar, biblioteca da tabela
            tblConsultar.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtConsultar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultar = new javax.swing.JTable();
        lblIcone = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Clientes");

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        tblConsultar.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
                new String[] { "Nome", "CPF", "Telefone", "Endereco" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblConsultar.setEnabled(false);
        tblConsultar.setFocusCycleRoot(true);
        tblConsultar.setShowGrid(true);
        jScrollPane1.setViewportView(tblConsultar);

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/consultar.png"))); // NOI18N
        lblIcone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblIcone.setPreferredSize(new java.awt.Dimension(124, 124));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 475,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64).addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(34, 34, 34)
                                .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE)));

        setBounds(0, 0, 723, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {
        consultar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JTable tblConsultar;
    private javax.swing.JTextField txtConsultar;
    // End of variables declaration//GEN-END:variables
}
