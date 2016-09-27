/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 26, 2016, 7:11:25 PM
 */

package simpletexteditexample;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SimpleTextEditor {
    
    JLabel jlabMsg;
    
    JTextArea mainTextArea;
    
    JTextField fileNameField;
    JTextField findStringField;
    
    JButton saveButton;
    JButton loadButton;
    JButton findButton;
    JButton NextButton;
    
    int findIdx;
    
    public SimpleTextEditor(){
    
        // Create new jframe container
        JFrame mainFrame = new JFrame("AN Example Text Editor");
        
        // Specify Layout
        mainFrame.setLayout(new FlowLayout());
        
        // Set initial size
        mainFrame.setSize(270, 420);
        
        // Close program on user exit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the message label
        jlabMsg = new JLabel();
        jlabMsg.setPreferredSize(new Dimension(200, 20));
        jlabMsg.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Create empty label to add spacing
        JLabel separatorLabel = new JLabel();
        separatorLabel.setPreferredSize(new Dimension(200, 30));
        
        // Create search and filename labels
        JLabel findLabel = new JLabel("Search For:");
        findLabel.setPreferredSize(new Dimension(70, 20));
        findLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JLabel fileLabel = new JLabel("Filename:");
        fileLabel.setPreferredSize(new Dimension(70, 20));
        fileLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Create the textfield
        mainTextArea = new JTextArea();
        
        // Put text area in a scroll pane
        JScrollPane scrollPane = new JScrollPane(mainTextArea);
        scrollPane.setPreferredSize(new Dimension(250, 200));
        
        // Create file name text field
        fileNameField = new JTextField(15);
        
        // Add a caret listener for the text area
        mainTextArea.addCaretListener((CaretEvent ce) -> {
            String str = mainTextArea.getText();
            jlabMsg.setText("Current size: " + str.length());
            findIdx = mainTextArea.getCaretPosition();
        });
        
        // Create the bbuttons
        saveButton = new JButton("Save File");
        loadButton = new JButton("Load File");
        
        // Add action listener for save button.
        saveButton.addActionListener((ActionEvent le) -> {
            save();
        });
        
        // Add action listener for save button.
        loadButton.addActionListener((ActionEvent le) -> {
            load();
        });
                
        // Create the search for text field.
        findStringField = new JTextField(15);
        
        // Create the find from top and find next buttonsd
        findButton = new JButton("Find From Top");
        NextButton = new JButton("Find Next");
        
        // Add action listener for the Find from top button
        findButton.addActionListener((ActionEvent ae) -> {
            findIdx = 0;
            find(findIdx); 
        });
        
        // Add action listener for the Find next button
        NextButton.addActionListener((ActionEvent ae) -> {
            find(findIdx+1); 
        });
        
        // Add components to the content pane
        Container cp = mainFrame.getContentPane();
        cp.add(scrollPane);
        cp.add(findLabel);
        cp.add(findStringField);
        cp.add(findButton);
        cp.add(NextButton);
        cp.add(separatorLabel);
        cp.add(fileLabel);
        cp.add(fileNameField);
        cp.add(saveButton);
        cp.add(loadButton);
        cp.add(jlabMsg);
        
        mainFrame.setVisible(true); 
    }
    
    // Save the fil;e method
    void save(){
    
        FileWriter fw;
        
        // Get the filename
        String fname = fileNameField.getText();
        
        // Make sure file name not null
        if(fname.length() == 0){
            jlabMsg.setText("Not a valid File Name");
            return;
        }
        
        // Save file
        try {
            fw = new FileWriter(fname);
            mainTextArea.write(fw);
            fw.close();
        } catch(IOException exc){
            jlabMsg.setText("Error opening or writing file");
            return;
        }
        
        jlabMsg.setText("File written successfully");        
    }
    
    // Load a file
    void load(){
        FileReader fw;
        
        // Get filename
        String fname = fileNameField.getText();
        
        // Make sure file name is not null
        if(fname.length() == 0){
            jlabMsg.setText("Not a valid file name");
            return;
        }
        
        // Load the file
        try {
            fw = new FileReader(fname);
            mainTextArea.read(fw, null);
            fw.close();
        } catch(IOException exc){
            jlabMsg.setText("Error reading the file");
            return;
        }
        
        // reset find index when a new file is loaded
        findIdx = 0;
        
        jlabMsg.setText("File loaded successfully");
    }
    
    // Search the file
    void find(int start){
        // Get current text as a string
        String currText = mainTextArea.getText();
        
        // Get the string to find
        String searchString = findStringField.getText();
        
        // Find first from start
        int idx = currText.indexOf(searchString, start);
        
        // See if a match
        if(idx > -1){
            // if found move carot to area and set focus
            mainTextArea.setCaretPosition(idx);
            findIdx = idx;
            jlabMsg.setText("String found.");
        }
        else
            jlabMsg.setText("String not found");
        
        // Set the focus to the editor window
        mainTextArea.requestFocusInWindow();
        
    }
    
}
    
    
    
