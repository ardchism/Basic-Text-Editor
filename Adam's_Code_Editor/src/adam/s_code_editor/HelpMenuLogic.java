/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 9:39:46 AM
 */

package adam.s_code_editor;

import java.awt.event.ActionEvent;
import javax.swing.*;


public class HelpMenuLogic {
    
    private ActionEvent myEvent;
    
    // private refs for passing need objects
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber;
    
    public HelpMenuLogic(ActionEvent ae, JLabel jlab, JEditorPane mainText, TextLineNumber lineNumber){
        myEvent = ae;
        
        // Store ref of vars for updating
        this.jlab = jlab;
        this.mainText = mainText;
        this.lineNumber = lineNumber;
    }
    
    public void runLogic(){
        // Get the action command from the menu selection.
        String comStr = myEvent.getActionCommand();
        
        switch (comStr) {
            case "About":
               jlab.setText(comStr);
               break;      
        }
    }

}
