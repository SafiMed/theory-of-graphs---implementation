package com.jihane.models;
import com.jihane.models.Noeud;


public class Arc {
	private int id;
	private int poids;
	private Noeud source;
	private Noeud destination;
	private boolean orientation;


	public Arc(int id, int poids, Noeud source, Noeud destination, boolean orientation) {
		super();
		this.id = id;
		this.poids = poids;
		this.source = source;
		this.destination = destination;
		this.orientation = orientation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public Noeud getSource() {
		return source;
	}

	public void setSource(Noeud source) {
		this.source = source;
	}

	public Noeud getDestination() {
		return destination;
	}

	public void setDestination(Noeud destination) {
		this.destination = destination;
	}

	public boolean isOrientation() {
		return orientation;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}
}