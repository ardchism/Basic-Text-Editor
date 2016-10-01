/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 1:11:40 PM
 */

package adam.s_code_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FileMenu extends JMenu implements ActionListener{
    
    // Parent frame for getting parent objects 
    private final AppFrame myAppFrame;
    
    // private objects
    private String fileName = "New File";
    private String originalText = "";
    private final JFileChooser myfc;
    private final JOptionPane mySaveMenu;
    private final JDialog myDialog;
    
    // Constructor that is used to create intitial instance of this menu
    public FileMenu(String name, AppFrame myAppFrame){
        
        super(name); // Calls parent constructor to set text
        
        // Store ref of vars for updating
        this.myAppFrame = myAppFrame;
        
        // Create file options
        JMenuItem openOpt = new JMenuItem("Open");
        JMenuItem closeOpt = new JMenuItem("Close");
        JMenuItem saveOpt = new JMenuItem("Save");
        JMenuItem exitOpt = new JMenuItem("Exit");
        
        // Create menu options for logic use
        myfc = new JFileChooser();
        mySaveMenu = new JOptionPane("Save Changes", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
        myDialog = mySaveMenu.createDialog(myAppFrame, "Save Changes");
        
        // Add action listeners.
        openOpt.addActionListener(this);
        closeOpt.addActionListener(this);
        saveOpt.addActionListener(this);
        exitOpt.addActionListener(this);
        
        // Add to the new menu object
        super.add(openOpt);
        super.add(closeOpt);
        super.add(saveOpt);
        super.addSeparator();
        super.add(exitOpt);
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public void setFileName(String newName){
        fileName= newName;
    }
    
    public String getOriginalText(){
        return originalText;
    }
    
    public void setOriginalText(String newText){
        originalText = newText;
    }
    
    public JFileChooser getFileChooser(){
        return myfc;
    }
    
    public JOptionPane getOptionPane(){
        return mySaveMenu;
    }
    
    public JDialog getDialogMessage(){
        return myDialog;
    }
    
    public AppFrame getAppFrame(){
        return myAppFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        FileMenuLogic myLogic = new FileMenuLogic(ae, this, myAppFrame);
        // store file name and body of text for future use.
        myLogic.runLogic();
    }
    
}
