package QuanLyMHKD.view.edit;

import QuanLyMHKD.controller.MHKDEditController;
import QuanLyMHKD.entity.MatHangKinhDoanh;
import main.layout.SpringUtilities;
import main.view.IView;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;

public class MHKDForm implements IView {
    private final MHKDEditController controller;
    private HashMap<String, Component> componentMap = new HashMap<>();
    private MatHangKinhDoanh entity;

    public MHKDForm(MHKDEditController controller, MatHangKinhDoanh entity) {
        this.controller = controller;
        this.entity = entity;
    }

    public Container draw() {
        Container form = new Container();
        form.setLayout(new SpringLayout());

        String[] labels = {"Id:", "Name: ", "Merchandise: ", "Quantity: ", "Unit: "};
        String[] keys = {"id", "name", "merchandise", "qty", "unit"};
        String[] values = entity2Array(this.entity);

        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            form.add(l);
            JTextField textField = new JTextField(10);
            textField.setText(values[i]);
            textField.setEditable(i > 0);
            l.setLabelFor(textField);
            this.addComponentByName(form, textField, keys[i]);
        }

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> this.controller.back());
        form.add(backBtn);

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> this.controller.save(prepareEntity()));
        form.add(saveBtn);

        SpringUtilities.makeCompactGrid(form,
                labels.length + 1, 2,
                6, 6,
                6, 6);
        return form;
    }

    private String[] entity2Array(MatHangKinhDoanh entity) {
        if (entity == null) {
            return new String[5];
        } else {
            String[] arr = new String[5];
            arr[0] = String.valueOf(entity.getId());
            arr[1] = entity.getName();
            arr[2] = entity.getMerchandise();
            arr[3] = String.valueOf(entity.getQty());
            arr[4] = entity.getUnit();

            return arr;
        }
    }

    private MatHangKinhDoanh prepareEntity() {
        String idStr = ((JTextComponent) getComponentByName("id")).getText();
        int id;
        if (idStr.isBlank()) {
            id = 0;
        } else {
            id = Integer.parseInt(idStr);
        }
        MatHangKinhDoanh mhkd = new MatHangKinhDoanh(id);

        String name = ((JTextComponent) getComponentByName("name")).getText();
        String merchandise = ((JTextComponent) getComponentByName("merchandise")).getText();
        float qty = Float.parseFloat(((JTextComponent) getComponentByName("qty")).getText());
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
