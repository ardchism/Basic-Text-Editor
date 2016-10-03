/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 30, 2016, 9:29:19 AM
 */

package adam.s_code_editor;

import java.awt.event.*;



public class FileMenuLogic {

    private final ActionEvent myEvent;
    
    // private refs for passing need objects
    private final AppFrame myAppFrame;
    private final FileMenu myFileMenu;
    private final FileHandelerLogic myFileLogic;
    
    private String currentText = "", fileName;
    
    
    public FileMenuLogic(ActionEvent ae, FileMenu myFileMenu, AppFrame myAppFrame){
        myEvent = ae;
        
        // Store ref of vars for updating
        this.myAppFrame = myAppFrame;
        this.myFileMenu = myFileMenu;
        
        // Store opening Text
        fileName = myFileMenu.getFileName();
        
        // Create fileLogic object
        myFileLogic = new FileHandelerLogic(myFileMenu, myAppFrame);
        
        
    }
    
    public void runLogic(){
        
        fileName = myFileMenu.getFileName();
        // Get the action command from the menu selection.
        String comStr = myEvent.getActionCommand();
        
        switch (comStr) {
            case "Open":              
                myFileLogic.openFile();
                fileName = myFileLogic.getFileName();
                myAppFrame.getJLab().setText(fileName);
                myFileMenu.setOriginalText(myAppFrame.getMainText().getText());
                break;
                
            case "Close":               
                this.saveAnyChanges();
                myAppFrame.getMainText().setText("");
                fileName = "New File";
                myAppFrame.getJLab().setText("New File");
                break;
                
            case "Save":
                myFileLogic.saveFile();
                fileName = myFileLogic.getFileName();
                myAppFrame.getJLab().setText("Saved: " + fileName);
                myFileMenu.setOriginalText(myAppFrame.getMainText().getText());
                break;
                
            case "Exit":
                this.saveAnyChanges();
                System.exit(0);
                
        }
        
        myFileMenu.setFileName(fileName);
        
    }
    
    private void saveAnyChanges(){
        currentText = myAppFrame.getMainText().getText();
        if(!myFileMenu.getOriginalText().equals(currentText)){
            myAppFrame.getJLab().setText("Changes have been made to: " + fileName);
            myFileMenu.getDialogMessage().setVisible(true);
            Object userChoice = myFileMenu.getOptionPane().getValue();
            if(userChoice.toString().equals("0")){
                myFileLogic.saveFile();
                fileName = myFileLogic.getFileName();
                myAppFrame.getJLab().setText("Saved: " + fileName);
            }
        }
    }
    
    
}
