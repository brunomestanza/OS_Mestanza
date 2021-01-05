package br.com.osmestanza.telas;

//Import da biblioteca Mysql, Modulo de conexao, e Biblioteca de gerenciamento das tabelas.
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class TelaAlterarUsuario extends javax.swing.JInternalFrame {

    // Declaração das variáveis de conexão ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TelaAlterarUsuario() {
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
        String sql = "UPDATE tbl_Usuarios SET Nome_Usuario=?, Fone_Usuario=?, Perfil_Usuario=? WHERE ID_Usuario=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtFone.getText());
            pst.setString(3, cboPerfil.getSelectedItem().toString());
            pst.setString(4, txtId.getText());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");
                limpar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoAlterar() {
        // Botão que realiza um teste lógico, antes de avançar para o update no banco de dados.
        int aprovar = 0;
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o nome do usuário.");
        } else {
            if (cboPerfil.getSelectedItem().toString().equals("Administrador")) {
                int admin = JOptionPane.showConfirmDialog(null,
                        "O usuário irá receber privilégios administrativos, deseja prosseguir?", "Atenção",
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
        if (aprovar == 2) {
            alterar();
        }
    }

    private void consultar() {
        // Consulta ao banco de dados, que insere o resultado na tabela
        String sql = "SELECT ID_Usuario AS 'ID', Nome_Usuario AS 'Nome', Fone_Usuario AS 'Telefone', Perfil_Usuario AS 'Perfil' FROM tbl_Usuarios WHERE Nome_Usuario LIKE ?";
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
        txtFone.setText(tblConsultar.getModel().getValueAt(setar, 2).toString());
        cboPerfil.setSelectedItem(tblConsultar.getModel().getValueAt(setar, 3).toString());
    }

    private void limpar() {
        // Realiza a limpeza dos campos da tabela
        txtId.setText(null);
        txtNome.setText(null);
        txtFone.setText(null);
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPerfil = new javax.swing.JComboBox<>();
        lblFone = new javax.swing.JLabel();
        txtFone = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        lblPerfil = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultar = new javax.swing.JTable();
        txtConsultar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Usuários");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));

        lblFone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFone.setText("Telefone");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/alterar.png"))); // NOI18N
        btnAlterar.setToolTipText("Adicionar Usuário");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblPerfil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPerfil.setText("Perfil");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblConsultar.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
                new String[] { "ID", "Nome", "Telefone", "Perfil" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblConsultar.setFillsViewportHeight(true);
        tblConsultar.setShowGrid(true);
        tblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultar);

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        txtId.setEnabled(false);

        lblID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblID.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665,
                                                Short.MAX_VALUE)
                                        .addComponent(txtConsultar))
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup().addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblFone).addComponent(lblPerfil))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFone)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNome).addComponent(lblID))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(202, 202, 202).addComponent(btnLimpar))
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 342,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
                        .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLimpar)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblID))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNome))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFone).addComponent(txtFone,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPerfil)))
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)));

        setBounds(0, 0, 723, 752);
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
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JTable tblConsultar;
    private javax.swing.JTextField txtConsultar;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
