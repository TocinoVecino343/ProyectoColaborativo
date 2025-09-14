package co.edu.unbosque.view;

import javax.swing.JFrame;
import co.edu.unbosque.controller.Controlador;

public class ViewFacade {

    private Ventana mainVentana;
    private JFrame loginFrame;
    private Controlador controlador;

    public ViewFacade(Controlador controlador) {
        this.controlador = controlador;
        this.mainVentana = new Ventana();
        this.mainVentana.setVisible(false);
    }

    public void showLogin() {
        if (loginFrame == null) {
            loginFrame = new JFrame("Iniciar Sesión - Mercado Libre");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(600, 700);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setResizable(false);

            PanelLogin panelLogin = new PanelLogin(loginFrame, controlador);
            loginFrame.add(panelLogin);
        }
        loginFrame.setVisible(true);
    }

    public void showMain() {
        if (mainVentana != null) {
            mainVentana.setVisible(true);
        }
        if (loginFrame != null) {
            loginFrame.dispose();
        }
    }

    public Ventana getMainVentana() {
        return mainVentana;
    }
}