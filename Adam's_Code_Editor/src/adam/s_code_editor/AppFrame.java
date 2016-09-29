/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:18:16 PM
 */

package adam.s_code_editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;


public class AppFrame extends JFrame implements ActionListener {
    
    private static JLabel jlab;
    private static JEditorPane mainText;
    private static TextLineNumber lineNumber;
    
    public AppFrame(String name){
        
        super(name);

        // Specify Layout
        super.setLayout(new BorderLayout());
        
        // Set initial size
        super.setSize(270, 420);
        
        // Close program on user exit
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create Text Area in scroll pane w/ line number
        mainText = new JEditorPane();
        JScrollPane mainPane = new JScrollPane(mainText);
        lineNumber = new TextLineNumber(mainText);
        mainPane.setRowHeaderView(lineNumber);
        
        // Create display label
        jlab = new JLabel("");
        jlab.setHorizontalAlignment(CENTER);
        
        // Call TopMenu
        TopMenu myMenu = new TopMenu(jlab, mainText, lineNumber);
        
        // Add to frame
        super.add(myMenu, BorderLayout.PAGE_START);
        super.add(mainPane, BorderLayout.CENTER);
        super.add(jlab, BorderLayout.PAGE_END);
        super.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        
    }
}
