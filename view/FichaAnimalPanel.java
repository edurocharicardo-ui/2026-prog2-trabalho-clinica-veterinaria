package view;

import controller.VetController;
import model.Animal;
import java.util.HashMap;
import java.util.Map;

public class FichaAnimalPanel extends javax.swing.JPanel {

    private VetController controller;
    private Map<String, String[]> racasPorEspecie;
    private String fotoPath;

    public FichaAnimalPanel(VetController controller) {
        this.controller = controller;
        popularRacas();
        initComponents();
        configurarComponentes();
    }

    private void popularRacas() {
        racasPorEspecie = new HashMap<>();
        racasPorEspecie.put("Cao",    new String[]{"Labrador","Poodle","Bulldog","Pastor Alemao","Shih Tzu","SRD"});
        racasPorEspecie.put("Gato",   new String[]{"Siames","Persa","Maine Coon","Angora","SRD"});
        racasPorEspecie.put("Ave",    new String[]{"Canario","Periquito","Papagaio","Calopsita"});
        racasPorEspecie.put("Roedor", new String[]{"Hamster","Porquinho-da-india","Coelho","Chinchila"});
        racasPorEspecie.put("Reptil", new String[]{"Tartaruga","Iguana","Gecko","Cobra"});
    }

    private void configurarComponentes() {
        try {
            javax.swing.text.MaskFormatter m = new javax.swing.text.MaskFormatter("##/##/####");
            m.setPlaceholderCharacter('_');
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(m));
        } catch (java.text.ParseException ex) { /* ignora */ }
        atualizarRacas();
        barraICC.setUI(new javax.swing.plaf.basic.BasicProgressBarUI());
        barraICC.setStringPainted(true);
    }

    private void atualizarRacas() {
        String esp = (String) cmbEspecie.getSelectedItem();
        cmbRaca.removeAllItems();
        String[] racas = racasPorEspecie.getOrDefault(esp, new String[]{"SRD"});
        for (String r : racas) cmbRaca.addItem(r);
    }

    private void calcularICC() {
        double peso   = ((Number) spnPeso.getValue()).doubleValue();
        double altura = ((Number) spnAltura.getValue()).doubleValue();
        if (altura <= 0) { lblDiag.setText("Informe altura > 0"); return; }
        double icc = peso / (altura * altura);
        int pct = (int) Math.min(100, Math.max(0, icc / 50.0 * 100));
        barraICC.setValue(pct);
        if (icc < 18.5)      { barraICC.setForeground(java.awt.Color.BLUE);   barraICC.setString("Abaixo do peso"); lblDiag.setText("ICC: " + String.format("%.1f",icc) + " — Abaixo do peso"); }
        else if (icc < 25.0) { barraICC.setForeground(new java.awt.Color(0,160,0)); barraICC.setString("Peso ideal"); lblDiag.setText("ICC: " + String.format("%.1f",icc) + " — Peso ideal"); }
        else if (icc < 30.0) { barraICC.setForeground(java.awt.Color.ORANGE); barraICC.setString("Sobrepeso"); lblDiag.setText("ICC: " + String.format("%.1f",icc) + " — Sobrepeso"); }
        else                  { barraICC.setForeground(java.awt.Color.RED);    barraICC.setString("Obesidade"); lblDiag.setText("ICC: " + String.format("%.1f",icc) + " — Obesidade"); }
    }

    public boolean salvar() {
        if (txtNome.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Informe o nome do animal.", "Campo obrigatorio",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Animal a = controller.getAnimalAtual();
        a.setNome(txtNome.getText().trim());
        a.setEspecie((String) cmbEspecie.getSelectedItem());
        a.setRaca((String) cmbRaca.getSelectedItem());
        a.setDataNascimento(txtDataNasc.getText());
        a.setPeso(((Number) spnPeso.getValue()).doubleValue());
        a.setAltura(((Number) spnAltura.getValue()).doubleValue());
        a.setFotoPath(fotoPath);
        return true;
    }

    public void limparCampos() {
        txtNome.setText("");
        cmbEspecie.setSelectedIndex(0);
        try { txtDataNasc.setValue(null); } catch (Exception e) { txtDataNasc.setText(""); }
        spnPeso.setValue(1.0);
        spnAltura.setValue(0.1);
        lblFotoImg.setIcon(null);
        lblFotoImg.setText("Sem foto");
        barraICC.setValue(0);
        barraICC.setString("");
        lblDiag.setText(" ");
        fotoPath = null;
    }

    public void carregarDados(Animal a) {
        limparCampos();
        if (a == null) return;
        txtNome.setText(a.getNome() != null ? a.getNome() : "");
        if (a.getEspecie() != null) cmbEspecie.setSelectedItem(a.getEspecie());
        atualizarRacas();
        if (a.getRaca() != null) cmbRaca.setSelectedItem(a.getRaca());
        txtDataNasc.setText(a.getDataNascimento() != null ? a.getDataNascimento() : "");
        spnPeso.setValue(a.getPeso() > 0 ? a.getPeso() : 1.0);
        spnAltura.setValue(a.getAltura() > 0 ? a.getAltura() : 0.1);
        fotoPath = a.getFotoPath();
        if (fotoPath != null) {
            java.io.File f = new java.io.File(fotoPath);
            if (f.exists()) {
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(fotoPath);
                java.awt.Image img = icon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                lblFotoImg.setIcon(new javax.swing.ImageIcon(img));
                lblFotoImg.setText("");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome       = new javax.swing.JLabel();
        txtNome       = new javax.swing.JTextField();
        lblEspecie    = new javax.swing.JLabel();
        cmbEspecie    = new javax.swing.JComboBox<>();
        lblRaca       = new javax.swing.JLabel();
        cmbRaca       = new javax.swing.JComboBox<>();
        lblDataNasc   = new javax.swing.JLabel();
        txtDataNasc   = new javax.swing.JFormattedTextField();
        lblPeso       = new javax.swing.JLabel();
        spnPeso       = new javax.swing.JSpinner();
        lblAltura     = new javax.swing.JLabel();
        spnAltura     = new javax.swing.JSpinner();
        lblICC        = new javax.swing.JLabel();
        barraICC      = new javax.swing.JProgressBar();
        lblDiag       = new javax.swing.JLabel();
        btnCalcular   = new javax.swing.JButton();
        lblFotoTitulo = new javax.swing.JLabel();
        lblFotoImg    = new javax.swing.JLabel();
        btnFoto       = new javax.swing.JButton();

        lblNome.setText("Nome do Animal:");
        lblEspecie.setText("Especie:");
        lblRaca.setText("Raca:");
        lblDataNasc.setText("Data Nasc.:");
        lblPeso.setText("Peso (kg):");
        lblAltura.setText("Altura (m):");
        lblICC.setText("ICC:");
        lblDiag.setText(" ");
        lblFotoTitulo.setText("Foto:");
        lblFotoImg.setText("Sem foto");
        lblFotoImg.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY));
        lblFotoImg.setPreferredSize(new java.awt.Dimension(120, 120));
        lblFotoImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cmbEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Cao","Gato","Ave","Roedor","Reptil"}));
        cmbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecieActionPerformed(evt);
            }
        });

        cmbRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"SRD"}));

        spnPeso.setModel(new javax.swing.SpinnerNumberModel(1.0, 0.1, 200.0, 0.1));
        spnAltura.setModel(new javax.swing.SpinnerNumberModel(0.1, 0.01, 3.0, 0.01));

        barraICC.setStringPainted(true);

        btnCalcular.setText("Calcular ICC");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnFoto.setText("Selecionar Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome).addComponent(lblEspecie).addComponent(lblRaca)
                    .addComponent(lblDataNasc).addComponent(lblPeso).addComponent(lblAltura)
                    .addComponent(lblICC))
                .addGap(12,12,12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(cmbEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(cmbRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(spnPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(spnAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraICC, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(8,8,8)
                        .addComponent(btnCalcular))
                    .addComponent(lblDiag))
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblFotoTitulo)
                    .addComponent(lblFotoImg, -2, 120, -2)
                    .addComponent(btnFoto))
                .addGap(18,18,18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12,12,12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecie)
                    .addComponent(cmbEspecie, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaca)
                    .addComponent(cmbRaca, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNasc)
                    .addComponent(txtDataNasc, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(spnPeso, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAltura)
                    .addComponent(spnAltura, -2,-2,-2))
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblICC)
                    .addComponent(barraICC, -2, 22, -2)
                    .addComponent(btnCalcular))
                .addGap(4,4,4)
                .addComponent(lblDiag)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12,12,12)
                .addComponent(lblFotoTitulo)
                .addGap(4,4,4)
                .addComponent(lblFotoImg, -2, 120, -2)
                .addGap(8,8,8)
                .addComponent(btnFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecieActionPerformed
        atualizarRacas();
    }//GEN-LAST:event_cmbEspecieActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcularICC();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens","jpg","jpeg","png","gif","bmp"));
        if (fc.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            fotoPath = fc.getSelectedFile().getAbsolutePath();
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(fotoPath);
            java.awt.Image img = icon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
            lblFotoImg.setIcon(new javax.swing.ImageIcon(img));
            lblFotoImg.setText("");
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraICC;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnFoto;
    private javax.swing.JComboBox<String> cmbEspecie;
    private javax.swing.JComboBox<String> cmbRaca;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblDiag;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblFotoImg;
    private javax.swing.JLabel lblFotoTitulo;
    private javax.swing.JLabel lblICC;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JSpinner spnAltura;
    private javax.swing.JSpinner spnPeso;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
