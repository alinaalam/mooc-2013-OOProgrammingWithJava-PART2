
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
        container.setLayout(new GridLayout(3, 1));
        
        JTextField outputField = new JTextField("0");
        outputField.setEnabled(false);
        
        JTextField inputField = new JTextField("0");
        
        container.add(outputField);
        container.add(inputField);
        container.add(addButtons(outputField, inputField));
    }
    
    private JPanel addButtons(JTextField outputField, JTextField inputField) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton addButton = new JButton("+");
        addButton.addActionListener(new AddActionListener(outputField, inputField));
        
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new SubtractActionListener(outputField, inputField));
        
        JButton clearButton = new JButton("Z");
        clearButton.addActionListener(new ClearActionListener(outputField, inputField));
        
        addChangeListener(outputField, clearButton);
        
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(clearButton);
        
        return panel;
    }
    
    private void addChangeListener(final JTextField field, final JButton button) {
        button.setEnabled(!field.getText().equals("0"));
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableDisableButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableDisableButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableDisableButton();
            }
            
            private void enableDisableButton() {
                button.setEnabled(!field.getText().equals("0"));
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
