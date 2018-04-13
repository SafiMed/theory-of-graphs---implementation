package com.jihane.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
//					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(309, 78, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saisissez le nombre de Noeuds :");
		lblNewLabel.setBounds(45, 81, 200, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(547, 77, 97, 25);
		frame.getContentPane().add(btnValider);
		
		JLabel lblSaisissezLeNombre = new JLabel("Saisissez le nombre d'arcs :");
		lblSaisissezLeNombre.setBounds(45, 134, 200, 16);
		frame.getContentPane().add(lblSaisissezLeNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 131, 116, 22);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("Valider");
		button.setBounds(547, 130, 97, 25);
		frame.getContentPane().add(button);
	}
}