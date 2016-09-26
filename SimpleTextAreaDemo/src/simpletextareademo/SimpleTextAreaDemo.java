/**
 *
 * @author coldblooded
 */
package simpletextareademo;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SimpleTextAreaDemo {

    // global vars. Must be placed here if placed in action listoner
    JLabel wordCountLabel;
    JTextArea mainTextArea;
    
    // Constructor is used to create and display jframe
    public SimpleTextAreaDemo(){
    
        // Create a new JFrame container.
        JFrame mainFrame = new JFrame("A simple JTextArea");
        
        // Specify FlowLayout for the layout manager.
        mainFrame.getContentPane().setLayout(new FlowLayout());
        
        // Give the frame an initial size.
        mainFrame.setSize(240, 150);
        
        // Terminate app on user press of close
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create word count label
        wordCountLabel = new JLabel("Current word count is 0");
        
        // Create the text field
        mainTextArea = new JTextArea();
        
        // Set line wrap on word boundaries
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        
        // Put the text area into a scroll pane.
        JScrollPane myScrollPane = new JScrollPane(mainTextArea);
        myScrollPane.setPreferredSize(new Dimension(100, 75));
        
        // Add a caret listener. This handler displays word count in real time.
        mainTextArea.addCaretListener((CaretEvent ce) -> {
            int wordCount;
            
            // Get current text.
            String currentText = mainTextArea.getText();
            
            // if wc is zero initiate wordCount
            if(currentText.length() == 0){
                wordCount = 0;
            }
            else{
                // Split the string into words by whitespace or punct
                String [] wordArray = currentText.split("\\W+");
                
                // The word count is equal to the number of words in wordArray
                wordCount = wordArray.length;
                
                // Handle the case of a leading nonword charcater.
                if(wordArray.length > 0 && wordArray[0].length() == 0)
                    wordCount--;
            }
            
            // Display the word count
            wordCountLabel.setText("Current word count is " + wordCount);
        });
    
        // Add the component to the content pane.
        mainFrame.getContentPane().add(myScrollPane);
        mainFrame.add(wordCountLabel);
        
        // Display the frame
        mainFrame.setVisible(true);        
    }
    
    public static void main(String[] args) {
        
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(() -> {
            SimpleTextAreaDemo simpleTextAreaDemo = new SimpleTextAreaDemo();
        });
        
    }
    
}
