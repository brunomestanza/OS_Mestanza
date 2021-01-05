package br.com.osmestanza.telas;

//Import da biblioteca Mysql, Modulo de conexao, e Biblioteca de gerenciamento das tabelas.
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAlterarOs extends javax.swing.JInternalFrame {

    // Declaração das variáveis de conexão ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs;
    // Declaração da variável de controle, responsável pelos botões do tipo de serviço
    private String tipo;

    public TelaAlterarOs() {
        initComponents();
        // Chamada do metodo conector
        conexao = ModuloConexao.conector();
    }

    private void alterar() {
        // Alteração no banco de dados, em caso do teste lógico do botão botaoAlterar ter sido concluido corretamente
        String sql = "UPDATE tbl_OS SET Tipo_OS=?, Situacao_OS=?, Defeito_OS=?, Servico_OS=?, Tecnico_OS=?, Valor_OS=? WHERE ID_OS=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cboStatus.getSelectedItem().toString());
            pst.setString(3, txtDef.getText());
            pst.setString(4, txtServ.getText());
            pst.setString(5, txtTec.getText());
            pst.setString(6, txtValor.getText().replace(",", "."));
            pst.setString(7, txtOs.getText());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "A ordem de serviço foi alterada com sucesso.");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoAlterar() {
        // Botão que realiza um teste lógico, antes de avançar para o update no banco de dados.
        if (txtDef.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            alterar();
        }
    }

    private void consultar() {
        // Consulta ao banco de dados, que insere o resultado na tabela
        String sql = "SELECT tbl_Clientes.Nome_Cliente, tbl_OS.Data_OS, tbl_OS.Tipo_OS, tbl_OS.Situacao_OS, tbl_OS.Equipamento_OS, tbl_OS.Defeito_OS, tbl_OS.Servico_OS, tbl_OS.Tecnico_OS, tbl_OS.Valor_OS FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_cliente = tbl_OS.ID_cliente AND tbl_OS.ID_OS = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtOs.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNome.setText(rs.getString(1));
                txtData.setText(rs.getString(2));
                String rbtTipo = rs.getString(3);
                if (rbtTipo.equals("OS")) {
                    rbtOs.setSelected(true);
                } else {
                    rbtOrc.setSelected(true);
                }
                cboStatus.setSelectedItem(rs.getString(4));
                txtEquip.setText(rs.getString(5));
                txtDef.setText(rs.getString(6));
                txtServ.setText(rs.getString(7));
                txtTec.setText(rs.getString(8));
                txtValor.setText(rs.getString(9));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar() {
        // Set campos da consulta da tabela para os campos correspondentes
        int setar = tblConsultar.getSelectedRow();
        txtOs.setText(tblConsultar.getModel().getValueAt(setar, 1).toString());
    }

    private void limpar() {
        // Realiza a limpeza dos campos da tabela
        txtOs.setText(null);
        txtNome.setText(null);
        txtConsultar.setText(null);
        txtData.setText(null);
        rbtOs.setSelected(false);
        rbtOrc.setSelected(false);
        cboStatus.setSelectedItem("Na bancada");
        txtEquip.setText(null);
        txtDef.setText(null);
        txtServ.setText(null);
        txtTec.setText(null);
        txtValor.setText(null);
        cboStatus.setSelectedItem("Na bancada");
        rbtOrc.setSelected(true);
    }

    private void consultaInicial() {
        // Realiza uma consulta em busca do ID, antes de fazer a consulta mais profunda
        String sql = "SELECT tbl_Clientes.Nome_Cliente AS Nome, tbl_OS.ID_OS AS OS, tbl_OS.Data_OS AS Data FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_Cliente = tbl_OS.ID_Cliente AND tbl_Clientes.Nome_Cliente LIKE ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtConsultar.getText() + "%");
            rs = pst.executeQuery();
            tblConsultar.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtEquip = new javax.swing.JTextField();
        txtServ = new javax.swing.JTextField();
        txtDef = new javax.swing.JTextField();
        txtTec = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        pnlOs = new javax.swing.JPanel();
        rbtOrc = new javax.swing.JRadioButton();
        rbtOs = new javax.swing.JRadioButton();
        lblSit = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        cboStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        lblEquip = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultar = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        lblDef = new javax.swing.JLabel();
        lblServ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTec = new javax.swing.JLabel();
        lblOs = new javax.swing.JLabel();
        txtOs = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        btnAlterar1 = new javax.swing.JButton();
        lblNome1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Ordem de Serviço");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        txtEquip.setEnabled(false);

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValor.setText("Valor Total");

        pnlOs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OS", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.TOP));

        buttonGroup1.add(rbtOrc);
        rbtOrc.setText("Orçamento");
        rbtOrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrcActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtOs);
        rbtOs.setText("Ordem de Serviço");
        rbtOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOsLayout = new javax.swing.GroupLayout(pnlOs);
        pnlOs.setLayout(pnlOsLayout);
        pnlOsLayout.setHorizontalGroup(pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlOsLayout.createSequentialGroup().addContainerGap().addComponent(rbtOrc).addGap(26, 26, 26)
                        .addComponent(rbtOs).addContainerGap(41, Short.MAX_VALUE)));
        pnlOsLayout.setVerticalGroup(pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlOsLayout.createSequentialGroup().addContainerGap()
                        .addGroup(pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbtOrc).addComponent(rbtOs))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        lblSit.setText("Situação");

        txtValor.setText("0");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Na bancada", "Entrega concluída", "Orçamento reprovado", "Aguardando aprovação",
                        "Aguardando peças", "Abandonado pelo cliente", "Retornou" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        lblStatus
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png"))); // NOI18N
        lblStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblEquip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEquip.setText("Equipamento*");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lblNome.setText("Cliente");

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        tblConsultar
                .setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
                                { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
                                { null, null, null }, { null, null, null }, { null, null, null } },
                        new String[] { "ID", "Nome", "Telefone" }) {
                    boolean[] canEdit = new boolean[] { false, false, false };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
        tblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultar);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/lbl_os.png"))); // NOI18N
        btnConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblNome)
                                                .addGap(18, 18, 18).addComponent(txtConsultar))
                                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 93, Short.MAX_VALUE)
                                                .addComponent(btnLimpar).addGap(71, 71, 71)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar)))
                        .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(38, 38, 38).addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblNome)
                                .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28).addComponent(btnLimpar))
                        .addComponent(btnConsultar)).addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addContainerGap()));

        lblDef.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDef.setText("Defeito*");

        lblServ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblServ.setText("Serviço");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Preencha os campos obrigatórios*");

        lblTec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTec.setText("Técnico");

        lblOs.setText("OS");

        txtOs.setEnabled(false);

        txtData.setEnabled(false);

        lblData.setText("Data");

        btnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/alterar.png"))); // NOI18N
        btnAlterar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });

        lblNome1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome1.setText("Nome");

        txtNome.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup().addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addComponent(lblSit).addGap(64, 64, 64)
                                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup().addGap(76, 76, 76).addComponent(lblStatus))))
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblOs).addComponent(lblData))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtData).addComponent(txtOs,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addContainerGap())
                .addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2)
                        .addComponent(lblServ)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEquip).addComponent(lblDef).addComponent(lblTec)
                                        .addComponent(lblValor).addComponent(lblNome1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNome).addComponent(txtEquip).addComponent(txtDef)
                                        .addComponent(txtServ).addComponent(txtTec).addComponent(txtValor,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(549, Short.MAX_VALUE).addComponent(btnAlterar1).addGap(29, 29, 29))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblOs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSit).addComponent(cboStatus,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37).addComponent(lblStatus)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNome1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblEquip)
                        .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblDef)
                        .addComponent(txtDef, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblServ)
                        .addComponent(txtServ, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblTec)
                        .addComponent(txtTec, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblValor)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18).addComponent(jLabel2).addContainerGap(58, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addContainerGap(457, Short.MAX_VALUE).addComponent(btnAlterar1)
                                .addGap(138, 138, 138))));

        setBounds(0, 0, 721, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {
        botaoAlterar();
    }

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        consultar();
    }

    private void tblConsultarMouseClicked(java.awt.event.MouseEvent evt) {
        setar();
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limpar();
    }

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {
        consultaInicial();
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
        // Ao abrir o form, marca o radiobutton orçamento, e seta a variavel tipo comoorçamento
        rbtOs.setSelected(true);
        tipo = "Orçamento";
    }

    private void rbtOrcActionPerformed(java.awt.event.ActionEvent evt) {
        // Atribui o valor orçamento a variavel tipo, se o botao for acionado
        tipo = "Orçamento";
    }

    private void rbtOsActionPerformed(java.awt.event.ActionEvent evt) {
        // Atribui o valor OS a variavel tipo, se o botao for acionado
        tipo = "OS";
    }

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {
        switch (cboStatus.getSelectedItem().toString()) {
            case "Entrega concluída":
                lblStatus.setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_entrega.png")));
                break;
            case "Na bancada":
                lblStatus.setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png")));
                break;
            case "Orçamento reprovado":
                lblStatus.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/br/com/osmestanza/icones/os_orcamento.png")));
                break;
            case "Aguardando aprovação":
                lblStatus.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/br/com/osmestanza/icones/os_aguard_aprov.png")));
                break;
            case "Aguardando peças":
                lblStatus.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/br/com/osmestanza/icones/os_aguard_peca.png")));
                break;
            case "Abandonado pelo cliente":
                lblStatus.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/br/com/osmestanza/icones/os_abandonado.png")));
                break;
            case "Retornou":
                lblStatus.setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_retornou.png")));
                break;
            default:
                lblStatus.setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png")));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDef;
    private javax.swing.JLabel lblEquip;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblOs;
    private javax.swing.JLabel lblServ;
    private javax.swing.JLabel lblSit;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTec;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlOs;
    private javax.swing.JRadioButton rbtOrc;
    private javax.swing.JRadioButton rbtOs;
    private javax.swing.JTable tblConsultar;
    private javax.swing.JTextField txtConsultar;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDef;
    private javax.swing.JTextField txtEquip;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOs;
    private javax.swing.JTextField txtServ;
    private javax.swing.JTextField txtTec;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

}
