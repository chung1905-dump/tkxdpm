package QuanLyMHKD.view;

import main.IView;

import javax.swing.*;
import java.awt.*;

public class NextGUI implements IView {
    public Container draw() {
        Container container = new Container();

        JTextArea t = new JTextArea("You did it");
        t.setBounds(130, 100, 120, 60);
        t.setEditable(false);

        container.add(t);
        return container;
    }
}
