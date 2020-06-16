package QuanLyDonHang.view;

import QuanLyDonHang.controller.DonHangController;
import QuanLyDonHang.entity.DonHang;
import main.view.IView;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class DonHangGUI implements IView {
    private JPanel mainPanel;
    private JTable donHangTable;
    private JTextField maDonHang;
    private org.jdesktop.swingx.JXDatePicker ngayNhan;
    private JComboBox matHang;
    private JTable matHangTable;
    private JButton addMatHang;
    private JButton taoButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton quayLaiButton;

    private DonHangController controller;

    public DonHangGUI(DonHangController controller) {
        this.controller = controller;
        addBtnListeners();
        try {
            donHangTable.setModel(controller.loadRecords());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Container draw() {
        Container rootContainer = new Container();
        rootContainer.setLayout(new BorderLayout(0, 10));
        rootContainer.add(mainPanel);
        return rootContainer;
    }

    private void addBtnListeners() {
        taoButton.addActionListener(e -> {
            DonHang dh;
            try {
                dh = new DonHang(maDonHang.getText(), ngayNhan.getDate());
                controller.addNew(dh);
                donHangTable.setModel(controller.loadRecords());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        suaButton.addActionListener(e -> {
            DonHang dh;
            try {
                dh = new DonHang(maDonHang.getText(), ngayNhan.getDate());
                controller.updateRecord(dh, maDonHang.getText());
                donHangTable.setModel(controller.loadRecords());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        xoaButton.addActionListener(e -> {
            controller.deleteRecord(maDonHang.getText());
        });
        quayLaiButton.addActionListener(e -> controller.moveToHome());
    }
}
