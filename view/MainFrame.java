package view;

import controller.VetController;
import model.Animal;

public class MainFrame extends javax.swing.JFrame {

    private VetController    controller;
    private FichaAnimalPanel fichaPanel;
    private TutorPanel       tutorPanel;
    private HistoricoPanel   historicoPanel;
    private VacinaPanel      vacinaPanel;

    public MainFrame() {
        controller     = new VetController();
        fichaPanel     = new FichaAnimalPanel(controller);
        tutorPanel     = new TutorPanel(controller);
        historicoPanel = new HistoricoPanel(controller);
        vacinaPanel    = new VacinaPanel(controller);
        initComponents();
        // adiciona os paineis de negocio nas abas criadas pelo GUI Builder
        abas.addTab("Ficha do Animal",        fichaPanel);
        abas.addTab("Dados do Tutor",         tutorPanel);
        abas.addTab("Historico de Consultas", historicoPanel);
        abas.addTab("Controle de Vacinas",    vacinaPanel);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas      = new javax.swing.JTabbedPane();
        menuBar   = new javax.swing.JMenuBar();
        menuArq   = new javax.swing.JMenu();
        itemNovo  = new javax.swing.JMenuItem();
        itemSalvar= new javax.swing.JMenuItem();
        sepArq    = new javax.swing.JPopupMenu.Separator();
        itemSair  = new javax.swing.JMenuItem();
        menuPac   = new javax.swing.JMenu();
        itemBuscar = new javax.swing.JMenuItem();
        itemRemover= new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica Veterinaria - Sistema de Fichas");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(860, 620));

        menuArq.setText("Arquivo");
        menuArq.setMnemonic('A');

        itemNovo.setText("Novo Paciente");
        itemNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { itemNovoActionPerformed(evt); }
        });

        itemSalvar.setText("Salvar Paciente");
        itemSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { itemSalvarActionPerformed(evt); }
        });

        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { itemSairActionPerformed(evt); }
        });

        menuArq.add(itemNovo);
        menuArq.add(itemSalvar);
        menuArq.add(sepArq);
        menuArq.add(itemSair);

        menuPac.setText("Paciente");
        menuPac.setMnemonic('P');

        itemBuscar.setText("Buscar Paciente");
        itemBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { itemBuscarActionPerformed(evt); }
        });

        itemRemover.setText("Remover Paciente Atual");
        itemRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { itemRemoverActionPerformed(evt); }
        });

        menuPac.add(itemBuscar);
        menuPac.add(itemRemover);

        menuBar.add(menuArq);
        menuBar.add(menuPac);
        setJMenuBar(menuBar);

        getContentPane().add(abas, java.awt.BorderLayout.CENTER);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovoActionPerformed
        int op = javax.swing.JOptionPane.showConfirmDialog(this,
            "Salvar paciente atual antes de criar um novo?",
            "Novo Paciente", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);
        if (op == javax.swing.JOptionPane.CANCEL_OPTION) return;
        if (op == javax.swing.JOptionPane.YES_OPTION) salvarAtual();
        controller.novoAnimal();
        fichaPanel.limparCampos();
        tutorPanel.limparCampos();
        historicoPanel.atualizarTabela();
        vacinaPanel.resetar();
    }//GEN-LAST:event_itemNovoActionPerformed

    private void itemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalvarActionPerformed
        salvarAtual();
    }//GEN-LAST:event_itemSalvarActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        if (javax.swing.JOptionPane.showConfirmDialog(this, "Deseja sair?", "Sair",
                javax.swing.JOptionPane.YES_NO_OPTION) == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_itemSairActionPerformed

    private void itemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarActionPerformed
        BuscarPacienteDialog dlg = new BuscarPacienteDialog(this, controller);
        dlg.setVisible(true);
        Animal sel = dlg.getAnimalSelecionado();
        if (sel != null) {
            controller.setAnimalAtual(sel);
            fichaPanel.carregarDados(sel);
            tutorPanel.carregarDados(sel.getTutor());
            historicoPanel.atualizarTabela();
            vacinaPanel.atualizarVacinas();
            abas.setSelectedIndex(0);
        }
    }//GEN-LAST:event_itemBuscarActionPerformed

    private void itemRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRemoverActionPerformed
        Animal atual = controller.getAnimalAtual();
        if (atual == null || atual.getNome() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhum paciente selecionado.");
            return;
        }
        int op = javax.swing.JOptionPane.showConfirmDialog(this,
            "Remover '" + atual.getNome() + "' permanentemente?",
            "Confirmar remocao", javax.swing.JOptionPane.YES_NO_OPTION);
        if (op == javax.swing.JOptionPane.YES_OPTION) {
            controller.removerAnimal(atual);
            controller.novoAnimal();
            fichaPanel.limparCampos();
            tutorPanel.limparCampos();
            historicoPanel.atualizarTabela();
            vacinaPanel.resetar();
            javax.swing.JOptionPane.showMessageDialog(this, "Paciente removido.");
        }
    }//GEN-LAST:event_itemRemoverActionPerformed

    private void salvarAtual() {
        if (fichaPanel.salvar()) {
            tutorPanel.salvar();
            controller.salvarAnimal();
            javax.swing.JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JMenuItem itemBuscar;
    private javax.swing.JMenuItem itemNovo;
    private javax.swing.JMenuItem itemRemover;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSalvar;
    private javax.swing.JMenu menuArq;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuPac;
    private javax.swing.JPopupMenu.Separator sepArq;
    // End of variables declaration//GEN-END:variables
}
