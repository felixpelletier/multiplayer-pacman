package pathFinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import jeu.Case;

public final class PathFinder {

	public static ArrayList<Node> getPath(Case[][] cases,int x1,int y1,int x2,int y2){
		
		return getPath(cases,new Point(x1,y1),new Point(x2,y2));
		
	}
	
	public static ArrayList<Node> getPath(Case[][] cases,Point source,Point destination){ //Retournera Point
		
		Node startNode = new Node(source,0);
		ArrayList<Node> path = new ArrayList<Node>();
		path.add(startNode);
		
		Iterator<Node> iterator = path.iterator();
		
		while(path.get(path.size()-1).getPoint().equals(destination) || iterator.hasNext()){
			Node currentNode = iterator.next();
			ArrayList<Node> subNodes = getSubNodes(currentNode);
			
			Iterator<Node> subNodeIterator = subNodes.iterator();
			while(!subNodeIterator.hasNext()){
				Node subNode = subNodeIterator.next();
				if(cases[subNode.getPoint().x][subNode.getPoint().y].estBloc() || !subNode.isBest(path)){
					subNodeIterator.remove();
				}
			}
			path.addAll(subNodes);
			
		}
			
		return path;
	}

	private static ArrayList<Node> getSubNodes(Node node){
		ArrayList<Node> subNodes = new ArrayList<Node>();
		subNodes.add(new Node(new Point(node.getPoint().x + 1,node.getPoint().y),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x - 1,node.getPoint().y),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x,node.getPoint().y + 1),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x,node.getPoint().y - 1),node.getCompteur() + 1));
		return subNodes;
	}
	
	private static ArrayList<Point> nodeListToPointList(ArrayList<Node> nodes){
		ArrayList<Point> points = new ArrayList<Point>();
			for (Node node : nodes){
				points.add(node.getPoint());
			}
		return points;
	}
	
	
	
}
