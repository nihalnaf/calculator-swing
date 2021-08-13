import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{

    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, negButton;
    JButton decButton, equButton, delButton, clrButton, perButton;
    JPanel panel1;

    Font font = new Font("Helvetica", Font.PLAIN, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        ImageIcon icon = new ImageIcon("Calculator Icon.png");

        this.setTitle("Calculator");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setResizable(false);
        this.setSize(420, 550);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(0, 0, 420, 240);
        textfield.setFont(font);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("AC");
        negButton = new JButton("+/-");
        perButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = perButton;

        for(int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(null);
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
            functionButtons[i].setForeground(new Color(102, 163, 255));
        }

        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBorder(null);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
        }

        panel1 = new JPanel();
        panel1.setBounds(0, 240, 420, 280);
        panel1.setLayout(new GridLayout(5, 4, 0, 0));
        panel1.setBackground(Color.GRAY);

        panel1.add(clrButton);
        panel1.add(negButton);
        panel1.add(perButton);
        panel1.add(delButton);

        panel1.add(numberButtons[7]);
        panel1.add(numberButtons[8]);
        panel1.add(numberButtons[9]);
        panel1.add(divButton);

        panel1.add(numberButtons[4]);
        panel1.add(numberButtons[5]);
        panel1.add(numberButtons[6]);
        panel1.add(mulButton);

        panel1.add(numberButtons[1]);
        panel1.add(numberButtons[2]);
        panel1.add(numberButtons[3]);
        panel1.add(subButton);

        panel1.add(numberButtons[0]);
        panel1.add(decButton);
        panel1.add(equButton);
        panel1.add(addButton);

        this.add(panel1);
        this.add(textfield);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) {
            String string = textfield.getText();
            if(!string.contains(".")) {
                textfield.setText(textfield.getText().concat("."));
            }
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton) {
            textfield.setText("");
        }
        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < string.length() - 1; i ++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton) {
            double temporary = Double.parseDouble(textfield.getText());
            temporary *= -1;
            textfield.setText(String.valueOf(temporary));
        }
        if(e.getSource() == perButton) {
            double temporary = Double.parseDouble(textfield.getText());
            temporary /= 100;
            textfield.setText(String.valueOf(temporary));
        }
    }
}
