package QuanLyMHKD.view.edit;

import core.layout.SpringUtilities;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDForm implements IView {

    public Container draw() {
        Container c = new Container();
        c.setLayout(new SpringLayout());

        String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
        int numPairs = labels.length;

        for (String label : labels) {
            JLabel l = new JLabel(label, JLabel.TRAILING);
            c.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            c.add(textField);
        }

        SpringUtilities.makeCompactGrid(c,
                numPairs, 2,
                6, 6,
                6, 6);
        return c;
    }
}
