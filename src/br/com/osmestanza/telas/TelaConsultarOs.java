package br.com.osmestanza.telas;

//Import da biblioteca Mysql, Modulo de conexao, e Biblioteca de gerenciamento das tabelas.
import java.sql.*;
import br.com.osmestanza.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaConsultarOs extends javax.swing.JInternalFrame {

    // Declaração das variáveis de conexão ao banco de dados
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    // Variavel de controle dos botoes
    private String tipo = null;

    public TelaConsultarOs() {
        initComponents();
        // Chamada do metodo conector
        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        //Segunda parte da consulta ao banco de dados usando o ID_OS
        String sql = "SELECT tbl_Clientes.Nome_Cliente, tbl_OS.Data_OS, tbl_OS.Tipo_OS, tbl_OS.Situacao_OS, tbl_OS.Equipamento_OS, tbl_OS.Defeito_OS, tbl_OS.Servico_OS, tbl_OS.Tecnico_OS, tbl_OS.Valor_OS FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_cliente = tbl_OS.ID_cliente AND tbl_OS.ID_OS = ?;";
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
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }

    private void consultaRapida() {
        //Primeira parte da consulta ao banco de dados buscando pelo ID_OS
        String sql = "SELECT tbl_Clientes.Nome_Cliente AS Nome, tbl_OS.ID_OS AS OS, tbl_OS.Data_OS AS Data FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_Cliente = tbl_OS.ID_Cliente AND tbl_Clientes.Nome_Cliente LIKE ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtConsultar.getText() + "%");
            rs = pst.executeQuery();
            tblConsultar.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar() {
        //Seta os dados da tabela nos campos correspondentes
        int setar = tblConsultar.getSelectedRow();
        txtOs.setText(tblConsultar.getModel().getValueAt(setar, 1).toString());
    }

    private void limpar() {
        txtOs.setText(null);
        txtConsultar.setText(null);
        txtData.setText(null);
        rbtOs.setSelected(false);
        rbtOrc.setSelected(false);
        cboStatus.setSelectedItem("Na bancada");
        txtEquip.setText(null);
        txtDef.setText(null);
        txtServ.setText(null);
        txtTec.setText(null);
        tipo = null;
        txtValor.setText(null);
        rbtOrc.setSelected(false);
        rbtOs.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlOs = new javax.swing.JPanel();
        rbtOrc = new javax.swing.JRadioButton();
        rbtOs = new javax.swing.JRadioButton();
        pnlPainel = new javax.swing.JPanel();
        lblConsultar = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultar = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtTec = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        lblSit = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        cboStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        lblEquip = new javax.swing.JLabel();
        lblDef = new javax.swing.JLabel();
        lblServ = new javax.swing.JLabel();
        lblObg = new javax.swing.JLabel();
        lblTec = new javax.swing.JLabel();
        txtEquip = new javax.swing.JTextField();
        txtServ = new javax.swing.JTextField();
        txtDef = new javax.swing.JTextField();
        lblOs = new javax.swing.JLabel();
        txtOs = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultar Ordem de Serviço");

        pnlOs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        buttonGroup1.add(rbtOrc);
        rbtOrc.setText("Orçamento");
        rbtOrc.setEnabled(false);
        rbtOrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrcActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtOs);
        rbtOs.setText("Ordem de Serviço");
        rbtOs.setEnabled(false);
        rbtOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOsActionPerformed(evt);
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
                .addComponent(rbtOs)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlOsLayout.setVerticalGroup(
            pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtOrc)
                    .addComponent(rbtOs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPainel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lblConsultar.setText("Cliente");

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        tblConsultar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultar);

        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/lbl_os.png"))); // NOI18N
        btnConsulta.setPreferredSize(new java.awt.Dimension(129, 129));
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPainelLayout = new javax.swing.GroupLayout(pnlPainel);
        pnlPainel.setLayout(pnlPainelLayout);
        pnlPainelLayout.setHorizontalGroup(
            pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlPainelLayout.createSequentialGroup()
                        .addGroup(pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPainelLayout.createSequentialGroup()
                                .addComponent(lblConsultar)
                                .addGap(18, 18, 18)
                                .addComponent(txtConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(pnlPainelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPainelLayout.setVerticalGroup(
            pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPainelLayout.createSequentialGroup()
                .addGroup(pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPainelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnlPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConsultar)
                            .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btnLimpar))
                    .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtTec.setEnabled(false);

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValor.setText("Valor Total");

        lblSit.setText("Situação");

        txtValor.setText("0");
        txtValor.setEnabled(false);

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Na bancada", "Entrega concluída", "Orçamento reprovado", "Aguardando aprovação", "Aguardando peças", "Abandonado pelo cliente", "Retornou" }));
        cboStatus.setEnabled(false);
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osmestanza/icones/os_bancada.png"))); // NOI18N
        lblStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblEquip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEquip.setText("Equipamento*");

        lblDef.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDef.setText("Defeito*");

        lblServ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblServ.setText("Serviço");

        lblObg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObg.setText("Preencha os campos obrigatórios*");

        lblTec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTec.setText("Técnico");

        txtEquip.setEnabled(false);

        txtServ.setEnabled(false);

        txtDef.setEnabled(false);

        lblOs.setText("OS");

        txtOs.setEnabled(false);

        txtData.setEnabled(false);

        lblData.setText("Data");

        txtNome.setEnabled(false);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOs)
                                    .addComponent(lblData))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtOs)))
                            .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSit)
                                .addGap(64, 64, 64)
                                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatus)
                        .addGap(81, 81, 81)))
                .addComponent(pnlPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObg)
                    .addComponent(lblServ)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquip)
                            .addComponent(lblDef)
                            .addComponent(lblTec)
                            .addComponent(lblValor)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtEquip)
                            .addComponent(txtDef)
                            .addComponent(txtServ)
                            .addComponent(txtTec)
                            .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSit)
                            .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus)
                        .addGap(19, 19, 19))
                    .addComponent(pnlPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
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
                    .addComponent(txtTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblObg)
                .addGap(51, 51, 51))
        );

        setBounds(0, 0, 721, 752);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarKeyReleased
        consultaRapida();
    }//GEN-LAST:event_txtConsultarKeyReleased

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void tblConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultarMouseClicked
        setar();
    }//GEN-LAST:event_tblConsultarMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void rbtOrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrcActionPerformed
        //Atribui o valor orçamento a variavel tipo, se o botao for acionado
        tipo = "Orçamento";
    }//GEN-LAST:event_rbtOrcActionPerformed

    private void rbtOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOsActionPerformed
        //Atribui o valor OS a variavel tipo, se o botao for acionado
        tipo = "OS";
    }//GEN-LAST:event_rbtOsActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsultar;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDef;
    private javax.swing.JLabel lblEquip;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObg;
    private javax.swing.JLabel lblOs;
    private javax.swing.JLabel lblServ;
    private javax.swing.JLabel lblSit;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTec;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlOs;
    private javax.swing.JPanel pnlPainel;
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
