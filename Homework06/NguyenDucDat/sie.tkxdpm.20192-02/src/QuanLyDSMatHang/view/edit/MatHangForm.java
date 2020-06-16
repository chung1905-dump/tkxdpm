package QuanLyDSMatHang.view.edit;

import QuanLyDSMatHang.controller.MatHangEditController;
import QuanLyDSMatHang.entity.MatHang;
import main.layout.SpringUtilities;
import main.view.IView;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;

public class MatHangForm implements IView {
    private final MatHangEditController controller;
    private final HashMap<String, Component> componentMap = new HashMap<>();
    private final MatHang entity;

    public MatHangForm(MatHangEditController controller, MatHang entity) {
        this.controller = controller;
        this.entity = entity;
    }

    public Container draw() {
        Container form = new Container();
        form.setLayout(new SpringLayout());

        String[] labels = {"Id:", "Name: "};
        String[] keys = {"id", "ten"};
        String[] values = entity2Array(this.entity);

        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            form.add(l);
            JTextField textField = new JTextField(10);
            textField.setText(values[i]);
//            textField.setEditable(i > 0);
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

    private String[] entity2Array(MatHang entity) {
        if (entity == null) {
            return new String[2];
        } else {
            String[] arr = new String[2];
            arr[0] = entity.getId();
            arr[1] = entity.getTen();

            return arr;
        }
    }

    private MatHang prepareEntity() {
        String idStr = ((JTextComponent) getComponentByName("id")).getText();
        String id;
        if (idStr.isEmpty()) {
            id = "";
        } else {
            id = idStr;
        }
        String name = ((JTextComponent) getComponentByName("ten")).getText();
        return new MatHang(id, name);
    }

    private Component getComponentByName(String name) {
        return componentMap.getOrDefault(name, null);
    }

    private void addComponentByName(Container parent, Component child, String name) {
        parent.add(child);
        componentMap.put(name, child);
    }
}
