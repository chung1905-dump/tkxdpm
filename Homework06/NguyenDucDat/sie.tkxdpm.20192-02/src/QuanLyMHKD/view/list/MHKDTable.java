package QuanLyMHKD.view.list;

import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDTable implements IView {
    public Container draw() {
        String column[] = {"ID", "Name", "Sitecode", "Qty", "Unit"};
        String data[][] = {
                {"1", "Test 1", "ABCD", "4", "hop"},
                {"2", "Test 2", "EFGH", "1000", "lit"},
                {"3", "Test 3", "VIN", "1", "CHIEC"}
        };
        JTable table = new JTable(data, column);
        return table;
    }
}
