/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 10:36:51 AM
 */

package adam.s_code_editor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;



public class FileHandelerLogic {

    private final AppFrame myAppFrame;
    private final FileMenu myFileMenu; 
    private File myFile;
    
    public FileHandelerLogic(FileMenu myFileMenu, AppFrame myAppFrame){
    
        this.myAppFrame = myAppFrame;
        this.myFileMenu = myFileMenu;
        
    }
    
    public void openFile(){
        
        int returnVal = myFileMenu.getFileChooser().showOpenDialog(myAppFrame.getMainText());
        
        // If user approves menu then open file
        // Else update jlab with user canceled message
        if (returnVal == JFileChooser.APPROVE_OPTION){
            myFile = myFileMenu.getFileChooser().getSelectedFile();
            // Open file.
            FileReader myReader;
        
            // Get filename
            String fname = myFile.getPath();
            
            // Load the file
            try {
                myReader = new FileReader(fname);
                myAppFrame.getMainText().read(myReader, null);
                myReader.close();
            } 
            catch(IOException exc){
                myAppFrame.getJLab().setText("Error reading the file");
            }
            
        }
        else{
            myAppFrame.getJLab().setText("User Canceled Open");
        }  
    }
    
    public void saveFile(){
        
        int returnVal = myFileMenu.getFileChooser().showSaveDialog(myAppFrame.getMainText());
        
        // If user approves menu then open file
        // Else update jlab with user canceled message
        if (returnVal == JFileChooser.APPROVE_OPTION){
            myFile = myFileMenu.getFileChooser().getSelectedFile();
            // Open file writer.
            FileWriter myWriter;
        
            // Get filename
            String fname = myFile.getPath();
            
            // Save file
            try {
                myWriter = new FileWriter(fname);
                myAppFrame.getMainText().write(myWriter);
                myWriter.close();
            } catch(IOException exc){
                myAppFrame.getJLab().setText("Error opening or writing file");
            }
            
        }
        else{
            myAppFrame.getJLab().setText("User Canceled Save");
        }
        
    }
    
    public String getFileName(){
        return myFile.getPath();
    }
    
    
}
