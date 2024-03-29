package pathFinder;

import java.awt.Point;

import java.util.Stack;

public class Node {

	

	private int compteur = 0;
	private Point point;
	
	public Node(Point point, int compteur){
		this.point = point;
		this.compteur = compteur;
	}
	
	public boolean isBest(Stack<Node> path){
		for(Node otherNode : path){
			if(this.point.equals(otherNode.point) && this.getCompteur() >= otherNode.getCompteur()){
				return false;
			}
		}
		return true;
	}
	
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
}
