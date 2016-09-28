/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:49:03 PM
 */

package adam.s_code_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.SwingConstants.CENTER;


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
            super.add(fileMenu);

            // Create the options menu.
            JMenu optionsMenu = new JMenu("Options");

            // Create color sub menu
            JMenu colorMenu = new JMenu("Color");
            JMenuItem jmiRed = new JMenuItem("Red");
            JMenuItem jmiGreen = new JMenuItem("Green");
            JMenuItem jmiBlue = new JMenuItem("Blue");
            colorMenu.add(jmiRed);
            colorMenu.add(jmiGreen);
            colorMenu.add(jmiBlue);
            optionsMenu.add(colorMenu);

            // Create the priorty sub menu.
            JMenu priortyMenu = new JMenu("Priority");
            JMenuItem jmiHigh = new JMenuItem("High");
            JMenuItem jmiLow = new JMenuItem("Low");
            priortyMenu.add(jmiHigh);
            priortyMenu.add(jmiLow);
            optionsMenu.add(priortyMenu);

            // Create the reset menu
            JMenuItem resetMenu = new JMenuItem("Reset");
            optionsMenu.addSeparator();
            optionsMenu.add(resetMenu);

            // Add options menu to the menu bar.
            super.add(optionsMenu);

            // Create help menu.
            JMenu helpMenu = new JMenu("Help");
            JMenuItem aboutItem = new JMenuItem("About");
            helpMenu.add(aboutItem);
            super.add(helpMenu);
            
            // Add action listeners.
            openOpt.addActionListener(this);
            closeOpt.addActionListener(this);
            saveOpt.addActionListener(this);
            exitOpt.addActionListener(this);
            jmiRed.addActionListener(this);
            jmiGreen.addActionListener(this);
            jmiBlue.addActionListener(this);
            jmiHigh.addActionListener(this);
            jmiLow.addActionListener(this);
            resetMenu.addActionListener(this);
            aboutItem.addActionListener(this);

        }
        
    @Override
    public void actionPerformed(ActionEvent ae){
        // Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
        
        // If tuser chooses Exit, then exit the program.
        if(comStr.equals("Exit"))
            System.exit(0);
        
        // Otherwise, display the selection.
        AppFrame.jlab.setText(comStr + " Selected");
    }
    

}
