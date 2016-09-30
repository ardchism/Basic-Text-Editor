/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 9:29:19 AM
 */

package adam.s_code_editor;

import java.awt.event.*;
import javax.swing.*;


public class FileMenuLogic {

    private final ActionEvent myEvent;
    
    // private refs for passing need objects
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber;
    private myFileChooser myfc;
    
    public FileMenuLogic(ActionEvent ae,
                         JLabel jlab,
                         JEditorPane mainText,
                         TextLineNumber lineNumber){
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
            case "Open":
                
                myfc = new myFileChooser(mainText, jlab);
                myfc.openFile();
                jlab.setText(myfc.getFileName());
                break;
                
            case "Close":
                
                
                
            case "Save":
                jlab.setText(comStr);
                break;
            case "Exit":
                System.exit(0);
                
        }
        
    }
    
}
