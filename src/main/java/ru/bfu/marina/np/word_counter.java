package ru.bfu.marina.np;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class word_counter extends Component {
    private JPanel panel1;
    private JTextArea textArea;
    private JButton textColorButton;
    private JButton countButton;
    private JButton padButton;
    private JLabel cha;
    private JLabel word;
    private JPanel panel;
    private JButton resetButton;
    private JScrollPane scroll;

    word_counter(){
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(500,300);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        frame.add(panel);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText().trim();
                cha.setText("Characters (with spaces): " + text.length());

                if (text.isEmpty()) {
                    word.setText("Words: 0");
                } else {
                    String[] words = text.split("\\P{L}+");
                    word.setText("Words: " + words.length);
                }
            }
        });
        padButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(textArea, "Choose the color to use",Color.black);
                textArea.setBackground(c);
            }
        });
        textColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(textArea, "Choose the color to use",Color.black);
                textArea.setForeground(c);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

    }
    public static void main(String[] args) { new word_counter(); }

}
