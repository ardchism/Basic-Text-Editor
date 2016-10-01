/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 2:02:17 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class StyleMenuLogic {
    
    private ActionEvent myEvent;
    private final AppFrame myAppFrame;
    
    public StyleMenuLogic(ActionEvent ae, AppFrame myAppFrame){
        myEvent = ae;
        this.myAppFrame = myAppFrame;
    }
    
    public void setEvent(ActionEvent ae){
        myEvent = ae;   
    }
    
    public void runLogic(){
        String comStr = myEvent.getActionCommand();
        
        // Logic for the menu actions.
        // Change font size using a custom font class.
        if(comStr.matches(".*\\d+.*")){ // need to improve this logic. It needs to find only numbers.
            // get current font
            Font f = myAppFrame.getMainText().getFont();
            // create smaller font
            Font newFont = new Font(f.getFontName(), f.getStyle(), Integer.parseInt(comStr));
            // assign font to text area
            myAppFrame.getMainText().setFont(newFont);
            myAppFrame.getLineNumber().setFont(newFont);
        }
        
        // Change Backgound Color and font color logic.
        else
            switch (comStr) {
                // Change background color to black
                case "Black Background":
                    myAppFrame.getMainText().setBackground(Color.BLACK);
                    myAppFrame.getLineNumber().setBackground(Color.BLACK);
                    break;
                // Change Background color white    
                case "White Background":
                    myAppFrame.getMainText().setBackground(Color.WHITE);
                    myAppFrame.getLineNumber().setBackground(Color.WHITE);
                    break;

                // Change Font Color
                // to green  
                case "Green Font":
                    myAppFrame.getMainText().setForeground(Color.GREEN);
                    myAppFrame.getLineNumber().setForeground(Color.GREEN);
                    myAppFrame.getMainText().setCaretColor(Color.WHITE);
                    break;
                case "Black Font":
                    myAppFrame.getMainText().setForeground(Color.BLACK);
                    myAppFrame.getLineNumber().setForeground(Color.BLACK);
                    myAppFrame.getMainText().setCaretColor(Color.BLACK);
                    break;

                // Otherwise, display the selection.
                default:
                    myAppFrame.getJLab().setText("COMING SOON");
                    break;
            }
    }

}
