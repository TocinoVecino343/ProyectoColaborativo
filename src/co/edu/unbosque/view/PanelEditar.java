package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelEditar extends JPanel  {
	
	 private JButton btnEliminar, btnActualizar;
	 
	 private final Color COLOR_BOTON = new Color(52, 131, 250);
	    

       
	    public void inicializarComponentes() {
	    	  btnEliminar = crearBotonPrincipal("Eliminar componente ");
	          btnActualizar.setActionCommand("Actualizar Componente ");
	          
	    }
	    
	    private JButton crearBotonPrincipal(String texto) {
	        JButton boton = new JButton(texto);
	        boton.setFont(new Font("Arial", Font.BOLD, 16));
	        boton.setBackground(COLOR_BOTON);
	        boton.setForeground(Color.WHITE);
	        boton.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
	        boton.setFocusPainted(false);
	        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			return boton;
	        
	 
	  
}
}


