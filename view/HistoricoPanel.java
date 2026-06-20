package view;

import controller.VetController;
import model.Consulta;

public class HistoricoPanel extends javax.swing.JPanel {

    private VetController controller;
    private javax.swing.table.DefaultTableModel modeloTabela;

    public HistoricoPanel(VetController controller) {
        this.controller = controller;
        initComponents();
        configurarTabela();
    }

    private void configurarTabela() {
        modeloTabela = new javax.swing.table.DefaultTableModel(
            new String[]{"Data", "Veterinario", "Motivo", "Observacoes"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblHistorico.setModel(modeloTabela);
        tblHistorico.getTableHeader().setReorderingAllowed(false);
        tblHistorico.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Consulta c : controller.getAnimalAtual().getConsultas()) {
            modeloTabela.addRow(new Object[]{
                c.getData(), c.getVeterinario(), c.getMotivo(), c.getObservacoes()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTabela = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        btnNovaConsulta = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Data", "Veterinario", "Motivo", "Observacoes"}
        ));
        scrollTabela.setViewportView(tblHistorico);

        btnNovaConsulta.setText("Nova Consulta");
        btnNovaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaConsultaActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14));
        lblTitulo.setText("Historico de Consultas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(scrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovaConsulta)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovaConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaConsultaActionPerformed
        NovaConsultaDialog dlg = new NovaConsultaDialog(
            (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this),
            controller);
        dlg.setVisible(true);
        atualizarTabela();
    }//GEN-LAST:event_btnNovaConsultaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaConsulta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tblHistorico;
    // End of variables declaration//GEN-END:variables
}
