package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel label = new JLabel(String.valueOf(calculator.giveValue()));
        container.add(label);
        
        JButton button = new JButton("Click!");
        container.add(button, BorderLayout.SOUTH);
        
        ClickListener clickListener = new ClickListener(calculator, label);
        button.addActionListener(clickListener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
