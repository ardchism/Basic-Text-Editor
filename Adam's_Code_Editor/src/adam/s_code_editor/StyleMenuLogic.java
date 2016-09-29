/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 2:02:17 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;


public class StyleMenuLogic {
    
    private ActionEvent myEvent;
    
    // private refs for passing need objects
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber;
    
    public StyleMenuLogic(ActionEvent ae, JLabel jlab, JEditorPane mainText, TextLineNumber lineNumber){
        myEvent = ae;
        
        // Store ref of vars for updating
        this.jlab = jlab;
        this.mainText = mainText;
        this.lineNumber = lineNumber;
    }
    
    public void setEvent(ActionEvent ae){
        myEvent = ae;   
    }
    
    public void runLogic(){
        String comStr = myEvent.getActionCommand();
        
        // Logic for the menu actions. I will prob move these to dif class.
        // Change font size using a custom font class.
        if(comStr.matches(".*\\d+.*")){ // need to improve this logic. It needs to find only numbers.
            // get current font
            Font f = mainText.getFont();
            // create smaller font
            Font newFont = new Font(f.getFontName(), f.getStyle(), Integer.parseInt(comStr));
            // assign font to text area
            mainText.setFont(newFont);
        }
        // Change Backgound Color and font color logic.
        else
            switch (comStr) {
                // Change background color to black
                case "Black Background":
                    mainText.setBackground(Color.BLACK);
                    lineNumber.setBackground(Color.BLACK);
                    break;
                // Change Background color white    
                case "White Background":
                    mainText.setBackground(Color.WHITE);
                    lineNumber.setBackground(Color.WHITE);
                    break;

                // Change Font Color
                // to green  
                case "Green Font":
                    mainText.setForeground(Color.GREEN);
                    lineNumber.setForeground(Color.GREEN);
                    mainText.setCaretColor(Color.WHITE);
                    break;
                case "Black Font":
                    mainText.setForeground(Color.BLACK);
                    lineNumber.setForeground(Color.BLACK);
                    mainText.setCaretColor(Color.BLACK);
                    break;

                // Otherwise, display the selection.
                default:
                    jlab.setText("COMING SOON");
                    break;
            }
    }

}
