/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 1:40:42 PM
 */

package adam.s_code_editor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class StyleMenuView extends JMenu{
    
    
    // Constructor that will be used to create the instance of this menu
    public StyleMenuView(String name, StyleMenuController myController){
    
        // Call super inorder to set text
        super(name);
        
        // Create background color menu
        JMenu backgroundMenu = new JMenu("Background Color");
        JMenuItem blackBack = new JMenuItem("Black Background");
        JMenuItem whiteBack = new JMenuItem("White Background");
        backgroundMenu.add(blackBack);
        backgroundMenu.add(whiteBack);
        super.add(backgroundMenu);
            
        // Create Text Color Menu.
        JMenu textColorMenu = new JMenu("Text Color");
        JMenuItem greenFont = new JMenuItem("Green Font");
        JMenuItem blackFont = new JMenuItem("Black Font");
        textColorMenu.add(greenFont);
        textColorMenu.add(blackFont);
        super.add(textColorMenu);
            
        // Create Font Size menu.
        JMenu textSizeMenu = new JMenu("Text Size");
        JMenuItem fontSizeList[] = new JMenuItem[26];
        for(int count = 0, font = 2; count < 25; count++, font += 2){
            fontSizeList[count] = new JMenuItem( Integer.toString(font) );
            textSizeMenu.add(fontSizeList[count]);
            fontSizeList[count].addActionListener(myController);
        }
        super.add(textSizeMenu);
        
        // Create theme menu.
        JMenu themeMenu = new JMenu("Theme");
        JMenuItem themOne = new JMenuItem("Green Screen");
        JMenuItem themTwo = new JMenuItem("Note Pad");
        themeMenu.add(themOne);
        themeMenu.add(themTwo);
        super.add(themeMenu);

        
        // Add action Listeners
        blackBack.addActionListener(myController);
        whiteBack.addActionListener(myController);
        greenFont.addActionListener(myController);
        blackFont.addActionListener(myController);
        themOne.addActionListener(myController);
        themTwo.addActionListener(myController);
        
    }

    
}
