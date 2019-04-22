
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        
        JTextField field1 = new JTextField();
        field1.setEnabled(false);
        
        JTextField field2 = new JTextField("0");
        
        JPanel panel = new JPanel(new GridLayout(2, 1));
        
        panel.add(field1);
        panel.add(field2);
        
        container.add(panel, BorderLayout.CENTER);
        container.add(addButtons(field1, field2), BorderLayout.SOUTH);
    }
    
    private JPanel addButtons(JTextField field1, JTextField field2) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton addButton = new JButton("+");
        addButton.addActionListener(new AddActionListener(field1, field2));
        
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new SubtractActionListener(field1, field2));
        
        JButton clearButton = new JButton("Z");
        
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(clearButton);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
