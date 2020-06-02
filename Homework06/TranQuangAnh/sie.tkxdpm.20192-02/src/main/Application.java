package main;

import QuanLyMHKD.controller.MHKDController;

import javax.swing.*;
import java.awt.*;

public class Application {
    private static JFrame f;

    public static void main(String[] args) {
        f = new JFrame();
        f.setSize(800, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        runController(getFirstController());
    }

    public static void runController(IController controller) {
        runController(controller, 0);
    }

    public static void runController(IController controller, int animation) {
        IView view = controller.run();
        f.setContentPane(view.draw());
        f.revalidate();

        if (animation != 0) {
            Container c = f.getContentPane();
            c.setLocation(c.getWidth(), 0);
            new Timer(1, e -> {
                c.setLocation(c.getX() - 1, 0);
                if (c.getX() <= 0) {
                    ((Timer) e.getSource()).stop();
                }
            }).start();
        }
    }

    private static IController getFirstController() {
        // @todo: Should return LoginController
        return new MHKDController();
    }
}
