package br.com.osmestanza.telas;

//Import da biblioteca Mysql, Modulo de conexao, e Biblioteca de gerenciamento das tabelas.
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class TelaAlterarCliente extends javax.swing.JInternalFrame {

    // Declaração das variáveis de conexão ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TelaAlterarCliente() {
        initComponents();
        // Chamada do metodo conector
        conexao = ModuloConexao.conector();
        // Feita alteração para os botões do JOptionPane, ficarem em português
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
    }

    private void alterar() {
        // Alteração no banco de dados, em caso do teste lógico do botão botaoAlterar,
        // ter sido concluido corretamente
        String sql = "UPDATE tbl_Clientes SET Nome_Cliente=?, CPF_Cliente=?, Fone_Cliente=?, Endereco_Cliente=? WHERE ID_Cliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtCpf.getText());
            pst.setString(3, txtFone.getText());
            pst.setString(4, txtEndereco.getText());
            pst.setString(5, txtId.getText());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.");
                limpar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoAlterar() {
        // Botão que realiza um teste lógico, antes de avançar para o update no banco de
        // dados.
        int aprovar = 0;
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o nome do Cliente!");
        } else {
            if (txtCpf.getText().isEmpty()) {
                int admin = JOptionPane.showConfirmDialog(null,
                        "O cliente não irá possuir um CPF cadastrado. Deseja prosseguir?", "Atenção",
                        JOptionPane.YES_NO_OPTION);
                if (admin == JOptionPane.YES_OPTION) {
                    aprovar++;
                }
            } else {
                aprovar++;
            }
        }
        if (txtFone.getText().isEmpty()) {
            if (aprovar == 1) {
                int telefone = JOptionPane.showConfirmDialog(null,
                        "O usuário não irá possuir um telefone cadastrado, deseja prosseguir?", "Atenção",
                        JOptionPane.YES_NO_OPTION);
                if (telefone == JOptionPane.YES_OPTION) {
                    aprovar++;
                }
            }
        } else {
            aprovar++;
        }
        if (txtEndereco.getText().isEmpty()) {
            if (aprovar == 2) {
                int telefone = JOptionPane.showConfirmDialog(null,
                        "O usuário não irá possuir um endereço cadastrado, deseja prosseguir?", "Atenção",
                        JOptionPane.YES_NO_OPTION);
                if (telefone == JOptionPane.YES_OPTION) {
                    aprovar++;
                }
            }
        } else {
            aprovar++;
        }
        if (aprovar == 3) {
            alterar();
        }
    }

    private void consultar() {
        // Consulta ao banco de dados, que insere o resultado na tabela
        String sql = "SELECT ID_Cliente AS 'ID', Nome_Cliente AS 'Nome', CPF_Cliente AS 'CPF', Fone_Cliente AS 'Telefone', Endereco_Cliente AS 'Endereço' FROM tbl_Clientes WHERE Nome_Cliente LIKE ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtConsultar.getText() + '%');
            rs = pst.executeQuery();
            tblConsultar.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar() {
        // Set campos da consulta da tabela para os campos correspondentes
        int setar = tblConsultar.getSelectedRow();
        txtId.setText(tblConsultar.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tblConsultar.getModel().getValueAt(setar, 1).toString());
        txtCpf.setText(tblConsultar.getModel().getValueAt(setar, 2).toString());
        txtFone.setText(tblConsultar.getModel().getValueAt(setar, 3).toString());
        txtEndereco.setText(tblConsultar.getModel().getValueAt(setar, 4).toString());
    }

    private void limpar() {
        // Realiza a limpeza dos campos da tabela
        txtId.setText(null);
        txtNome.setText(null);
        txtCpf.setText(null);
        txtFone.setText(null);
        txtEndereco.setText(null);
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFone = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JTextField();
        txtFone = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultar = new javax.swing.JTable();
        txtEndereco = new javax.swing.JTextField();
        lblCamposOb = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Clientes");
        setName(""); // NOI18N

        lblFone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFone.setText("Telefone");

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        txtId.setEnabled(false);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome");

        lblID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblID.setText("ID");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/alterar.png"))); // NOI18N
        btnAlterar.setToolTipText("");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCpf.setText("CPF");

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEndereco.setText("Endereço");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblConsultar.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null },
                { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
                { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
                { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
                { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
                { null, null, null, null, null }, { null, null, null, null, null } },
                new String[] { "ID", "Nome", "CPF", "Telefone", "Endereço" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblConsultar.setShowGrid(true);
        tblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultar);

        lblCamposOb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCamposOb.setText("O nome é um campo obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(
                                        layout.createSequentialGroup().addComponent(lblCamposOb).addGap(186, 186, 186))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblFone).addComponent(lblCpf).addComponent(lblEndereco)
                                                .addComponent(lblNome).addComponent(lblID))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCpf).addComponent(txtFone).addComponent(txtNome)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnLimpar))
                                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 342,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64,
                                                Short.MAX_VALUE)
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665,
                                                Short.MAX_VALUE)
                                        .addComponent(txtConsultar))))
                .addContainerGap(21, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(11, 11, 11)
                        .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID).addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNome).addComponent(
                                                                txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblCpf).addComponent(txtCpf,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblFone)
                                                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18).addComponent(lblEndereco))
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup().addComponent(btnLimpar).addGap(132, 132, 132)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblCamposOb)
                        .addGap(114, 114, 114)));

        setBounds(0, 0, 721, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        botaoAlterar();
    }

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {
        consultar();
    }

    private void tblConsultarMouseClicked(java.awt.event.MouseEvent evt) {
        setar();
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limpar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCamposOb;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblConsultar;
    private javax.swing.JTextField txtConsultar;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
