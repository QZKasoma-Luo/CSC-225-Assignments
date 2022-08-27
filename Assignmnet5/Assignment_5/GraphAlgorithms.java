/*
	Name:QingZe Luo
	Student ID: V00953873
*/ 

import java.awt.Color;
import java.util.*;

public class GraphAlgorithms{

	/* FloodFillDFS(v, writer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour){
		writer.setPixel(v.getX(), v.getY(), fillColour);
		// TODO: implement this method
		LinkedList<PixelVertex> neighbour_node = new LinkedList<PixelVertex>(); //save all the neighbour node
		Stack<PixelVertex> exploered_node = new Stack<PixelVertex>(); // save all the exploered_node
		Stack<PixelVertex> stack_for_dfs = new Stack<PixelVertex>(); //make a stack to save all the same colour nodes
		
		stack_for_dfs.push(v); //push the first node that user selected to the stack
		while(!stack_for_dfs.isEmpty()){

			v = stack_for_dfs.pop(); // pop the first node to the current node
			writer.setPixel(v.getX(), v.getY(), fillColour);
			neighbour_node = v.getNeighbours(); // find the neighbour node of the current node
			
			for(int i = 0; i <v.getDegree(); i++){

				if(!exploered_node.contains(neighbour_node.get(i))){
					writer.setPixel(neighbour_node.get(i).getX(), neighbour_node.get(i).getY(), fillColour);
					exploered_node.push(neighbour_node.get(i));
					stack_for_dfs.push(neighbour_node.get(i));
				}
			}
			
		}

	}
	
	/* FloodFillBFS(v, writer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour){
		writer.setPixel(v.getX(), v.getY(), fillColour);
		// TODO: implement this method
		Queue<PixelVertex> Q = new LinkedList<PixelVertex>(); //make a Queue to save all the same colour node

		LinkedList<PixelVertex> neighbour_node = new LinkedList<PixelVertex>();
		Queue<PixelVertex> exploered_node = new LinkedList<PixelVertex>(); 
		Q.add(v); // add the first node
		exploered_node.add(v); 
		while(!Q.isEmpty()){
			v = Q.remove(); // pop the first node out
			writer.setPixel(v.getX(), v.getY(), fillColour); // fill in with the colour
			neighbour_node = v.getNeighbours(); // get the neighbout of the node
			for(int i = 0; i < v.getDegree(); i++){
				if(!exploered_node.contains(neighbour_node.get(i))){
					writer.setPixel(neighbour_node.get(i).getX(), neighbour_node.get(i).getY(), fillColour);
					exploered_node.add(neighbour_node.get(i));
					Q.add(neighbour_node.get(i));
				}
			}
		}
	}
	
}