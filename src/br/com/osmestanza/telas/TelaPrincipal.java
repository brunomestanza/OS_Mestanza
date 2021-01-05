package br.com.osmestanza.telas;

import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblIcone = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCli = new javax.swing.JMenu();
        menuCliInserir = new javax.swing.JMenuItem();
        menuCliConsultar = new javax.swing.JMenuItem();
        menuCliAlterar = new javax.swing.JMenuItem();
        menuCliRemover = new javax.swing.JMenuItem();
        menuOs = new javax.swing.JMenu();
        menuOsInserir = new javax.swing.JMenuItem();
        menuOsConsultar = new javax.swing.JMenuItem();
        menuOsAlterar = new javax.swing.JMenuItem();
        menuOsRemover = new javax.swing.JMenuItem();
        menuAdministrativo = new javax.swing.JMenu();
        menuUsuInserir = new javax.swing.JMenuItem();
        menuUsuConsultar = new javax.swing.JMenuItem();
        menuUsuAlterar = new javax.swing.JMenuItem();
        menuUsuRemover = new javax.swing.JMenuItem();
        menuResetSenha = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjudaSobre = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuTrocaSenha = new javax.swing.JMenuItem();
        menuOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mestanza - Sistema para Controle de Ordem de Serviço");
        setResizable(false);

        desktop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desktop.setPreferredSize(new java.awt.Dimension(725, 780));
        desktop.setRequestFocusEnabled(false);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/telaprincipal.png"))); // NOI18N
        lblIcone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblusuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(0, 71, 171));
        lblusuario.setText("Usuario");

        lblBemVindo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(0, 71, 171));
        lblBemVindo.setText("Bem vindo");

        menuCadastro.setText("Cadastro");

        menuCli.setText("Cliente");

        menuCliInserir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCliInserir.setText("Adicionar Cliente");
        menuCliInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliInserirActionPerformed(evt);
            }
        });
        menuCli.add(menuCliInserir);

        menuCliConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCliConsultar.setText("Consultar Cliente");
        menuCliConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliConsultarActionPerformed(evt);
            }
        });
        menuCli.add(menuCliConsultar);

        menuCliAlterar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCliAlterar.setText("Alterar Cliente");
        menuCliAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliAlterarActionPerformed(evt);
            }
        });
        menuCli.add(menuCliAlterar);

        menuCliRemover.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCliRemover.setText("Remover Cliente");
        menuCliRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliRemoverActionPerformed(evt);
            }
        });
        menuCli.add(menuCliRemover);

        menuCadastro.add(menuCli);

        menuOs.setText("Ordem de Serviço");

        menuOsInserir.setText("Adicionar OS");
        menuOsInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOsInserirActionPerformed(evt);
            }
        });
        menuOs.add(menuOsInserir);

        menuOsConsultar.setText("Consultar OS");
        menuOsConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOsConsultarActionPerformed(evt);
            }
        });
        menuOs.add(menuOsConsultar);

        menuOsAlterar.setText("Alterar OS");
        menuOsAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOsAlterarActionPerformed(evt);
            }
        });
        menuOs.add(menuOsAlterar);

        menuOsRemover.setText("Remover OS");
        menuOsRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOsRemoverActionPerformed(evt);
            }
        });
        menuOs.add(menuOsRemover);

        menuCadastro.add(menuOs);

        menuAdministrativo.setText("Administrativo");
        menuAdministrativo.setEnabled(false);

        menuUsuInserir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuUsuInserir.setText("Adicionar Usuarios");
        menuUsuInserir.setFocusable(true);
        menuUsuInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuInserirActionPerformed(evt);
            }
        });
        menuAdministrativo.add(menuUsuInserir);

        menuUsuConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuUsuConsultar.setText("Consultar Usuarios");
        menuUsuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuConsultarActionPerformed(evt);
            }
        });
        menuAdministrativo.add(menuUsuConsultar);

        menuUsuAlterar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuUsuAlterar.setText("Alterar Usuarios");
        menuUsuAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuAlterarActionPerformed(evt);
            }
        });
        menuAdministrativo.add(menuUsuAlterar);

        menuUsuRemover.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuUsuRemover.setText("Remover Usuarios");
        menuUsuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuRemoverActionPerformed(evt);
            }
        });
        menuAdministrativo.add(menuUsuRemover);

        menuResetSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuResetSenha.setText("Reset de Senha");
        menuResetSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResetSenhaActionPerformed(evt);
            }
        });
        menuAdministrativo.add(menuResetSenha);

        menuCadastro.add(menuAdministrativo);

        menu.add(menuCadastro);

        menuAjuda.setText("Ajuda");

        menuAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuAjudaSobre.setText("Sobre");
        menuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAjudaSobre);

        menu.add(menuAjuda);

        menuOpcoes.setText("Opções");

        menuTrocaSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuTrocaSenha.setText("Alterar Senha");
        menuTrocaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTrocaSenhaActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuTrocaSenha);

        menuOpcoesSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuOpcoesSair.setText("Sair");
        menuOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesSair);

        menu.add(menuOpcoes);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcone)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBemVindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusuario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBemVindo)
                    .addComponent(lblusuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(lblIcone)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesSairActionPerformed
        // Exibe uma caixa de dialogo ao tentar sair da aplicacao, com sim ou nao       
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuOpcoesSairActionPerformed

    private void menuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaSobreActionPerformed
        // As linhas abaixo chamam a tela sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menuAjudaSobreActionPerformed

    private void menuUsuInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuInserirActionPerformed
        // As linhas abaixo abrem o form TelaUsuario dentro do desktopane
        TelaInserirUsuario usuario = new TelaInserirUsuario();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_menuUsuInserirActionPerformed

    private void menuUsuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuConsultarActionPerformed
        TelaConsultaUsuario consulta = new TelaConsultaUsuario();
        consulta.setVisible(true);
        desktop.add(consulta);
    }//GEN-LAST:event_menuUsuConsultarActionPerformed

    private void menuUsuAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuAlterarActionPerformed
        TelaAlterarUsuario alterar = new TelaAlterarUsuario();
        alterar.setVisible(true);
        desktop.add(alterar);
    }//GEN-LAST:event_menuUsuAlterarActionPerformed

    private void menuUsuRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuRemoverActionPerformed
        TelaRemoverUsuario remover = new TelaRemoverUsuario();
        remover.setVisible(true);
        desktop.add(remover);
    }//GEN-LAST:event_menuUsuRemoverActionPerformed

    private void menuResetSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResetSenhaActionPerformed
        TelaResetSenha trocasenha = new TelaResetSenha();
        trocasenha.setVisible(true);
        desktop.add(trocasenha);
    }//GEN-LAST:event_menuResetSenhaActionPerformed

    private void menuTrocaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTrocaSenhaActionPerformed
        TelaMudarSenha mudarsenha = new TelaMudarSenha();
        mudarsenha.setVisible(true);
        desktop.add(mudarsenha);
    }//GEN-LAST:event_menuTrocaSenhaActionPerformed

    private void menuCliInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliInserirActionPerformed
        TelaInserirCliente inserircliente = new TelaInserirCliente();
        inserircliente.setVisible(true);
        desktop.add(inserircliente);
    }//GEN-LAST:event_menuCliInserirActionPerformed

    private void menuCliConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliConsultarActionPerformed
        TelaConsultaCliente consultarcliente = new TelaConsultaCliente();
        consultarcliente.setVisible(true);
        desktop.add(consultarcliente);
    }//GEN-LAST:event_menuCliConsultarActionPerformed

    private void menuCliAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliAlterarActionPerformed
        TelaAlterarCliente alterarcliente = new TelaAlterarCliente();
        alterarcliente.setVisible(true);
        desktop.add(alterarcliente);
    }//GEN-LAST:event_menuCliAlterarActionPerformed

    private void menuCliRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliRemoverActionPerformed
        TelaRemoverCliente removercliente = new TelaRemoverCliente();
        removercliente.setVisible(true);
        desktop.add(removercliente);
    }//GEN-LAST:event_menuCliRemoverActionPerformed

    private void menuOsInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOsInserirActionPerformed
        TelaInserirOs tela = new TelaInserirOs();
        tela.setVisible(true);
        desktop.add(tela);
    }//GEN-LAST:event_menuOsInserirActionPerformed

    private void menuOsConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOsConsultarActionPerformed
        TelaConsultarOs tela = new TelaConsultarOs();
        tela.setVisible(true);
        desktop.add(tela);
    }//GEN-LAST:event_menuOsConsultarActionPerformed

    private void menuOsAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOsAlterarActionPerformed
        TelaAlterarOs tela = new TelaAlterarOs();
        tela.setVisible(true);
        desktop.add(tela);
    }//GEN-LAST:event_menuOsAlterarActionPerformed

    private void menuOsRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOsRemoverActionPerformed
        TelaRemoverOs tela = new TelaRemoverOs();
        tela.setVisible(true);
        desktop.add(tela);
    }//GEN-LAST:event_menuOsRemoverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblIcone;
    public static javax.swing.JLabel lblusuario;
    private javax.swing.JMenuBar menu;
    public static javax.swing.JMenu menuAdministrativo;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuAjudaSobre;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCli;
    private javax.swing.JMenuItem menuCliAlterar;
    private javax.swing.JMenuItem menuCliConsultar;
    private javax.swing.JMenuItem menuCliInserir;
    private javax.swing.JMenuItem menuCliRemover;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOpcoesSair;
    private javax.swing.JMenu menuOs;
    private javax.swing.JMenuItem menuOsAlterar;
    private javax.swing.JMenuItem menuOsConsultar;
    private javax.swing.JMenuItem menuOsInserir;
    private javax.swing.JMenuItem menuOsRemover;
    private javax.swing.JMenuItem menuResetSenha;
    private javax.swing.JMenuItem menuTrocaSenha;
    private javax.swing.JMenuItem menuUsuAlterar;
    private javax.swing.JMenuItem menuUsuConsultar;
    private javax.swing.JMenuItem menuUsuInserir;
    private javax.swing.JMenuItem menuUsuRemover;
    // End of variables declaration//GEN-END:variables
}
