/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 29, 2016, 1:40:42 PM
 */

package adam.s_code_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class StyleMenu extends JMenu implements ActionListener{
    
    // private refs for passing need objects
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber;
    
    // Constructor that will be used to create the instance of this menu
    public StyleMenu(String name, JLabel jlab, JEditorPane mainText, TextLineNumber lineNumber){
    
        // Call super inorder to set text
        super(name);
        
        // Store ref of vars for updating
        this.jlab = jlab;
        this.mainText = mainText;
        this.lineNumber = lineNumber;
        
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
            fontSizeList[count].addActionListener(this);
        }
        super.add(textSizeMenu);
        
        // Create theme menu.
        JMenu themeMenu = new JMenu("Theme");
        JMenuItem themOne = new JMenuItem("Theme One");
        themeMenu.add(themOne);
        super.add(themeMenu);

        
        // Add action Listeners
        blackBack.addActionListener(this);
        whiteBack.addActionListener(this);
        greenFont.addActionListener(this);
        blackFont.addActionListener(this);
        themOne.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        StyleMenuLogic myLogic = new StyleMenuLogic(ae, jlab, mainText, lineNumber);
        myLogic.runLogic();
        
    }
    
}
