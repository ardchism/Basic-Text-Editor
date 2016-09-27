/**
 *
 * @author coldblooded
 */
package menuexampledemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu implements ActionListener {
    
    JLabel jlab;
    
    public MainMenu(){
        // Create a new JFrame container.
        JFrame mainFrame = new JFrame("Main Menu Demo");
    
        // Specify FlowLayout for the layout manager.
        mainFrame.setLayout(new FlowLayout());
        
        // give frame initial size.
        mainFrame.setSize(220, 200);
        
        // Close prog on user exit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a label to display the menu selecction.
        jlab = new JLabel();
        
        // Create Menu bar.
        JMenuBar topMenu = new JMenuBar();
        
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
        topMenu.add(fileMenu);
        
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
        topMenu.add(optionsMenu);
        
        // Create help menu.
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        topMenu.add(helpMenu);
        
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
        
        // Add the label to the content pane.
        mainFrame.add(jlab);
        
        // Add menu bar to frame.
        mainFrame.add(topMenu);
        
        mainFrame.setVisible(true);    
    }
    
    // Handle menu item action events
    @Override
    public void actionPerformed(ActionEvent ae){
        // Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
        
        // If tuser chooses Exit, then exit the program.
        if(comStr.equals("Exit"))
            System.exit(0);
        
        // Otherwise, display the selection.
        jlab.setText(comStr + " Selected");
    }
    
}
