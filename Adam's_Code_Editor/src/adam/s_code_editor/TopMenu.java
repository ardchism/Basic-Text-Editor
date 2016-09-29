/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:49:03 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TopMenu extends JMenuBar implements ActionListener{

        
        public TopMenu(){
            // Create the file menu.
            FileMenu fileMenu = new FileMenu("File");
            
            // Create Style menu
            StyleMenu styleMenu = new StyleMenu("Style");
            
            
            // Create help menu.
            JMenu helpMenu = new JMenu("Help");
            JMenuItem aboutItem = new JMenuItem("About");
            helpMenu.add(aboutItem);
            
            // Add menus to main menu
            super.add(fileMenu);
            super.add(styleMenu);
            super.add(helpMenu);
            
            // Add action listeners.
            aboutItem.addActionListener(this);

        }
        
    @Override
    public void actionPerformed(ActionEvent ae){
        // Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
        AppFrame.jlab.setText(comStr);
    }    
}
