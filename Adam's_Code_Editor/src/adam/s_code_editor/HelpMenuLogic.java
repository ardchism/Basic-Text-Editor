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
    private final AppFrame myAppFrame;
    
    public HelpMenuLogic(ActionEvent ae, AppFrame myAppFrame){
        myEvent = ae;
        
        // Store ref of vars for updating
        this.myAppFrame = myAppFrame;
    }
    
    public void runLogic(){
        // Get the action command from the menu selection.
        String comStr = myEvent.getActionCommand();
        
        switch (comStr) {
            case "About":
               myAppFrame.getJLab().setText(comStr);
               break;      
        }
    }

}
