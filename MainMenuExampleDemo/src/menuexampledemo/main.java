package menuexampledemo;

import javax.swing.SwingUtilities;

/**
 *
 * @author coldblooded
 */
public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
        });
    }
    
}
