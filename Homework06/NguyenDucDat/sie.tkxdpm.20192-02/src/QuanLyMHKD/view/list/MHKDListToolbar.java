package QuanLyMHKD.view.list;

import QuanLyMHKD.model.MHKD;
import QuanLyMHKD.view.MHKDListGUI;
import main.view.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MHKDListToolbar implements IView {
    private final MHKDListGUI parent;

    public MHKDListToolbar(MHKDListGUI parent) {
        this.parent = parent;
    }

    public Container draw() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        addButton(toolbar, "Create", e -> parent.getController().moveToNewController());
        addButton(toolbar, "Edit", e -> parent.getController().editController(parent.getTable().getSelectedId()));
        addButton(toolbar, "Delete", e -> deleteEntity(parent.getTable().getSelectedId()));

        return toolbar;
    }

    private void addButton(JToolBar toolbar, String label, ActionListener action) {
        JButton button = new JButton(label);
        button.addActionListener(action);
        toolbar.add(button);
        toolbar.addSeparator();
    }

    private void deleteEntity(int id) {
        int cfBtn = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Confirm to delete this record?", "Confirm delete", cfBtn);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            MHKD model = new MHKD();
            if (model.delete(id)) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
