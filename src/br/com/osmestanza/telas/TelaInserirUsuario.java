package br.com.osmestanza.telas;

//Import das bibliotecas
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TelaInserirUsuario extends javax.swing.JInternalFrame {

    //Variaveis do banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TelaInserirUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
    }

    private void inserir() {
        //Insert de dados no banco
        String sql = "INSERT INTO tbl_Usuarios(Nome_Usuario, Fone_Usuario, Login_Usuario, Senha_Usuario, Perfil_Usuario) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtFone.getText());
            pst.setString(3, txtLogin.getText());
            pst.setString(4, txtSenha.getText());
            pst.setString(5, cboPerfil.getSelectedItem().toString());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
                limpar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoinserir() {
        //Teste logico antes do insert de dados
        int aprovar = 0;
        String senha = txtSenha.getText();
        String confirmarsenha = txtConfSenha.getText();
        if (!senha.equals(confirmarsenha)) {
            JOptionPane.showMessageDialog(null, "Os campos de senha estão diferentes.");
        } else {
            if (txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            } else {
                aprovar++;
            }
        }
        if (txtFone.getText().isEmpty()) {
            if (aprovar == 1) {
                int telefone = JOptionPane.showConfirmDialog(null, "O usuário não irá possuir um telefone cadastrado, deseja prosseguir?", "Atenção", javax.swing.JOptionPane.YES_NO_OPTION);
                if (telefone == JOptionPane.YES_OPTION) {
                    aprovar++;
                }
            }
        } else {
            aprovar++;
        }
        if (cboPerfil.getSelectedItem().equals("Administrador")) {
            if (aprovar == 2) {
                int perfil = JOptionPane.showConfirmDialog(null, "O usuário irá possuir um perfil de administrador, deseja prosseguir?", "Atenção", javax.swing.JOptionPane.YES_NO_OPTION);
                if (perfil == JOptionPane.YES_OPTION) {
                    aprovar++;
                }
            }
        } else {
            aprovar++;
        }
        if (aprovar == 3) {
            inserir();
        }
    }

    private void limpar() {
        //Limpeza dos campos de dados
        txtNome.setText(null);
        txtFone.setText(null);
        txtLogin.setText(null);
        txtSenha.setText(null);
        txtConfSenha.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblConfSenha = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        cboPerfil = new javax.swing.JComboBox<>();
        txtFone = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfSenha = new javax.swing.JPasswordField();
        btnInserir = new javax.swing.JButton();
        lblConf = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblFone = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Adicionar Usuários");
        setPreferredSize(new java.awt.Dimension(725, 200));

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogin.setText("Login*");

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSenha.setText("Senha*");

        lblPerfil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPerfil.setText("Perfil");

        lblConfSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblConfSenha.setText("Confirmar a senha*");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/inserir.png"))); // NOI18N
        btnInserir.setToolTipText("Adicionar Usuário");
        btnInserir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        lblConf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblConf.setText("Campos Obrigatórios são marcados por *");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome*");

        lblFone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFone.setText("Telefone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConf)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLogin)
                                .addComponent(lblSenha)
                                .addComponent(lblConfSenha)
                                .addComponent(lblPerfil)
                                .addComponent(lblNome)
                                .addComponent(lblFone))
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFone)
                                .addComponent(txtLogin)
                                .addComponent(txtNome)
                                .addComponent(txtSenha)
                                .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(216, 216, 216)
                            .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFone))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfSenha)
                    .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerfil)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(lblConf)
                .addGap(72, 72, 72)
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );

        setBounds(0, 0, 723, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        botaoinserir();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JLabel lblConf;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
