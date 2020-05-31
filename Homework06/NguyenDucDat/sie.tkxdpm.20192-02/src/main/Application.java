package main;

import QuanLyMHKD.controller.MHKDController;

import javax.swing.*;

public class Application {
    private static JFrame f;

    public static void main(String[] args) {
        f = new JFrame();
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        runController(getFirstController());
    }

    public static void runController(IController controller) {
        IView view = controller.run();
        f.setContentPane(view.draw());
        f.revalidate();
    }

    private static IController getFirstController() {
        // @todo: Should return LoginController
        return new MHKDController();
    }
}
