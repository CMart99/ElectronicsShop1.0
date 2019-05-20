package proyecto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class AdminCP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3459822129470487324L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminCP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStockManagementSystem = new JButton("Stock Management System");
		btnStockManagementSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				StockManagement sm = new StockManagement();
				sm.setVisible(true);

			}
		});
		btnStockManagementSystem.setBounds(40, 73, 170, 23);
		contentPane.add(btnStockManagementSystem);
	}

}
