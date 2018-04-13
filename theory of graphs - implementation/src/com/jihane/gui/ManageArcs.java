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

public class ManageArcs extends JFrame {

	JTable table = new JTable(new DefaultTableModel(new Object[]{"Arc ID", "Poids", "Source", "Destination"}, 0));
	DefaultTableModel model = (DefaultTableModel) table.getModel();

	
	/**
	 * Create the frame.
	 */
	public ManageArcs(LinkedList<Noeud> noeuds, int nombreArcs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 427);
		getContentPane().setLayout(null);
		this.dessinerTable(nombreArcs);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(0, 42, 494, 292);
		getContentPane().add(js);
		
		JButton btnNewButton = new JButton("Valider");
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
	
	public LinkedList<Arc> nommerArcs(JTable table, int nombreArcs) {
		LinkedList<Arc> arcs = new LinkedList<Arc>();
		for(int count=0; count<model.getRowCount(); count++) {
			Arc arc = new Arc();
			arc.setId(Integer.parseInt(model.getValueAt(count, 0).toString()));
			arc.setPoids(Integer.parseInt(model.getValueAt(count, 1).toString()));
			arcs.add(arc);
		}
		return arcs;
	}
}
