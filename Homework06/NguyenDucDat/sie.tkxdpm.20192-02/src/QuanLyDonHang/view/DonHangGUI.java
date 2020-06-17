package QuanLyDonHang.view;

import QuanLyDonHang.controller.DonHangController;
import QuanLyDonHang.entity.DonHang;
import main.view.IView;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DonHangGUI implements IView {
    private JPanel mainPanel;
    private JTable donHangTable;
    private JTextField maDonHang;
    private JXDatePicker ngayNhan;
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
        donHangTableInit();
    }

    public Container draw() {
        Container rootContainer = new Container();
        rootContainer.setLayout(new BorderLayout(0, 10));
        rootContainer.add(mainPanel);
        return rootContainer;
    }

    private void donHangTableInit() {
        try {
            donHangTable.setModel(controller.loadRecords());
            donHangTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            donHangTable.getSelectionModel().addListSelectionListener(e -> {
                try {
                    if (donHangTable.getSelectedRow() >= 0) {
                        Object maDonHang = donHangTable.getValueAt(donHangTable.getSelectedRow(), 0);
                        Object ngayNhan = donHangTable.getValueAt(donHangTable.getSelectedRow(), 1);

                        this.maDonHang.setText(maDonHang.toString());
                        this.ngayNhan.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhan.toString()));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            try {
                controller.deleteRecord(maDonHang.getText());
                donHangTable.setModel(controller.loadRecords());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        quayLaiButton.addActionListener(e -> controller.moveToHome());
    }
}
