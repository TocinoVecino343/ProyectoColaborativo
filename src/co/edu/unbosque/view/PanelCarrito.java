package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Item;

public class PanelCarrito extends JPanel {

	private JPanel panelItem;
	private JScrollPane scrollPane;
	private JButton btnComprarCarrito;

	public PanelCarrito() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		panelItem = new JPanel();
		panelItem.setLayout(new BoxLayout(panelItem, BoxLayout.Y_AXIS));
		panelItem.setBackground(Color.WHITE);

		scrollPane = new JScrollPane(panelItem);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		add(scrollPane, BorderLayout.CENTER);

		// Panel inferior con botón de comprar
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.WHITE);

		btnComprarCarrito = new JButton("Comprar Todo");
		btnComprarCarrito.setBackground(new Color(76, 175, 80));
		btnComprarCarrito.setForeground(Color.WHITE);
		btnComprarCarrito.setFont(new Font("Arial", Font.BOLD, 14));
		btnComprarCarrito.setPreferredSize(new Dimension(150, 40));

		panelInferior.add(btnComprarCarrito);
		add(panelInferior, BorderLayout.SOUTH);
	}

	/**
	 * Método para cargar los items del carrito
	 * 
	 * @param items            Lista de ItemCarrito
	 * @param eliminarListener Listener que recibe el índice del item a eliminar
	 */
	public void cargarCarrito(List<Item> items, EliminarListener eliminarListener) {
		// Limpiar el panel antes de cargar nuevos items
		panelItem.removeAll();

		if (items == null || items.isEmpty()) {
			JLabel lblVacio = new JLabel("El carrito está vacío");
			lblVacio.setHorizontalAlignment(SwingConstants.CENTER);
			lblVacio.setFont(new Font("Arial", Font.ITALIC, 16));
			lblVacio.setForeground(Color.GRAY);
			panelItem.add(lblVacio);
		} else {
			// Generar un panel por cada item en el carrito
			for (int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				JPanel itemPanel = crearPanelItem(item, i, eliminarListener);
				panelItem.add(itemPanel);
			}
		}

		// Refrescar la vista
		panelItem.revalidate();
		panelItem.repaint();
	}

	/**
	 * Crea un panel individual para cada item del carrito
	 */
	private JPanel crearPanelItem(Item item, int index, EliminarListener eliminarListener) {
		JPanel itemPanel = new JPanel(new BorderLayout());
		itemPanel.setBackground(Color.WHITE);
		itemPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
				BorderFactory.createEmptyBorder(10, 15, 10, 15)));
		itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
		itemPanel.setPreferredSize(new Dimension(0, 80));

		// Panel izquierdo con nombre y precio
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		panelInfo.setBackground(Color.WHITE);

		JLabel lblNombre = new JLabel(item.getNombreProducto());
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setForeground(Color.BLACK);

		JLabel lblPrecio = new JLabel("$" + String.format("%.2f", item.getPrecioProducto()));
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecio.setForeground(new Color(76, 175, 80));

		panelInfo.add(lblNombre);
		panelInfo.add(lblPrecio);

		// Botón eliminar a la derecha
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(244, 67, 54));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));

		// Al hacer click, llamar el listener con el índice
		if (eliminarListener != null) {
			btnEliminar.addActionListener(e -> eliminarListener.eliminar(index));
		}

		// Agregar componentes al panel del item
		itemPanel.add(panelInfo, BorderLayout.CENTER);
		itemPanel.add(btnEliminar, BorderLayout.EAST);

		return itemPanel;
	}

	/**
	 * Interface para el listener de eliminar
	 */
	@FunctionalInterface
	public interface EliminarListener {
		void eliminar(int indice);
	}

	/**
	 * Obtiene el botón de comprar carrito
	 */
	public JButton getBtnComprarCarrito() {
		return btnComprarCarrito;
	}

	/**
	 * Actualiza el texto del botón con el total
	 */
	public void actualizarTotal(double total) {
		btnComprarCarrito.setText("Comprar Todo ($" + String.format("%.2f", total) + ")");
	}

	public JPanel getPanelItem() {
		return panelItem;
	}

	public void setPanelItem(JPanel panelItem) {
		this.panelItem = panelItem;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setBtnComprarCarrito(JButton btnComprarCarrito) {
		this.btnComprarCarrito = btnComprarCarrito;
	}

	
}