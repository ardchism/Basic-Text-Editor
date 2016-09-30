/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 10:36:51 AM
 */

package adam.s_code_editor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class myFileChooser extends JFileChooser {

    private final JEditorPane mainText;
    private final JLabel jlab;
    private File myFile;
    
    public myFileChooser(JEditorPane mainText, JLabel jlab){
    
        this.mainText = mainText;
        this.jlab = jlab;
        
    }
    
    public void openFile(){
        
        int returnVal = this.showOpenDialog(mainText);
        
        // If user approves menu then open file
        // Else update jlab with user canceled message
        if (returnVal == JFileChooser.APPROVE_OPTION){
            myFile = this.getSelectedFile();
            // Open file.
            FileReader myReader;
        
            // Get filename
            String fname = myFile.getPath();
            
            // Load the file
        try {
            myReader = new FileReader(fname);
            mainText.read(myReader, null);
            myReader.close();
        } catch(IOException exc){
            jlab.setText("Error reading the file");
        }
        }
        else{
            jlab.setText("User Canceled Open");
        }
            
        
    }
    
    public String getFileName(){
        return myFile.getPath();
    }
    
    
}
