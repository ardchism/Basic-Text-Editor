/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 1:11:40 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FileMenu extends JMenu implements ActionListener{
    
    // Constructor that is used to create an instance of this menu
    public FileMenu(String name){
        super(name); // Calls parent constructor to set text
        
        // Create file options
        JMenuItem openOpt = new JMenuItem("Open");
        JMenuItem closeOpt = new JMenuItem("Close");
        JMenuItem saveOpt = new JMenuItem("Save");
        JMenuItem exitOpt = new JMenuItem("Exit");
        
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
    
    @Override
    public void actionPerformed(ActionEvent ae){
        // Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
        
        switch (comStr) {
            case "Open":
            case "Close":
            case "Save":
            case "Exit":
                AppFrame.jlab.setText(comStr);
        }
        
        
    }
    
}
