/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 2:02:17 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleMenuController  implements ActionListener {
    
    private final AppFrame myAppFrame;
    private final AppModel myModel;
    
    public StyleMenuController(AppModel myModel, AppFrame myAppFrame){
        this.myAppFrame = myAppFrame;
        this.myModel = myModel;
        
        // assign important current values to the model
        this.myModel.setCurrentFont(myAppFrame.getMainText().getFont());
        this.myModel.setBackgroundColor(myAppFrame.getMainText().getBackground());
        this.myModel.setForegroundColor(myAppFrame.getMainText().getForeground());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String comStr = ae.getActionCommand();
        
        // Logic for the menu actions.
        // Change font size using a custom font class.
        if(comStr.matches(".*\\d+.*")){ // need to improve this logic. It needs to find only numbers.
            // get current font
            Font f = myModel.getCurrentFont();
            // create new font
            Font newFont = new Font(f.getFontName(), f.getStyle(), Integer.parseInt(comStr));
            // assign font to model
            myModel.setCurrentFont(newFont);    
        }
        else {  // Change Backgound Color and font color logic.
            switch (comStr) {
                // Change background color to black
                case "Black Background":
                    myModel.setBackgroundColor(Color.BLACK);
                    break;
                // Change Background color white    
                case "White Background":
                    myModel.setBackgroundColor(Color.WHITE);
                    break;

                // Change Font Color
                // to green  
                case "Green Font":
                    myModel.setForegroundColor(Color.GREEN);
                    myModel.setCaratColor(Color.WHITE);
                    break;
                case "Black Font":
                    myModel.setForegroundColor(Color.BLACK);
                    myModel.setCaratColor(Color.BLACK);                    
                    break;

                // Otherwise, display the selection.
                default:
                    myAppFrame.getJLab().setText("COMING SOON");
                    break;
            }
        }
        
        // update view
        myAppFrame.getMainText().setFont(myModel.getCurrentFont());
        myAppFrame.getLineNumber().setFont(myModel.getCurrentFont());
        myAppFrame.getMainText().setBackground(myModel.getBackgroundColor());
        myAppFrame.getLineNumber().setBackground(myModel.getBackgroundColor());
        myAppFrame.getMainText().setForeground(myModel.getForegroundColor());
        myAppFrame.getLineNumber().setForeground(myModel.getForegroundColor());
        myAppFrame.getMainText().setCaretColor(myModel.getCaratColor());
    }

}
