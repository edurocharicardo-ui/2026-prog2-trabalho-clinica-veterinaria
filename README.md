# Clinica Veterinaria - Ficha de Paciente

**Trabalho em Grupo — Programacao Visual com Java Swing**
**Tema 10 — 2026-prog2-trabalho-clinica-veterinaria**

---

## Integrantes

- Eduardo Rocha Ricardo
- Nicolas Baiffus

---

## Video de Demonstracao

https://youtu.be/GJQ-KvivuqM

---

## Descricao

Sistema desktop para uma clinica veterinaria ficticia. Permite cadastrar fichas de animais
e de seus tutores, acompanhar o historico de consultas medicas e controlar o calendario
de vacinas. Desenvolvido em Java Swing seguindo o padrao MVC.

---

## Funcionalidades

- Cadastro de animal: nome, especie, raca, data de nascimento, peso, altura e foto
- Combobox de racas atualizado automaticamente ao trocar a especie
- Calculo do Indice de Condicao Corporal (ICC) com barra de progresso colorida
- Cadastro de tutor com mascaras de CPF e telefone
- Historico de consultas em tabela, com dialog para adicionar novas consultas
- Controle de vacinas com alerta de cor para doses vencidas
- Busca de pacientes com filtragem dinamica enquanto o usuario digita
- Menu com atalhos de teclado (Ctrl+N, Ctrl+S, Ctrl+F)

---

## Como compilar e executar

### Windows

```
compilar.bat
```

### Linux / Mac

```
chmod +x compilar.sh
./compilar.sh
```


**Requisito:** Java 11 ou superior instalado.

---

## Componentes Swing utilizados

JTextField, JComboBox (encadeado dinamico), JFormattedTextField, JSpinner,
JFileChooser, JLabel (ImageIcon), JProgressBar, JTable, JDialog, JTextArea,
JCheckBox, JMenuBar, JOptionPane
