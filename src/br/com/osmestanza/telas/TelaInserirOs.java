package br.com.osmestanza.telas;

//Import de bibliotecas
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaInserirOs extends javax.swing.JInternalFrame {

    //Variveis de conexao ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String tipo;

    public TelaInserirOs() {
        initComponents();
        //Modulo de conxao ao banco
        conexao = ModuloConexao.conector();
    }

    private void inserir() {
        //Insert de dados no banco de dados
        String sql = "INSERT INTO tbl_OS(Tipo_OS, Situacao_OS, Equipamento_OS, Defeito_OS, Servico_OS, Tecnico_OS, Valor_OS, ID_Cliente) values(?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cboStatus.getSelectedItem().toString());
            pst.setString(3, txtEquip.getText());
            pst.setString(4, txtDef.getText());
            pst.setString(5, txtServ.getText());
            pst.setString(6, txtTec.getText());
            pst.setString(7, txtValor.getText().replace(",", "."));
            pst.setString(8, txtId.getText());
            int adicionado = pst.executeUpdate();
            //Consulta para ver o numero da solicitacao aberta
            String sqlid = "SELECT ID_OS FROM tbl_OS ORDER BY ID_OS DESC LIMIT 1";
            try {
                pst = conexao.prepareStatement(sqlid);
                //pst.setString(1, txtId.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    txtId.setText(rs.getString(1));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "A ordem de serviço " + txtId.getText() + " foi emitida com sucesso.");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void botaoInserir() {
        //Teste logico antes do insert dos dados        
        if (txtId.getText().isEmpty() || txtEquip.getText().isEmpty() || txtDef.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            inserir();
        }
    }

    private void consultar() {
        //Consulta de dados
        String sql = "SELECT ID_Cliente AS ID, Nome_Cliente AS Nome, Fone_Cliente AS Telefone FROM tbl_Clientes WHERE Nome_Cliente LIKE ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtConsultar.getText() + "%");
            rs = pst.executeQuery();
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar() {
        //Setar os dados da tabela para os campos
        int setar = tblClientes.getSelectedRow();
        txtId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
    }

    private void limpar() {
        //Limpar os campos
        txtId.setText(null);
        txtNome.setText(null);
        txtConsultar.setText(null);
        txtEquip.setText(null);
        txtDef.setText(null);
        txtServ.setText(null);
        txtValor.setText(null);
        txtTec.setText(null);
        cboStatus.setSelectedItem("Na bancada");
        rbtOrc.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlOs = new javax.swing.JPanel();
        rbtOrc = new javax.swing.JRadioButton();
        rbtOrd = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblSit = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        lblEquip = new javax.swing.JLabel();
        lblDef = new javax.swing.JLabel();
        lblServ = new javax.swing.JLabel();
        lblTec = new javax.swing.JLabel();
        txtEquip = new javax.swing.JTextField();
        txtServ = new javax.swing.JTextField();
        txtDef = new javax.swing.JTextField();
        txtTec = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNome1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Emitir Ordem de Serviço");
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

        pnlOs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        buttonGroup1.add(rbtOrc);
        rbtOrc.setText("Orçamento");
        rbtOrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrcActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtOrd);
        rbtOrd.setText("Ordem de Serviço");
        rbtOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOsLayout = new javax.swing.GroupLayout(pnlOs);
        pnlOs.setLayout(pnlOsLayout);
        pnlOsLayout.setHorizontalGroup(
            pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtOrc)
                .addGap(26, 26, 26)
                .addComponent(rbtOrd)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlOsLayout.setVerticalGroup(
            pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtOrc)
                    .addComponent(rbtOrd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lblNome.setText("Cliente");

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        txtId.setEnabled(false);

        lblId.setText("ID*");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/lbl_os.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblSit.setText("Situação");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Na bancada", "Entrega concluída", "Orçamento reprovado", "Aguardando aprovação", "Aguardando peças", "Abandonado pelo cliente", "Retornou" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        lblEquip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEquip.setText("Equipamento*");

        lblDef.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDef.setText("Defeito*");

        lblServ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblServ.setText("Serviço");

        lblTec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTec.setText("Técnico");

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValor.setText("Valor Total");

        txtValor.setText("0");

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png"))); // NOI18N
        lblStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/inserir.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Preencha os campos obrigatórios*");

        lblNome1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome1.setText("Nome");

        txtNome.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSit)
                        .addGap(64, 64, 64)
                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblStatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome1)
                        .addGap(78, 78, 78)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblServ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquip)
                            .addComponent(lblDef)
                            .addComponent(lblTec)
                            .addComponent(lblValor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTec, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtServ, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDef)
                                .addComponent(txtValor))
                            .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnLimpar)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSit)
                                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(lblStatus)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpar)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEquip)
                            .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDef)
                            .addComponent(txtDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServ)
                            .addComponent(txtServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTec)
                            .addComponent(txtTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
        );

        setBounds(0, 0, 721, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarKeyReleased
        consultar();
    }//GEN-LAST:event_txtConsultarKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setar();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void rbtOrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrcActionPerformed
        //Atribui o valor orçamento a variavel tipo, se o botao for acionado
        tipo = "Orçamento";
    }//GEN-LAST:event_rbtOrcActionPerformed

    private void rbtOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrdActionPerformed
        //Atribui o valor OS a variavel tipo, se o botao for acionado
        tipo = "OS";
    }//GEN-LAST:event_rbtOrdActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //Ao abrir o form, marca o radiobutton orçamento, e seta a variavel tipo como orçamento
        rbtOrc.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        switch (cboStatus.getSelectedItem().toString()) {
            case "Entrega concluída":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_entrega.png")));
                break;
            case "Na bancada":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png")));
                break;
            case "Orçamento reprovado":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_orcamento.png")));
                break;
            case "Aguardando aprovação":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_aguard_aprov.png")));
                break;
            case "Aguardando peças":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_aguard_peca.png")));
                break;
            case "Abandonado pelo cliente":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_abandonado.png")));
                break;
            case "Retornou":
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_retornou.png")));
                break;
            default:
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png")));
        }
    }//GEN-LAST:event_cboStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        botaoInserir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDef;
    private javax.swing.JLabel lblEquip;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblServ;
    private javax.swing.JLabel lblSit;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTec;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlOs;
    private javax.swing.JRadioButton rbtOrc;
    private javax.swing.JRadioButton rbtOrd;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtConsultar;
    private javax.swing.JTextField txtDef;
    private javax.swing.JTextField txtEquip;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtServ;
    private javax.swing.JTextField txtTec;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
