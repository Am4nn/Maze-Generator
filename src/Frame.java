import javax.swing.*;

public class Frame extends JFrame {
    Frame() {
        this.add(new Panel( 80, 45));
        this.setTitle("Maze_MyVersion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}