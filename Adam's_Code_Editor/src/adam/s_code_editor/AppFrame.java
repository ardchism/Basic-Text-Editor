/**
 *
 * Created by: Adam Chisholm
 * Created on: Sep 27, 2016, 7:18:16 PM
 */

package adam.s_code_editor;

import java.awt.*;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;


public class AppFrame extends JFrame{
    
    private final JLabel jlab;
    private final JEditorPane mainText;
    private final TextLineNumber lineNumber; 
    private final AppModel myModel;
    
    public AppFrame(String name){
        
        super(name);
        
        // Store inst of model
        this.myModel = new AppModel();

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
        lineNumber.setMinimumDisplayDigits(4);
        mainPane.setRowHeaderView(lineNumber);
        
        // Create display label
        jlab = new JLabel("");
        jlab.setHorizontalAlignment(CENTER);
        
        // Call TopMenu
        TopMenu myMenu = new TopMenu(this);
        
        // Add to frame
        super.add(myMenu, BorderLayout.PAGE_START);
        super.add(mainPane, BorderLayout.CENTER);
        super.add(jlab, BorderLayout.PAGE_END);
        super.setVisible(true);
    }
    
    public AppModel getModel(){
        return myModel;
    }
    
    public JLabel getJLab(){
        return jlab;
    }
    
    public JEditorPane getMainText(){
        return mainText;
    }
    
    public TextLineNumber getLineNumber(){
        return lineNumber;
    }
    
}
