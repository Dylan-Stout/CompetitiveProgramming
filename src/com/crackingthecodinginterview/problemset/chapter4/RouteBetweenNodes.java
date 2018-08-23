package com.crackingthecodinginterview.problemset.chapter4;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root node of a graph, determine if you have a path to the target value
 * @author dylan
 *
 */
public class RouteBetweenNodes {
	
	
	enum State{visiting, visited, unvisited}; 
	/**
	 * Recursive depth first search marking the nodes as visited along the way to avoid cycles
	 * 
	 * @param node
	 * @param targetValue
	 * @param visited
	 * @return
	 */
	public static boolean hasPath(GraphNode node, int targetValue, Queue<Integer> visited)
	{
		boolean hasPath = false; 
		if(node==null || node.connectedNodes==null || node.isVisited) return false; 
		node.isVisited = true; 
		visited.add(node.value); 
		if(node.value==targetValue) return true; 
		Iterator<GraphNode> iter = node.connectedNodes.iterator(); 
		while(iter.hasNext() )
		{
			GraphNode next = iter.next(); 
			if(!next.isVisited && hasPath(next,targetValue, visited)){
				System.out.print("->"+visited.poll());
				return true; 	
			}
			
			
		}
		return hasPath; 
	}
	
	public static void main(String[] args) {
		
		GraphNode rootNode = new GraphNode(1); 
		GraphNode aNode = new GraphNode(2); 
		GraphNode bNode = new GraphNode(3); 
		GraphNode cNode = new GraphNode(4); 
		GraphNode dNode = new GraphNode(5);
		GraphNode eNode = new GraphNode(6);
		GraphNode fNode = new GraphNode(7);
		GraphNode gNode = new GraphNode(8);
		GraphNode hNode = new GraphNode(9);
		GraphNode jNode = new GraphNode(14);
		GraphNode kNode = new GraphNode(15);
		GraphNode lNode = new GraphNode(16);
		GraphNode mNode = new GraphNode(10); 
		GraphNode nNode = new GraphNode(11); 
		GraphNode oNode = new GraphNode(12); 
		GraphNode pNode = new GraphNode(13); 
		rootNode.addNodeConnection(aNode);
		rootNode.addNodeConnection(bNode);
		rootNode.addNodeConnection(cNode); 
		aNode.addNodeConnection(dNode);
		bNode.addNodeConnection(eNode);
		cNode.addNodeConnection(fNode);
		dNode.addNodeConnection(gNode);
		eNode.addNodeConnection(hNode);
		fNode.addNodeConnection(hNode);
		fNode.addNodeConnection(jNode);
		jNode.addNodeConnection(kNode);
		hNode.addNodeConnection(mNode);
		gNode.addNodeConnection(mNode);
		mNode.addNodeConnection(nNode);
		nNode.addNodeConnection(oNode);
		oNode.addNodeConnection(pNode);
		int targetValue = 15; 
		int targetValue2 = 16; 
		int targetValue3 =10; 
		System.out.println("We "+ (hasPath(rootNode, targetValue, new PriorityQueue<Integer>()) ? "DO " : " DO NOT ") + "have a path to " + targetValue);
//		System.out.println("We "+ (hasPath(rootNode, targetValue2) ? "DO " : " DO NOT ") + "have a path to " + targetValue2);
//		System.out.println("\nWe "+ (hasPath(rootNode, targetValue3, new PriorityQueue<Integer>()) ? "DO " : " DO NOT ") + "have a path to " + targetValue3);
		
	
	}

}
