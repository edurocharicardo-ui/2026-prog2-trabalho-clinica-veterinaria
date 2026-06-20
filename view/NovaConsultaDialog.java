package view;

import controller.VetController;
import model.Consulta;

public class NovaConsultaDialog extends javax.swing.JDialog {

    private VetController controller;

    public NovaConsultaDialog(java.awt.Frame parent, VetController controller) {
        super(parent, "Nova Consulta", true);
        this.controller = controller;
        initComponents();
        configurarData();
        setLocationRelativeTo(parent);
    }

    private void configurarData() {
        try {
            javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mask));
        } catch (java.text.ParseException ex) { /* ignora */ }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblVet = new javax.swing.JLabel();
        txtVeterinario = new javax.swing.JTextField();
        lblMotivo = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        scrollObs = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblData.setText("Data da Consulta:");
        lblVet.setText("Veterinario:");
        lblMotivo.setText("Motivo:");
        lblObs.setText("Observacoes:");

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(4);
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);
        scrollObs.setViewportView(txtObservacoes);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData)
                    .addComponent(lblVet)
                    .addComponent(lblMotivo)
                    .addComponent(lblObs))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtData)
                    .addComponent(txtVeterinario)
                    .addComponent(txtMotivo)
                    .addComponent(scrollObs, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(8, 8, 8)
                        .addComponent(btnSalvar)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVet)
                    .addComponent(txtVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotivo)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObs)
                    .addComponent(scrollObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String data = txtData.getText().replace("_","").trim();
        String vet  = txtVeterinario.getText().trim();
        String mot  = txtMotivo.getText().trim();
        if (data.isEmpty() || vet.isEmpty() || mot.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Preencha data, veterinario e motivo.", "Campos obrigatorios",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        Consulta c = new Consulta(data, vet, mot, txtObservacoes.getText());
        controller.getAnimalAtual().adicionarConsulta(c);
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblVet;
    private javax.swing.JScrollPane scrollObs;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtVeterinario;
    // End of variables declaration//GEN-END:variables
}
