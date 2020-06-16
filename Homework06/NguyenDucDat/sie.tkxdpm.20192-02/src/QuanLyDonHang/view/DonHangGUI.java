package QuanLyDonHang.view;

import main.view.IView;

import javax.swing.*;
import java.awt.*;

public class DonHangGUI extends JFrame implements IView {
    private JPanel mainPanel;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTable table2;
    private JButton button1;
    private JButton taoButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton quayLaiButton;

    public DonHangGUI() {
        setContentPane(mainPanel);
    }

    @Override
    public Container draw() {
        return mainPanel;
    }
}
