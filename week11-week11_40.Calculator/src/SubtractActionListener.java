
import java.awt.event.ActionEvent;
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
public class SubtractActionListener implements ActionListener{

    private JTextField field1;
    private JTextField field2;

    public SubtractActionListener(JTextField field1, JTextField field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int field1Value = (field1.getText().isEmpty()) ? 0 : Integer.valueOf(field1.getText());
        
        int diff = field1Value - Integer.valueOf(field2.getText());
        field1.setText(String.valueOf(diff));
    }
    
}
