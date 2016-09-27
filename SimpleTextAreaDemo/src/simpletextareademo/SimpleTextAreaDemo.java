/**
 *
 * @author coldblooded
 */
package simpletextareademo;

import javax.swing.*;

public class SimpleTextAreaDemo {
    
        public static void main(String[] args) {
        
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(() -> {
            SimpleTextApp simpletextapp = new SimpleTextApp();
        });
        
    }
    
}
