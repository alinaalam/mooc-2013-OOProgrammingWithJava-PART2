
import java.awt.event.ActionListener;
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
public abstract class ButtonActionListener implements ActionListener{
    
    protected JTextField outputField;
    protected JTextField inputField;

    public ButtonActionListener(JTextField outputField, JTextField inputField) {
        this.outputField = outputField;
        this.inputField = inputField;
    }
    
    protected void wipeInputField() {
        inputField.setText("");
    }
    
    protected int getOutputFieldValue() throws NumberFormatException {
        return (outputField.getText().isEmpty()) ? 0 : getIntegerValue(outputField.getText());
    }
    
    protected int getInputFieldValue() throws NumberFormatException {
        return getIntegerValue(inputField.getText());
    }
    
    protected int getIntegerValue(String value) throws NumberFormatException {
        return Integer.valueOf(value);
    }
}
