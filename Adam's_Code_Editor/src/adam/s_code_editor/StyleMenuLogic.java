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
    
    public StyleMenuLogic(ActionEvent ae){
        myEvent = ae;
    
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
            Font f = AppFrame.mainText.getFont();
            // create smaller font
            Font newFont = new Font(f.getFontName(), f.getStyle(), Integer.parseInt(comStr));
            // assign font to text area
            AppFrame.mainText.setFont(newFont);
        }
        // Change Backgound Color and font color logic.
        else
            switch (comStr) {
                // Change background color to black
                case "Black Background":
                    AppFrame.mainText.setBackground(Color.BLACK);
                    break;
                // Change Background color white    
                case "White Background":
                    AppFrame.mainText.setBackground(Color.WHITE);
                    break;

                // Change Font Color
                // to green  
                case "Green Font":
                    AppFrame.mainText.setForeground(Color.GREEN);
                    AppFrame.mainText.setCaretColor(Color.WHITE);
                    break;
                case "Black Font":
                    AppFrame.mainText.setForeground(Color.BLACK);
                    break;

                // Otherwise, display the selection.
                default:
                    AppFrame.jlab.setText("COMING SOON");
                    break;
            }
    }

}
