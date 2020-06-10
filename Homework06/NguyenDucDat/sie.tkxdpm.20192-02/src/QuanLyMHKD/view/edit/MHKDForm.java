package QuanLyMHKD.view.edit;

import QuanLyMHKD.controller.MHKDEditController;
import QuanLyMHKD.entity.MatHangKinhDoanh;
import core.layout.SpringUtilities;
import main.IView;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;

public class MHKDForm implements IView {
    private MHKDEditController controller;
    private HashMap<String, Component> componentMap = new HashMap<String, Component>();

    public MHKDForm(MHKDEditController controller) {
        this.controller = controller;
    }

    public Container draw() {
        Container form = new Container();
        form.setLayout(new SpringLayout());

        String[] labels = {"Ten: ", "Merchandise: ", "Quantity: ", "Unit: "};
        String[] keys = {"name", "merchandise", "qty: ", "unit"};
        int numPairs = labels.length;

        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            form.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            this.addComponentByName(form, textField, keys[i]);
        }

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> this.controller.save());

        SpringUtilities.makeCompactGrid(form,
                numPairs, 2,
                6, 6,
                6, 6);
        return form;
    }

    private MatHangKinhDoanh prepareEntity(Container form) {
        MatHangKinhDoanh mhkd = new MatHangKinhDoanh();

        String name = ((JTextComponent) getComponentByName("name")).getText();
        String merchandise = ((JTextComponent) getComponentByName("merchandise")).getText();
        float qty = Float.parseFloat(((JTextComponent) getComponentByName("name")).getText());
        String unit = ((JTextComponent) getComponentByName("unit")).getText();

        mhkd.setName(name).setMerchandise(merchandise).setQty(qty).setUnit(unit);

        return mhkd;
    }

    private Component getComponentByName(String name) {
        return componentMap.getOrDefault(name, null);
    }

    private void addComponentByName(Container parent, Component child, String name) {
        parent.add(child);
        componentMap.put(name, child);
    }
}
