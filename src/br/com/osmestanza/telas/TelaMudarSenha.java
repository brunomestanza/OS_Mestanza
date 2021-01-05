package br.com.osmestanza.telas;

import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaMudarSenha extends javax.swing.JInternalFrame {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TelaMudarSenha() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void mudarSenha() {
        String sql = "UPDATE tbl_Usuarios SET Senha_Usuario=? WHERE ID_Usuario=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNovSenha.getText());
            pst.setString(2, txtId.getText());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso.");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Verifique o usuário.");
                txtId.setText(null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoMudar() {
        String senha = txtNovSenha.getText();
        String confSenha = txtConfSenha.getText();
        if (senha.equals(confSenha)) {
            String sql = "SELECT * FROM tbl_Usuarios WHERE Login_Usuario = ? AND Senha_Usuario = ?";
            try {
                // As linhas abaixo buscam no banco os usuarios informados na caixa de texto
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtLogin.getText());
                pst.setString(2, txtAntSenha.getText());
                //A linha abaixo executa a query (consulta) ao banco de dados
                rs = pst.executeQuery();
                //Se existir um usuário e senha correspondente
                if (rs.next()) {
                    mudarSenha();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreto(s)!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Os campos de senha são diferentes.");
        }
    }

    private void consultar() {
        String consulta = "SELECT ID_Usuario FROM tbl_Usuarios WHERE Login_Usuario=?";
        try {
            pst = conexao.prepareStatement(consulta);
            pst.setString(1, txtLogin.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtId.setText(rs.getString(1));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não existente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void limpar() {
        txtId.setText(null);
        txtLogin.setText(null);
        txtAntSenha.setText(null);
        txtNovSenha.setText(null);
        txtConfSenha.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblNovSenha = new javax.swing.JLabel();
        lblConfSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtNovSenha = new javax.swing.JPasswordField();
        txtConfSenha = new javax.swing.JPasswordField();
        btnMudSenha = new javax.swing.JButton();
        lblConf = new javax.swing.JLabel();
        lblSenhaAnt = new javax.swing.JLabel();
        txtAntSenha = new javax.swing.JPasswordField();
        btnLimpar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Senha");

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogin.setText("Login");

        lblNovSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNovSenha.setText("Nova Senha");

        lblConfSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblConfSenha.setText("Confirmar nova senha");

        btnMudSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/senha.png"))); // NOI18N
        btnMudSenha.setToolTipText("Adicionar Usuário");
        btnMudSenha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMudSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMudSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMudSenhaActionPerformed(evt);
            }
        });

        lblConf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblConf.setText("Todos os campos são obrigatórios");

        lblSenhaAnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSenhaAnt.setText("Senha Antiga");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        lblId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblId.setText("ID");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConf)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenhaAnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAntSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblNovSenha)
                            .addComponent(lblConfSenha)
                            .addComponent(lblId))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar))
                            .addComponent(txtLogin)
                            .addComponent(txtNovSenha)
                            .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMudSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConsultar)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnConsultar))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenhaAnt)
                            .addComponent(txtAntSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNovSenha)
                            .addComponent(txtNovSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConfSenha)
                            .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnMudSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblConf)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        setBounds(0, 0, 723, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMudSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMudSenhaActionPerformed
        botaoMudar();
    }//GEN-LAST:event_btnMudSenhaActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMudSenha;
    private javax.swing.JLabel lblConf;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNovSenha;
    private javax.swing.JLabel lblSenhaAnt;
    private javax.swing.JPasswordField txtAntSenha;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtNovSenha;
    // End of variables declaration//GEN-END:variables
}
