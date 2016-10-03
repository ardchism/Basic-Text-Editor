/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:49:03 PM
 */

package adam.s_code_editor;

import javax.swing.*;


public class TopMenu extends JMenuBar {

        
    public TopMenu(AppFrame myAppFrame){
        // Create the file menu.
        FileMenu fileMenu = new FileMenu("File", myAppFrame);

        // Create Style menu and controller
        StyleMenuController myStyleController = new StyleMenuController(myAppFrame.getModel(), myAppFrame); 
        StyleMenuView styleMenu = new StyleMenuView("Style", myStyleController);

        // Create Help Menu
        HelpMenu helpMenu = new HelpMenu("Help",
                                        myAppFrame);

        // Add menus to main menu
        super.add(fileMenu);
        super.add(styleMenu);
        super.add(helpMenu);

    } 
}
