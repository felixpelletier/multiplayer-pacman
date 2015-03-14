package pathFinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

import jeu.Case;
import jeu.Case.TYPE_CASE;

public final class PathFinder {

	public static Point[] getPath(Case[][] cases,int x1,int y1,int x2,int y2){
		
		return getPath(cases,new Point(x1,y1),new Point(x2,y2));
		
	}
	
	
	private static Stack<Node> getPossiblePaths(Case[][] cases,Point source,Point destination){

		Node startNode = new Node(source,0);
		Stack<Node> path = new Stack<Node>();
		path.add(startNode);
		
		int index = 0;
		boolean finished = false;
		
		
		while(index < path.size() && !finished){
			Node currentNode = path.get(index);
			
			ArrayList<Node> subNodes = getSubNodes(currentNode);
			
			Iterator<Node> subNodeIterator = subNodes.iterator();
			while(subNodeIterator.hasNext()){
				Node subNode = subNodeIterator.next();
				try{
				if(cases[subNode.getPoint().x][subNode.getPoint().y].estBloc() || !subNode.isBest(path)){
					subNodeIterator.remove();
				}else if(subNode.getPoint().equals(destination)){
					finished = true;
				}
				} catch (ArrayIndexOutOfBoundsException ex){
					subNodeIterator.remove();
				}
			}
			path.addAll(subNodes);
			index++;
			
			
		}

		return path;
	}

	private static ArrayList<Node> getSubNodes(final Node node){
		ArrayList<Node> subNodes = new ArrayList<Node>();
		subNodes.add(new Node(new Point(node.getPoint().x + 1,node.getPoint().y),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x - 1,node.getPoint().y),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x,node.getPoint().y + 1),node.getCompteur() + 1));
		subNodes.add(new Node(new Point(node.getPoint().x,node.getPoint().y - 1),node.getCompteur() + 1));
		return subNodes;
	}
	
	/*private static ArrayList<Point> nodeListToPointList(ArrayList<Node> nodes){
		ArrayList<Point> points = new ArrayList<Point>();
			for (Node node : nodes){
				points.add(node.getPoint());
			}
		return points;
	}*/
	
	private static int[][] mapNodes(Stack<Node> pathsList ,int width , int height){
		int[][] map = new int[width][height];
		
		for (int[] ligne: map)
		    Arrays.fill(ligne, -1);
		
		for(Node node : pathsList){
			map[node.getPoint().x][node.getPoint().y] = node.getCompteur();
		}
		
		return map;
	}
	
	
	public static Point[] getPath(Case[][] cases,Point source,Point destination){//Retournera Point
		 Stack<Node> pathsList = getPossiblePaths(cases,source,destination);
		 int[][] nodeMap = mapNodes(pathsList,cases.length, cases[0].length);
		 Point[] path = getShortestPath(nodeMap,source,destination);
		 
		 return path;
	}
	
	public static Point[] getPathExcluding(Case[][] cases,Point source,Point destination,Point exclusion){//Retournera Point
		
		Case.TYPE_CASE typeMemory = cases[exclusion.x][exclusion.y].getType();
		cases[exclusion.x][exclusion.y].setType(TYPE_CASE.BlocH);
		
		 Stack<Node> pathsList = getPossiblePaths(cases,source,destination);
		 int[][] nodeMap = mapNodes(pathsList,cases.length, cases[0].length);
		 Point[] path = getShortestPath(nodeMap,source,destination);
		 
		 cases[exclusion.x][exclusion.y].setType(typeMemory);
		 
		 return path;
	}


	private static Point[] getShortestPath(final int[][] nodeMap, Point source,Point destination) {
		Stack<Point> path = new Stack<Point>();
		Point currentPosition = (Point) destination.clone();
		path.add(currentPosition);
		
		
		boolean termine = false;
		do{
			
			ArrayList<Point> candidates = new ArrayList<Point>(4);
			candidates.add(new Point(currentPosition.x - 1,currentPosition.y));
			candidates.add(new Point(currentPosition.x + 1,currentPosition.y));
			candidates.add(new Point(currentPosition.x,currentPosition.y - 1));
			candidates.add(new Point(currentPosition.x,currentPosition.y + 1));
			
			Iterator<Point> checker = candidates.iterator();
			while (checker.hasNext()){
				Point pointChecked = checker.next();
				if(pointChecked.x<0 || pointChecked.y < 0 || pointChecked.x >= nodeMap.length || pointChecked.y >= nodeMap[0].length || nodeMap[pointChecked.x][pointChecked.y] == -1){
					checker.remove();
				}
			}
			
			Collections.sort(candidates, new Comparator<Point>(){
				public int compare(Point p1, Point p2){

						return nodeMap[p2.x][p2.y] - nodeMap[p1.x][p1.y];
					
				}
			});
			
			/*for(Point p : candidates){
				System.out.print(nodeMap[p.x][p.y] + ", ");
			}
			System.out.println(""); */
			
			if(candidates.size() <= 0){
				termine  = true;
			}
			else{
				currentPosition = candidates.get(candidates.size() - 1);
			}
				
				path.add(currentPosition);
			
			
			
		}while(!currentPosition.equals(source) && !termine);
		
		return (Point[]) path.toArray(new Point[0]);
	}
	
	
	
	
	
}
