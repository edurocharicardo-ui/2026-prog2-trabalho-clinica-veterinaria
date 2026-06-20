package view;

import controller.VetController;
import model.Tutor;

public class TutorPanel extends javax.swing.JPanel {

    private VetController controller;

    public TutorPanel(VetController controller) {
        this.controller = controller;
        initComponents();
        configurarMascaras();
    }

    private void configurarMascaras() {
        try {
            javax.swing.text.MaskFormatter mCPF = new javax.swing.text.MaskFormatter("###.###.###-##");
            mCPF.setPlaceholderCharacter('_');
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mCPF));

            javax.swing.text.MaskFormatter mTel = new javax.swing.text.MaskFormatter("(##) #####-####");
            mTel.setPlaceholderCharacter('_');
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mTel));
        } catch (java.text.ParseException ex) { /* ignora */ }
    }

    public void salvar() {
        Tutor t = controller.getAnimalAtual().getTutor();
        if (t == null) { t = new Tutor(); controller.getAnimalAtual().setTutor(t); }
        t.setNome(txtNome.getText());
        t.setCpf(txtCPF.getText());
        t.setTelefone(txtTelefone.getText());
        t.setEmail(txtEmail.getText());
        t.setEndereco(txtEndereco.getText());
    }

    public void limparCampos() {
        txtNome.setText("");
        try { txtCPF.setValue(null); } catch (Exception e) { txtCPF.setText(""); }
        try { txtTelefone.setValue(null); } catch (Exception e) { txtTelefone.setText(""); }
        txtEmail.setText("");
        txtEndereco.setText("");
    }

    public void carregarDados(Tutor t) {
        limparCampos();
        if (t == null) return;
        txtNome.setText(t.getNome() != null ? t.getNome() : "");
        txtCPF.setText(t.getCpf() != null ? t.getCpf() : "");
        txtTelefone.setText(t.getTelefone() != null ? t.getTelefone() : "");
        txtEmail.setText(t.getEmail() != null ? t.getEmail() : "");
        txtEndereco.setText(t.getEndereco() != null ? t.getEndereco() : "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeTutor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        btnSalvarTutor = new javax.swing.JButton();

        lblNomeTutor.setText("Nome do Tutor:");
        lblCPF.setText("CPF:");
        lblTelefone.setText("Telefone:");
        lblEmail.setText("E-mail:");
        lblEndereco.setText("Endereco:");
        btnSalvarTutor.setText("Salvar Dados do Tutor");
        btnSalvarTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeTutor)
                    .addComponent(lblCPF)
                    .addComponent(lblTelefone)
                    .addComponent(lblEmail)
                    .addComponent(lblEndereco))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtCPF)
                    .addComponent(txtTelefone)
                    .addComponent(txtEmail)
                    .addComponent(txtEndereco)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvarTutor)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeTutor)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvarTutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTutorActionPerformed
        salvar();
        javax.swing.JOptionPane.showMessageDialog(this, "Dados do tutor salvos!");
    }//GEN-LAST:event_btnSalvarTutorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarTutor;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNomeTutor;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
