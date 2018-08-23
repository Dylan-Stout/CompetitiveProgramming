package com.crackingthecodinginterview.problemset.chapter4;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphNode {
	
	ArrayList<GraphNode> connectedNodes = new ArrayList<GraphNode>(); 
	boolean isVisited; 
	int value; 
	 
	public GraphNode(){
		this(-1); 
	}
	
	public GraphNode(int value){
		this.isVisited = false; 
		this.value=value; 
	}
	
	public GraphNode(int value, ArrayList<GraphNode> connectedNodes){
		this.isVisited = false; 
		this.value = value; 
		this.connectedNodes = connectedNodes; 
	}
	
	public void markAsVisited()
	{
		isVisited=true; 
	}
	
	
	public void addNodeConnection(GraphNode node)
	{
		this.connectedNodes.add(node); 
	}
	
	public void printConnections()
	{
		if(connectedNodes!=null){
			Iterator<GraphNode> iter = connectedNodes.iterator(); 
			System.out.print("Connections from "+ this.value + ":");
			while(iter.hasNext())
			{
				System.out.print(iter.next().value + "->"); 
			}
		}else{
			System.out.print("There are no connections from "+ this.value +"!");
		}
	}
}
	


