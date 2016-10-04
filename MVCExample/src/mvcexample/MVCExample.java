/**
 *
 * @author coldblooded
 */
package mvcexample;

import javax.swing.SwingUtilities;


public class MVCExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model(0);
            View view = new View("-");
            Controller controller = new Controller(model,view);
            controller.control();
        });
    }
    
}
