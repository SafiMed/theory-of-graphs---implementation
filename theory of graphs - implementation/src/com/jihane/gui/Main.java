package com.jihane.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jihane.models.Noeud;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Main extends JFrame{

	JFrame frame;
	private JTextField nombreNoeudsField;
	private JTextField nombreArcsField;

	LinkedList<Noeud> noeuds = new LinkedList<Noeud>();

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

	public Main(LinkedList<Noeud> noeuds) {
		this.noeuds = noeuds;
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
		
		nombreNoeudsField = new JTextField();
		nombreNoeudsField.setBounds(309, 78, 116, 22);
		frame.getContentPane().add(nombreNoeudsField);
		nombreNoeudsField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saisissez le nombre de Noeuds :");
		lblNewLabel.setBounds(45, 81, 200, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnValiderNoeuds = new JButton("Valider");
		btnValiderNoeuds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nombreNoeuds = Integer.parseInt(nombreNoeudsField.getText());
				
				new ManageNoeuds(nombreNoeuds).setVisible(true);
				frame.setVisible(false);
			}
		});
		btnValiderNoeuds.setBounds(547, 77, 97, 25);
		frame.getContentPane().add(btnValiderNoeuds);
		
		JLabel lblSaisissezLeNombre = new JLabel("Saisissez le nombre d'arcs :");
		lblSaisissezLeNombre.setBounds(45, 134, 200, 16);
		frame.getContentPane().add(lblSaisissezLeNombre);
		
		nombreArcsField = new JTextField();
		nombreArcsField.setColumns(10);
		nombreArcsField.setBounds(309, 131, 116, 22);
		frame.getContentPane().add(nombreArcsField);
		
		JButton btnValiderArcs = new JButton("Valider");
		btnValiderArcs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nombreArcs = Integer.parseInt(nombreArcsField.getText());
				
				new ManageArcs(noeuds, nombreArcs).setVisible(true);
				frame.setVisible(false);
			}
		});
		btnValiderArcs.setBounds(547, 130, 97, 25);
		frame.getContentPane().add(btnValiderArcs);
	}
}
