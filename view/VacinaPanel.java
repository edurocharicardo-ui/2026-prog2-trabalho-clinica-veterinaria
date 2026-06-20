package view;

import controller.VetController;
import model.Animal;
import model.Vacina;

public class VacinaPanel extends javax.swing.JPanel {

    private VetController controller;
    private static final String[] NOMES = {"Raiva","V8 / V10","Giardase","Gripe Felina","FIV / FeLV"};
    private static final int[] MESES   = {12, 12, 6, 12, 12};
    private static final java.time.format.DateTimeFormatter FMT =
        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VacinaPanel(VetController controller) {
        this.controller = controller;
        initComponents();
        configurarMascaras();
    }

    private void configurarMascaras() {
        javax.swing.JFormattedTextField[] campos = {txtData0,txtData1,txtData2,txtData3,txtData4};
        for (javax.swing.JFormattedTextField f : campos) {
            try {
                javax.swing.text.MaskFormatter m = new javax.swing.text.MaskFormatter("##/##/####");
                m.setPlaceholderCharacter('_');
                f.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(m));
            } catch (java.text.ParseException ex) { /* ignora */ }
        }
    }

    private void recalcular(int idx) {
        javax.swing.JCheckBox[] cks = {chkRaiva,chkV8,chkGiardase,chkGripeFelina,chkFIVFeLV};
        javax.swing.JFormattedTextField[] dts = {txtData0,txtData1,txtData2,txtData3,txtData4};
        javax.swing.JLabel[] lbs = {lblProx0,lblProx1,lblProx2,lblProx3,lblProx4};
        if (!cks[idx].isSelected()) { lbs[idx].setText("--/--/----"); lbs[idx].setForeground(java.awt.Color.GRAY); return; }
        String txt = dts[idx].getText().replace("_","").trim();
        if (txt.length() < 10) { lbs[idx].setText("data invalida"); lbs[idx].setForeground(java.awt.Color.GRAY); return; }
        try {
            java.time.LocalDate ultima  = java.time.LocalDate.parse(txt, FMT);
            java.time.LocalDate proxima = ultima.plusMonths(MESES[idx]);
            lbs[idx].setText(proxima.format(FMT));
            lbs[idx].setForeground(proxima.isBefore(java.time.LocalDate.now())
                ? java.awt.Color.RED : new java.awt.Color(0,128,0));
        } catch (java.time.format.DateTimeParseException ex) {
            lbs[idx].setText("data invalida"); lbs[idx].setForeground(java.awt.Color.GRAY);
        }
    }

    public void salvar() {
        Animal a = controller.getAnimalAtual();
        a.getVacinas().clear();
        javax.swing.JCheckBox[] cks = {chkRaiva,chkV8,chkGiardase,chkGripeFelina,chkFIVFeLV};
        javax.swing.JFormattedTextField[] dts = {txtData0,txtData1,txtData2,txtData3,txtData4};
        javax.swing.JLabel[] lbs = {lblProx0,lblProx1,lblProx2,lblProx3,lblProx4};
        for (int i = 0; i < NOMES.length; i++) {
            Vacina v = new Vacina(NOMES[i]);
            v.setAplicada(cks[i].isSelected());
            v.setUltimaDose(dts[i].getText());
            v.setProximaDose(lbs[i].getText());
            a.adicionarVacina(v);
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Vacinas salvas!");
    }

    public void resetar() {
        javax.swing.JCheckBox[] cks = {chkRaiva,chkV8,chkGiardase,chkGripeFelina,chkFIVFeLV};
        javax.swing.JFormattedTextField[] dts = {txtData0,txtData1,txtData2,txtData3,txtData4};
        javax.swing.JLabel[] lbs = {lblProx0,lblProx1,lblProx2,lblProx3,lblProx4};
        for (int i = 0; i < NOMES.length; i++) {
            cks[i].setSelected(false);
            try { dts[i].setValue(null); } catch (Exception e) { dts[i].setText(""); }
            lbs[i].setText("--/--/----"); lbs[i].setForeground(java.awt.Color.GRAY);
        }
    }

    public void atualizarVacinas() {
        resetar();
        Animal a = controller.getAnimalAtual();
        if (a == null) return;
        javax.swing.JCheckBox[] cks = {chkRaiva,chkV8,chkGiardase,chkGripeFelina,chkFIVFeLV};
        javax.swing.JFormattedTextField[] dts = {txtData0,txtData1,txtData2,txtData3,txtData4};
        for (Vacina v : a.getVacinas()) {
            for (int i = 0; i < NOMES.length; i++) {
                if (NOMES[i].equals(v.getNome())) {
                    cks[i].setSelected(v.isAplicada());
                    if (v.getUltimaDose() != null) dts[i].setText(v.getUltimaDose());
                    recalcular(i);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo    = new javax.swing.JLabel();
        lblColVacina = new javax.swing.JLabel();
        lblColAplic  = new javax.swing.JLabel();
        lblColUltima = new javax.swing.JLabel();
        lblColProx   = new javax.swing.JLabel();
        sep          = new javax.swing.JSeparator();

        chkRaiva      = new javax.swing.JCheckBox();
        txtData0      = new javax.swing.JFormattedTextField();
        lblProx0      = new javax.swing.JLabel();
        chkV8         = new javax.swing.JCheckBox();
        txtData1      = new javax.swing.JFormattedTextField();
        lblProx1      = new javax.swing.JLabel();
        chkGiardase   = new javax.swing.JCheckBox();
        txtData2      = new javax.swing.JFormattedTextField();
        lblProx2      = new javax.swing.JLabel();
        chkGripeFelina = new javax.swing.JCheckBox();
        txtData3      = new javax.swing.JFormattedTextField();
        lblProx3      = new javax.swing.JLabel();
        chkFIVFeLV    = new javax.swing.JCheckBox();
        txtData4      = new javax.swing.JFormattedTextField();
        lblProx4      = new javax.swing.JLabel();
        btnSalvar     = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 16));
        lblTitulo.setText("Controle de Vacinas");
        lblColVacina.setFont(new java.awt.Font("Arial", 1, 12)); lblColVacina.setText("Vacina");
        lblColAplic.setFont(new java.awt.Font("Arial", 1, 12));  lblColAplic.setText("Aplicada?");
        lblColUltima.setFont(new java.awt.Font("Arial", 1, 12)); lblColUltima.setText("Ultima Dose");
        lblColProx.setFont(new java.awt.Font("Arial", 1, 12));   lblColProx.setText("Proxima Dose");

        chkRaiva.setText("Raiva");
        chkV8.setText("V8 / V10");
        chkGiardase.setText("Giardase");
        chkGripeFelina.setText("Gripe Felina");
        chkFIVFeLV.setText("FIV / FeLV");

        lblProx0.setText("--/--/----"); lblProx0.setForeground(java.awt.Color.GRAY);
        lblProx1.setText("--/--/----"); lblProx1.setForeground(java.awt.Color.GRAY);
        lblProx2.setText("--/--/----"); lblProx2.setForeground(java.awt.Color.GRAY);
        lblProx3.setText("--/--/----"); lblProx3.setForeground(java.awt.Color.GRAY);
        lblProx4.setText("--/--/----"); lblProx4.setForeground(java.awt.Color.GRAY);

        chkRaiva.addActionListener(e -> recalcular(0));
        chkV8.addActionListener(e -> recalcular(1));
        chkGiardase.addActionListener(e -> recalcular(2));
        chkGripeFelina.addActionListener(e -> recalcular(3));
        chkFIVFeLV.addActionListener(e -> recalcular(4));
        txtData0.addPropertyChangeListener("value", e -> recalcular(0));
        txtData1.addPropertyChangeListener("value", e -> recalcular(1));
        txtData2.addPropertyChangeListener("value", e -> recalcular(2));
        txtData3.addPropertyChangeListener("value", e -> recalcular(3));
        txtData4.addPropertyChangeListener("value", e -> recalcular(4));

        btnSalvar.setText("Salvar Vacinas");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        int TW = 120; // largura das colunas de data

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblColVacina)
                            .addComponent(chkRaiva, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(chkV8, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(chkGiardase, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(chkGripeFelina, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(chkFIVFeLV, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18,18,18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblColAplic))
                        .addGap(30,30,30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblColUltima)
                            .addComponent(txtData0, -2, TW, -2)
                            .addComponent(txtData1, -2, TW, -2)
                            .addComponent(txtData2, -2, TW, -2)
                            .addComponent(txtData3, -2, TW, -2)
                            .addComponent(txtData4, -2, TW, -2))
                        .addGap(18,18,18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblColProx)
                            .addComponent(lblProx0, -2, 100, -2)
                            .addComponent(lblProx1, -2, 100, -2)
                            .addComponent(lblProx2, -2, 100, -2)
                            .addComponent(lblProx3, -2, 100, -2)
                            .addComponent(lblProx4, -2, 100, -2)))
                    .addComponent(sep, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18,18,18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12,12,12)
                .addComponent(lblTitulo)
                .addGap(8,8,8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColVacina).addComponent(lblColAplic)
                    .addComponent(lblColUltima).addComponent(lblColProx))
                .addGap(4,4,4)
                .addComponent(sep, -2, 2, -2)
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkRaiva).addComponent(txtData0,-2,-2,-2).addComponent(lblProx0))
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkV8).addComponent(txtData1,-2,-2,-2).addComponent(lblProx1))
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkGiardase).addComponent(txtData2,-2,-2,-2).addComponent(lblProx2))
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkGripeFelina).addComponent(txtData3,-2,-2,-2).addComponent(lblProx3))
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkFIVFeLV).addComponent(txtData4,-2,-2,-2).addComponent(lblProx4))
                .addGap(18,18,18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkFIVFeLV;
    private javax.swing.JCheckBox chkGiardase;
    private javax.swing.JCheckBox chkGripeFelina;
    private javax.swing.JCheckBox chkRaiva;
    private javax.swing.JCheckBox chkV8;
    private javax.swing.JLabel lblColAplic;
    private javax.swing.JLabel lblColProx;
    private javax.swing.JLabel lblColUltima;
    private javax.swing.JLabel lblColVacina;
    private javax.swing.JLabel lblProx0;
    private javax.swing.JLabel lblProx1;
    private javax.swing.JLabel lblProx2;
    private javax.swing.JLabel lblProx3;
    private javax.swing.JLabel lblProx4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator sep;
    private javax.swing.JFormattedTextField txtData0;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    private javax.swing.JFormattedTextField txtData3;
    private javax.swing.JFormattedTextField txtData4;
    // End of variables declaration//GEN-END:variables
}
