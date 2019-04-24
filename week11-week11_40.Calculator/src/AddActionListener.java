
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class AddActionListener extends ButtonActionListener {
    
    public AddActionListener(JTextField outputField, JTextField inputField) {
        super(outputField, inputField);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int outputFieldValue = getOutputFieldValue();
            int sum = outputFieldValue + getInputFieldValue();
            outputField.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
            // do nothing
        } finally {
            wipeInputField();
        }
    }
}
