
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
public class ClearActionListener extends ButtonActionListener {

    public ClearActionListener(JTextField outputField, JTextField inpuField) {
        super(outputField, inpuField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputField.setText("0");
        wipeInputField();
    }
    
}
