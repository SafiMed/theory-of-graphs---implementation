package com.jihane.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jihane.algorithms.AlgorithmeDijkstra;
import com.jihane.models.Arc;
import com.jihane.models.Graphe;
import com.jihane.models.Noeud;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class Main extends JFrame{

	JFrame frame;
	private JTextField nombreNoeudsField;
	private JTextField nombreArcsField;

	static LinkedList<Noeud> noeuds = new LinkedList<Noeud>();
	static LinkedList<Arc> arcs = new LinkedList<Arc>();

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

	public Main(LinkedList<Noeud> noeuds, int nombreNoeuds) {
		this.setNoeuds(noeuds);
		initialize();
		nombreNoeudsField.setText(Integer.toString(nombreNoeuds));
	}

	public Main(LinkedList<Arc> arcs, int nombreNoeuds, int nombreArcs) {
		this.setArcs(arcs);
		initialize();
		nombreNoeudsField.setText(Integer.toString(nombreNoeuds));
		nombreArcsField.setText(Integer.toString(nombreArcs));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dessinez le graphe", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 204)));
		panel_2.setBounds(0, 59, 982, 131);
		panel_2.setBackground(new Color(110, 89, 222));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		nombreNoeudsField = new JTextField();
		nombreNoeudsField.setBounds(276, 41, 116, 22);
		panel_2.add(nombreNoeudsField);
		nombreNoeudsField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saisissez le nombre de Noeuds :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 44, 236, 16);
		panel_2.add(lblNewLabel);
		
		JButton btnValiderNoeuds = new JButton("Valider");
		btnValiderNoeuds.setBounds(514, 40, 97, 25);
		panel_2.add(btnValiderNoeuds);
		
		JLabel lblSaisissezLeNombre = new JLabel("Saisissez le nombre d'arcs :");
		lblSaisissezLeNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSaisissezLeNombre.setForeground(new Color(255, 255, 255));
		lblSaisissezLeNombre.setBounds(12, 97, 200, 16);
		panel_2.add(lblSaisissezLeNombre);
		
		nombreArcsField = new JTextField();
		nombreArcsField.setBounds(276, 94, 116, 22);
		panel_2.add(nombreArcsField);
		nombreArcsField.setColumns(10);
		
		JButton btnValiderArcs = new JButton("Valider");
		btnValiderArcs.setBounds(514, 93, 97, 25);
		panel_2.add(btnValiderArcs);
		btnValiderArcs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nombreArcs = Integer.parseInt(nombreArcsField.getText());
				
				new ManageArcs(noeuds, nombreArcs).setVisible(true);
				frame.setVisible(false);
			}
		});
		btnValiderNoeuds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nombreNoeuds = Integer.parseInt(nombreNoeudsField.getText());
				
				new ManageNoeuds(nombreNoeuds).setVisible(true);
				frame.setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(0, 368, 492, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(85, 55, 118));
		panel_1.setBounds(12, 32, 456, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JTextArea logField = new JTextArea();
		logField.setBackground(new Color(255, 255, 204));
		logField.setForeground(new Color(0, 0, 0));
		logField.setBounds(504, 368, 478, 335);
		frame.getContentPane().add(logField);

		JButton btnNewButton = new JButton("Djikstra");
		btnNewButton.setBounds(178, 13, 97, 25);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphe graphe = new Graphe(arcs, noeuds);
				AlgorithmeDijkstra ad = new AlgorithmeDijkstra(graphe);
				ad.execute(noeuds.get(0));
				logField.setText(ad.getPath(noeuds.get(3)).toString());
			}
		});
	}

	public LinkedList<Noeud> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(LinkedList<Noeud> noeuds) {
		this.noeuds = noeuds;
	}

	public LinkedList<Arc> getArcs() {
		return arcs;
	}

	public void setArcs(LinkedList<Arc> arcs) {
		this.arcs = arcs;
	}
}
