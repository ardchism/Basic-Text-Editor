/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 4:46:25 PM
 */

package adam.s_code_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class HelpMenu extends JMenu implements ActionListener {
    
    // private refs for passing need objects
    private final AppFrame myAppFrame;
    
    public HelpMenu(String name, AppFrame myAppFrame){
        
        super(name);
        
        // Store ref of vars for updating
        this.myAppFrame = myAppFrame;
        
        // Create help menu.
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        super.add(aboutItem);
        
        // Add action listeners.
        aboutItem.addActionListener(this);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        HelpMenuLogic myLogic = new HelpMenuLogic(ae, myAppFrame);
        myLogic.runLogic();
    } 
    
}
