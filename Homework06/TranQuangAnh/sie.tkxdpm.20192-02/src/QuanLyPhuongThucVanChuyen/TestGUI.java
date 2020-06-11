package QuanLyPhuongThucVanChuyen;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGUI {

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        //TransportationWindow sForm = new TransportationWindow(null, false);
        TransportationInfoController controller = new TransportationInfoController();
		TransportationInfoGUI sForm = new TransportationInfoGUI(new javax.swing.JFrame(), true, controller);
        sForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        sForm.pack();
        sForm.setLocationRelativeTo(null);

        sForm.setVisible(true);
    }

}
