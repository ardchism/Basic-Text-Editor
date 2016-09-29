/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:49:03 PM
 */

package adam.s_code_editor;

import javax.swing.*;


public class TopMenu extends JMenuBar {

        
    public TopMenu(JLabel jlab, JEditorPane mainText, TextLineNumber lineNumber){
        // Create the file menu.
        FileMenu fileMenu = new FileMenu("File", jlab, mainText, lineNumber);

        // Create Style menu
        StyleMenu styleMenu = new StyleMenu("Style", jlab, mainText, lineNumber);

        // Create Help Menu
        HelpMenu helpMenu = new HelpMenu("Help", jlab, mainText, lineNumber);

        // Add menus to main menu
        super.add(fileMenu);
        super.add(styleMenu);
        super.add(helpMenu);

    } 
}
