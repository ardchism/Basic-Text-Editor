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
            JMenu fileMenu = new JMenu("File");
            JMenuItem openOpt = new JMenuItem("Open");
            JMenuItem closeOpt = new JMenuItem("Close");
            JMenuItem saveOpt = new JMenuItem("Save");
            JMenuItem exitOpt = new JMenuItem("Exit");
            fileMenu.add(openOpt);
            fileMenu.add(closeOpt);
            fileMenu.add(saveOpt);
            fileMenu.addSeparator();
            fileMenu.add(exitOpt);

            // Create Style menu
            JMenu styleMenu = new JMenu("Style");
            
            // Create background color menu
            JMenu backgroundMenu = new JMenu("Background Color");
            JMenuItem blackBack = new JMenuItem("Black Background");
            JMenuItem whiteBack = new JMenuItem("White Background");
            backgroundMenu.add(blackBack);
            backgroundMenu.add(whiteBack);
            styleMenu.add(backgroundMenu);
            
            // Create Text Color Menu.
            JMenu textColorMenu = new JMenu("Text Color");
            JMenuItem greenFont = new JMenuItem("Green Font");
            JMenuItem blackFont = new JMenuItem("Black Font");
            textColorMenu.add(greenFont);
            textColorMenu.add(blackFont);
            styleMenu.add(textColorMenu);
            
            // Create Font Size menu.
            JMenu textSizeMenu = new JMenu("Text Size");
            JMenuItem fontSizeList[] = new JMenuItem[26];
            for(int count = 0, font = 2; count < 25; count++, font += 2){
                fontSizeList[count] = new JMenuItem( Integer.toString(font) );
                textSizeMenu.add(fontSizeList[count]);
                fontSizeList[count].addActionListener(this);
            }
            styleMenu.add(textSizeMenu);

            
            // Create theme menu.
            JMenu themeMenu = new JMenu("Theme");
            JMenuItem themOne = new JMenuItem("Theme 1");
            themeMenu.add(themOne);
            styleMenu.add(themeMenu);

            // Create help menu.
            JMenu helpMenu = new JMenu("Help");
            JMenuItem aboutItem = new JMenuItem("About");
            helpMenu.add(aboutItem);
            
            // Add menus to main menu
            super.add(fileMenu);
            super.add(styleMenu);
            super.add(helpMenu);
            
            // Add action listeners.
            openOpt.addActionListener(this);
            closeOpt.addActionListener(this);
            saveOpt.addActionListener(this);
            exitOpt.addActionListener(this);
            blackBack.addActionListener(this);
            whiteBack.addActionListener(this);
            greenFont.addActionListener(this);
            blackFont.addActionListener(this);
            themOne.addActionListener(this);
            aboutItem.addActionListener(this);

        }
        
    @Override
    public void actionPerformed(ActionEvent ae){
        // Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
        
            // Logic for the menu actions. I will prob move these to dif class.
            // Change font size using a custom font class.
            if(comStr.matches(".*\\d+.*")){
                // get current font
                Font f = AppFrame.mainText.getFont();
                // create smaller font
                Font newFont = new Font(f.getFontName(), f.getStyle(), Integer.parseInt(comStr));
                // assign font to text area
                AppFrame.mainText.setFont(newFont);
            }
            // Change Backgound Color.
            // Change background color to black
            else
                switch (comStr) {
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
