package com.omertasci.codelaio.challenges;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaOfTheLargestIsland {

	public static void main(String[] args) throws Exception {
	
//		int [] island_map = {1, 1, 0, 1, 1, 
//							 0, 0, 1, 1, 0, 
//							 0, 1, 0, 0, 0, 
//							 0, 0, 0, 0, 1};
//		int width = 5;
//		int height = 4;
		
//		int [] island_map ={0, 1, 0, 1, 1, 1, 0, 0, 1,
//							0, 1, 0, 1, 1, 1, 0, 0, 1,
//							0, 1, 0, 1, 0, 1, 0, 0, 1,
//							0, 0, 0, 1, 1, 1, 0, 0, 0,
//							0, 1, 0, 1, 0, 1, 1, 1, 1,
//							0, 0, 1, 1, 1, 1, 0, 0, 0,
//							0, 1 ,0, 1, 0, 1, 0, 0, 1};
//		
//		int width = 9;
//		int height = 7;
		
		int [] island_map ={0, 1, 0, 1, 1, 1, 0, 0, 1,
							0, 1, 0, 1, 1, 1, 0, 0, 1,
							0, 1, 0, 1, 0, 1, 0, 0, 1,
							0, 0, 0, 1, 1, 1, 0, 0, 0,
							0, 1, 0, 1, 0, 1, 1, 1, 1,
							0, 0, 1, 1, 1, 1, 0, 0, 0,
							0, 1 ,0, 1, 0, 1, 0, 0, 1,
							0, 1, 0, 1, 1, 1, 0, 0, 1,
							0, 1, 0, 1, 1, 1, 0, 0, 1,
							0, 1, 0, 1, 0, 1, 0, 0, 1,
							0, 0, 0, 1, 1, 1, 0, 0, 0,
							0, 1, 0, 1, 0, 1, 1, 1, 1,
							0, 0, 1, 1, 1, 1, 0, 0, 0,
							0, 1 ,0, 1, 0, 1, 0, 0, 1};

		int width = 9;
		int height = 14;
		
		if((width * height)!= island_map.length){			
			throw new Exception("The given island_map does not agree with width and height values!");
		}
		
		List<Node> nodePool = new ArrayList();
		Map<Integer, Node> nodePoolMap = new HashMap();
		
		for(int i = 0 ; i<island_map.length; i++){
			Node node = new Node();
			node.setNodeId(i);
			node.setValue(island_map[i]);
			nodePoolMap.put(i, node);
		}
		for(int i = 0 ; i<nodePoolMap.size(); i++){
			
			Node currentNode = nodePoolMap.get(i);
			Node lefttNeighbour;
			Node rightNeighbour;
			Node topNeighbour;
			Node bottomNeighbour;
			
			if( i != 0 && i % width != 0){
				lefttNeighbour = nodePoolMap.get(i-1);
				currentNode.setLefttNeighbour(lefttNeighbour);
			}
			if( i != (nodePoolMap.size()-1) && i % width != 4){
				rightNeighbour = nodePoolMap.get(i+1);
				currentNode.setRightNeighbour(rightNeighbour);
			}
			if( i > width ){
				topNeighbour = nodePoolMap.get(i-width);
				currentNode.setTopNeighbour(topNeighbour);
			}
			if( i < (nodePoolMap.size() - width ) ){
				bottomNeighbour = nodePoolMap.get(i+width);
				currentNode.setBottomNeighbour(bottomNeighbour);
			}
		}
		
//		List<Node> nodePoolMax = new ArrayList<Node>();
		Map<Integer, Node> nodePoolMapMax = new HashMap<Integer, Node>();
		
		for(int i=0; i< nodePoolMap.size(); i++){
			
			Map<Integer, Node> nodePoolMapCurrent = new HashMap<Integer, Node>();
			
			if(nodePoolMap.get(i).getValue() == 1){
				nodePoolMapCurrent = insertToNodePool(nodePoolMapCurrent, nodePoolMap.get(i));
			}
			
			if(nodePoolMapMax.size() < nodePoolMapCurrent.size()){
				
				nodePoolMapMax = nodePoolMapCurrent;
			}
		}
		
		System.out.println(nodePoolMapMax.size());

	}
	
	public static Map<Integer, Node> insertToNodePool(Map<Integer, Node> nodePoolMapCurrent, Node node) throws FileNotFoundException {

		try {

			if (!nodePoolMapCurrent.containsValue(node)) {
				nodePoolMapCurrent.put(nodePoolMapCurrent.size(), node);
				
				if (node.getLefttNeighbour() != null && node.getLefttNeighbour().getValue() == 1 && !nodePoolMapCurrent.containsValue(node.getLefttNeighbour()) ) {
					insertToNodePool(nodePoolMapCurrent, node.getLefttNeighbour());
				}
				if (node.getRightNeighbour() != null && node.getRightNeighbour().getValue() == 1 && !nodePoolMapCurrent.containsValue(node.getRightNeighbour())) {
					insertToNodePool(nodePoolMapCurrent, node.getRightNeighbour());
				}
				if (node.getTopNeighbour() != null && node.getTopNeighbour().getValue() == 1 && !nodePoolMapCurrent.containsValue(node.getTopNeighbour())) {
					insertToNodePool(nodePoolMapCurrent, node.getTopNeighbour());
				}
				if (node.getBottomNeighbour() != null && node.getBottomNeighbour().getValue() == 1 && !nodePoolMapCurrent.containsValue(node.getBottomNeighbour())) {
					insertToNodePool(nodePoolMapCurrent, node.getBottomNeighbour());
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace(new PrintStream("node :" + node.getNodeId()));
		}

		return nodePoolMapCurrent;

	}

}

class Node{
	
	private int nodeId;
	private int value;
	private Node rightNeighbour;
	private Node lefttNeighbour;
	private Node topNeighbour;
	private Node bottomNeighbour;
	
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}	
	public Node getRightNeighbour() {
		return rightNeighbour;
	}
	public void setRightNeighbour(Node rightNeighbour) {
		this.rightNeighbour = rightNeighbour;
	}
	public Node getLefttNeighbour() {
		return lefttNeighbour;
	}
	public void setLefttNeighbour(Node lefttNeighbour) {
		this.lefttNeighbour = lefttNeighbour;
	}
	public Node getTopNeighbour() {
		return topNeighbour;
	}
	public void setTopNeighbour(Node topNeighbour) {
		this.topNeighbour = topNeighbour;
	}
	public Node getBottomNeighbour() {
		return bottomNeighbour;
	}
	public void setBottomNeighbour(Node bottomNeighbour) {
		this.bottomNeighbour = bottomNeighbour;
	}
	
	
	
	
	
}