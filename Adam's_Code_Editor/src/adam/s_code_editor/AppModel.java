/**
 *
 * Created by: Adam Chisholm
 * Created on: Oct 2, 2016, 10:13:32 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;



public class AppModel {

    private Font currentFont;
    private final Color myColors[];
    private Color currentBackColor;
    private Color currentTextColor;
    private Color currentCaratColor;
    
    public AppModel(){
        
        
        this.currentBackColor = null;
        this.currentTextColor = null;
        this.currentFont = null;
        this.currentCaratColor = Color.BLACK;
        
        // Constant color table
        this.myColors = new Color[3];
        this.myColors[0] = Color.BLACK;
        this.myColors[1] = Color.WHITE;
        this.myColors[2] = Color.GREEN;
           
    }
    
    public Font getCurrentFont(){
        return currentFont;
    }
    
    public void setCurrentFont(Font newFont){
        this.currentFont = newFont;
    }
    
    public Color getBackgroundColor(){
        return this.currentBackColor;
    }
    public void setBackgroundColor(Color newColor){
        this.currentBackColor = newColor;
    }
    public Color getForegroundColor(){
        return this.currentTextColor;
    }
    public void setForegroundColor(Color newColor){
        this.currentTextColor = newColor;
    }
    
    public Color getCaratColor(){
        return this.currentCaratColor;
    }
    
    public void setCaratColor(Color newColor){
        this.currentCaratColor = newColor;
    }
    
}
