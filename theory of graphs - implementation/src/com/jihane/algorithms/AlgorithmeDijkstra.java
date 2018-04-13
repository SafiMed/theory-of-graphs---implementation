package com.jihane.algorithms;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.jihane.models.Arc;
import com.jihane.models.Graphe;
import com.jihane.models.Noeud;

public class AlgorithmeDijkstra {
	private Graphe graphe;

    private Set<Noeud> settledNodes;
    private Set<Noeud> unSettledNodes;
    private Map<Noeud, Noeud> predecessors;
    private Map<Noeud, Integer> distance;
   
	public AlgorithmeDijkstra(Graphe graphe) {
		super();
		this.graphe = graphe;
	}

    public Graphe getGraphe() {
		return graphe;
	}


	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}

    public void execute(Noeud source) {
        settledNodes = new HashSet<Noeud>();
        unSettledNodes = new HashSet<Noeud>();
        distance = new HashMap<Noeud, Integer>();
        predecessors = new HashMap<Noeud, Noeud>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Noeud node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }
 
    private void findMinimalDistances(Noeud noeud) {
        LinkedList<Noeud> adjacentNodes = getVoisions(noeud);
        for (Noeud target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(noeud)
                    + getDistance(noeud, target)) {
                distance.put(target, getShortestDistance(noeud)
                        + getDistance(noeud, target));
                predecessors.put(target, noeud);
                unSettledNodes.add(target);
            }
        }

    }

	private int getDistance(Noeud source, Noeud destination) {
        for (Arc arc : this.getGraphe().getArcs()) {
            if (arc.getSource().equals(source) && arc.getDestination().equals(destination)) {
                return arc.getPoids();
            }
        }
        throw new RuntimeException("Should not happen");
    }
	
    private LinkedList<Noeud> getVoisions(Noeud noeud) {
    	LinkedList<Noeud> voisions = new LinkedList<Noeud>();
        for (Arc arc : this.getGraphe().getArcs()) {
            if (arc.getSource().equals(noeud) && !isSettled(arc.getDestination())) {
                voisions.add(arc.getDestination());
            }
        }
        return voisions;
    }
    
    private Noeud getMinimum(Set<Noeud> noeuds) {
    	Noeud minimum = null;
        for (Noeud noeud : noeuds) {
            if (minimum == null) {
                minimum = noeud;
            } else {
                if (getShortestDistance(noeud) < getShortestDistance(minimum)) {
                    minimum = noeud;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Noeud noeud) {
        return settledNodes.contains(noeud);
    }
    
    private int getShortestDistance(Noeud destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }
    
    public LinkedList<Noeud> getPath(Noeud target) {
        LinkedList<Noeud> path = new LinkedList<Noeud>();
        Noeud step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}