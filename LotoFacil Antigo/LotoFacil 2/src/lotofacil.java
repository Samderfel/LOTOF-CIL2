//package meuapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;


public class lotofacil extends JFrame {

    //atributos
    private JPanel painel = new JPanel();
    private JLabel jLabelMensagem = new JLabel("Escolha qual aposta deseja fazer: ");
    private JButton jButtonApostar = new JButton("Apostar");
    private JRadioButton jRadioButtonOpcao = new JRadioButton("Aposta de 0 a 100");
    private JRadioButton jRadioButtonOpcao2 = new JRadioButton("Apostar A à Z");
    private JRadioButton jRadioButtonOpcao3 = new JRadioButton("Apostar PAR ou ÍMPAR");
    private JLabel jLabel1 = new JLabel("Digite sua Aposta:");
    private JTextField jTextField1 = new JTextField("" , 20);
    private JLabel jLabel2 = new JLabel("Sorteio");
    private ButtonGroup buttonGroup = new ButtonGroup();


    //construtor
    public lotofacil(){
        this.setTitle("Lotofácil");
        this.setSize(400,400);
        configurarComponentes();
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setVisible(true); // Exibir janela
    }

    private void configurarComponentes() {
        jButtonApostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostar();
            }
        });
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        jTextField1.setFont(new Font("Arial", Font.PLAIN,16));
        painel.add(jLabelMensagem);

        buttonGroup.add(jRadioButtonOpcao);
        buttonGroup.add(jRadioButtonOpcao2);
        buttonGroup.add(jRadioButtonOpcao3);


        painel.add(jRadioButtonOpcao);
        painel.add(jRadioButtonOpcao2);
        painel.add(jRadioButtonOpcao3);
        painel.add(jLabel1);
        painel.add(jTextField1);
        painel.add(jLabel2);

        painel.add(jButtonApostar);
        this.getContentPane().add(painel);
    }
    private void apostar() {
        if (jRadioButtonOpcao.isSelected()) {
            SecureRandom random = new SecureRandom();
            int rand = random.nextInt(101); //
            try {
                int value = Integer.parseInt(jTextField1.getText());
                if (value >= 0 && value <= 100) {
                    if (value == rand) {
                        jLabel2.setText("Parabéns! Seu número foi sorteado. Você ganhou R$ 1.000,00 reais!");
                    } else {
                        jLabel2.setText("Seu número não foi sorteado.\n" +
                                "Numero sorteado:" +rand+ "\n Número escolhido: "+ value);

                    }
                } else {
                    jLabel2.setText("Por favor, insira um número entre 0 e 100.");
                }
            } catch (NumberFormatException e) {
                jLabel2.setText("Por favor, insira um número válido.");
            }

        } else if (jRadioButtonOpcao2.isSelected()){
            char aposta = jTextField1.getText().charAt(0);
            char let = 'M';
            if(Character.isLetter(aposta)){
                aposta = Character.toUpperCase(aposta);
                if (aposta == let){
                    jLabel2.setText("Parabéns a lestra sorteada foi: "+ let);
                }else
                    jLabel2.setText("Desculpe a letra escolhida foi: "+ aposta+ " A letra premiada é: "+let);
            }
        } else if (jRadioButtonOpcao3.isSelected()) {
            int value = Integer.parseInt(jTextField1.getText());
            if (value %2 == 0){
                jLabel2.setText("Parabéns o número sorteado foi par "+ value);
            }else
                jLabel2.setText("Desculpe o sroteio foi para numeros pares e não impar");
        }
    }

    public static void main(String[] args) {
        new lotofacil();
    }
}
