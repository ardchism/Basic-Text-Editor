/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 9:29:19 AM
 */

package adam.s_code_editor;

import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;


public class FileMenuLogic {

    private final ActionEvent myEvent;
    
    // private refs for passing need objects
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber;
    private String originalText, currentText;
    private final myFileChooser myfc;
    
    public FileMenuLogic(ActionEvent ae,
                         JLabel jlab,
                         JEditorPane mainText,
                         TextLineNumber lineNumber,
                         String fileText){
        myEvent = ae;
        
        // Store ref of vars for updating
        this.jlab = jlab;
        this.mainText = mainText;
        this.lineNumber = lineNumber;
        
        // Store opening Text
        originalText = fileText;
        
        // Create FileChooser
        myfc = new myFileChooser(mainText, jlab);
    }
    
    public String runLogic(String fileName){
    
        // Get the action command from the menu selection.
        String comStr = myEvent.getActionCommand();
        
        switch (comStr) {
            case "Open":
                
                myfc.openFile();
                fileName = myfc.getFileName();
                jlab.setText(fileName);
                originalText = mainText.getText();
                break;
                
            case "Close":
                
                currentText = mainText.getText();
                if(!originalText.equals(currentText))
                    jlab.setText("Changes have been made to: " + fileName);
                else{
                    mainText.setText("");
                    jlab.setText("New File");
                }
                break;
                
            case "Save":
  
                myfc.saveFile();
                fileName = myfc.getFileName();
                jlab.setText("Saved: " + fileName);
                originalText = mainText.getText();
                break;
                
            case "Exit":
                System.exit(0);
                
        }
        
        return fileName;
        
    }
    
    
}
