package main;

import core.MainController;
import util.DatabaseExecutor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Application {
    private static JFrame f;

    public final static int ANIM_NONE = 0;
    public final static int ANIM_SWIPE_LEFT = 1;
    public final static int ANIM_SWIPE_RIGHT = 2;

    public static void main(String[] args) throws SQLException {
        loading();
        f = new JFrame();
        f.setSize(800, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        runController(getFirstController());
    }

    public static void runController(IController controller) {
        runController(controller, ANIM_NONE);
    }

    public static void runController(IController controller, int animation) {
        IView view = controller.run();
        f.setContentPane(view.draw());
        f.revalidate();

        if (animation != ANIM_NONE) {
            Container c = f.getContentPane();
            int x_velocity;
            Point initLocation;
            switch (animation) {
                case ANIM_SWIPE_LEFT:
                    initLocation = new Point(c.getWidth(), 0);
                    x_velocity = -10;
                    break;
                case ANIM_SWIPE_RIGHT:
                    initLocation = new Point(-c.getWidth(), 0);
                    x_velocity = 10;
                    break;
                default:
                    // Not supported animation
                    return;
            }
            c.setLocation(initLocation);
            new Timer(1, e -> {
                c.setLocation(c.getX() + x_velocity, 0);
                if (c.getX() * x_velocity >= 0) {
                    c.setLocation(0, 0);
                    ((Timer) e.getSource()).stop();
                }
            }).start();
        }
    }

    private static void loading() throws SQLException {
        DatabaseExecutor.getInstance();
    }

    private static IController getFirstController() {
        return new MainController();
    }
}
