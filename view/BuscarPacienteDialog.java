package view;

import controller.VetController;
import model.Animal;
import java.util.List;

public class BuscarPacienteDialog extends javax.swing.JDialog {

    private VetController controller;
    private javax.swing.table.DefaultTableModel modeloTabela;
    private Animal animalSelecionado;

    public BuscarPacienteDialog(java.awt.Frame parent, VetController controller) {
        super(parent, "Buscar Paciente", true);
        this.controller = controller;
        initComponents();
        configurarTabela();
        setLocationRelativeTo(parent);
        filtrar();
    }

    private void configurarTabela() {
        modeloTabela = new javax.swing.table.DefaultTableModel(
            new String[]{"Nome", "Especie", "Raca", "Nascimento"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblResultados.setModel(modeloTabela);
        tblResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblResultados.getTableHeader().setReorderingAllowed(false);
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) confirmar();
            }
        });
    }

    private void filtrar() {
        modeloTabela.setRowCount(0);
        String texto = txtBusca.getText().trim();
        List<Animal> lista = texto.isEmpty() ? controller.getAnimais() : controller.buscarPorNome(texto);
        for (Animal a : lista) {
            modeloTabela.addRow(new Object[]{
                a.getNome(), a.getEspecie(), a.getRaca(), a.getDataNascimento()
            });
        }
    }

    private void confirmar() {
        int linha = tblResultados.getSelectedRow();
        if (linha < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um paciente.", "Aviso",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        String texto = txtBusca.getText().trim();
        List<Animal> lista = texto.isEmpty() ? controller.getAnimais() : controller.buscarPorNome(texto);
        animalSelecionado = lista.get(linha);
        dispose();
    }

    public Animal getAnimalSelecionado() { return animalSelecionado; }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        scrollResultados = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Paciente");

        lblBusca.setText("Nome do paciente:");

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Nome", "Especie", "Raca", "Nascimento"}
        ));
        scrollResultados.setViewportView(tblResultados);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
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
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBusca)
                        .addGap(8, 8, 8)
                        .addComponent(txtBusca))
                    .addComponent(scrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(8, 8, 8)
                        .addComponent(btnSelecionar)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(scrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnCancelar))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        filtrar();
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
