package com.jihane.gui;

import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jihane.models.Arc;
import com.jihane.models.Noeud;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ManageArcs extends JFrame {

	JTable table = new JTable(new DefaultTableModel(new Object[]{"Arc ID", "Poids", "Source", "Destination"}, 0));
	DefaultTableModel model = (DefaultTableModel) table.getModel();

	
	/**
	 * Create the frame.
	 */
	public ManageArcs(LinkedList<Noeud> noeuds, int nombreArcs) {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 427);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		this.dessinerTable(nombreArcs);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(0, 42, 494, 292);
		getContentPane().add(js);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame frame;
					Main window = new Main(nommerArcs(table, noeuds, nombreArcs), noeuds.size(), nombreArcs);
//					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					setVisible(false);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(0, 335, 494, 45);
		getContentPane().add(btnNewButton);
		
		JLabel lblNommezLesArcs = new JLabel("Nommez les arcs :");
		lblNommezLesArcs.setBounds(12, 13, 133, 16);
		getContentPane().add(lblNommezLesArcs);
	}

	public void dessinerTable(int nombreArcs) {
		for(int i=1; i<=nombreArcs; i++) {
			model.addRow(new Object[]{i, "", "", "", ""});
		}
	}
	
	public LinkedList<Arc> nommerArcs(JTable table, LinkedList<Noeud> noeuds,  int nombreArcs) {
		LinkedList<Arc> arcs = new LinkedList<Arc>();
		for(int count=0; count<model.getRowCount(); count++) {
			Arc arc = new Arc();
			arc.setId(Integer.parseInt(model.getValueAt(count, 0).toString()));
			arc.setPoids(Integer.parseInt(model.getValueAt(count, 1).toString()));
			arc.setSource(noeuds.get(Integer.parseInt(model.getValueAt(count, 2).toString())-1));
			arc.setDestination(noeuds.get(Integer.parseInt(model.getValueAt(count, 3).toString())-1));
			arcs.add(arc);
		}
		return arcs;
	}
}
