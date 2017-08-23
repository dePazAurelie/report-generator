package reportgenerator.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame{
    JLabel background=new JLabel(new ImageIcon(getClass().getResource("reportgenerator/window/Ressources/space.gif")));


    public Window(JLabel background) throws HeadlessException {
        this.background = background;

        setTitle("REPORT GENERATOR");
        setSize(768, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        add(background);
        background.setLayout(new FlowLayout());


        setVisible(true);
    }
}
