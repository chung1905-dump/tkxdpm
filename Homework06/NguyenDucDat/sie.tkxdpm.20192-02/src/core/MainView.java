package core;

import main.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView implements IView {
    private final MainController controller;

    public MainView(MainController controller) {
        this.controller = controller;
    }

    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(20, 20));

        rootContainer.add(getButton("Phuong thuc van chuyen", e -> System.out.println("Not done yet")), BorderLayout.PAGE_START);
        rootContainer.add(getButton("Mat hang kinh doanh", e -> controller.moveToMHKD()), BorderLayout.CENTER);
        rootContainer.add(new JButton("Quit"), BorderLayout.PAGE_END);

        return rootContainer;
    }

    private JButton getButton(String text, ActionListener listener) {
        JButton btn = new JButton(text);
        btn.addActionListener(listener);
        return btn;
    }
}
