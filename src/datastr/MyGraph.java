package datastr;

import datastr.nodes.MyEdgeNode;
import datastr.nodes.MyVerticeNode;

public class MyGraph<T> {
	private MyVerticeNode[] vertices;
	private final int GRAPH_DEFAULT_SIZE = 10;
	private int size = GRAPH_DEFAULT_SIZE;
	private int counter = 0;
	
	public MyGraph() {
		vertices = new MyVerticeNode[size];
	}
		
	public MyGraph(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		vertices = new MyVerticeNode[size];
	}
		
	public boolean isEmpty() {
		return (counter==0);
	}
		
	public boolean isFull() {
		return (counter == size);
	}
		
	public int howManyElements() {
		return counter;
	}
	
	private void resize()
	{
		int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
		MyVerticeNode[] verticesNew = new MyVerticeNode[newSize];
		for(int i = 0; i < size; i++) {
			vertices[i] = verticesNew[i];
		}
			
		vertices = verticesNew;
		System.gc();
		size = newSize;
	}
	
	public void addVertice(T element) throws Exception {
		if (element == null) throw new Exception("Bad element value.");
		if(isFull()) resize();
		if(findElement(element) != -1) throw new Exception("Vertice already exists.");
		
		MyVerticeNode newNode = new MyVerticeNode<T>(element);
		vertices[counter++] = newNode;
	}
	
	private int findElement(T element) throws Exception{
		for(int i = 0; i < counter; i++) {
			if(vertices[i].getElement().equals(element)) return i;
		}
		return -1; //Vertice not found.
	}
	
	public void addEdge(float weight, T verticeFrom, T verticeTo) throws Exception {
		if (verticeFrom == null || verticeTo == null) throw new Exception("Bad input values.");
		if(verticeFrom.equals(verticeTo)) throw new Exception("Cannot create edge to the same vertice");
		
		int indexFrom = findElement(verticeFrom);
		int indexTo = findElement(verticeTo);
		if(indexFrom == -1 || indexTo == -1) throw new Exception("At least one of the vertices does not exist.");
		
		MyEdgeNode newEdgeNode = new MyEdgeNode(indexTo, weight);
		
		if(vertices[indexFrom].getFirstEdgeNode() == null) {
			vertices[indexFrom].setFirstEdgeNode(newEdgeNode);
		}
		else {
			MyEdgeNode firstEdgeNode = vertices[indexFrom].getFirstEdgeNode();
			newEdgeNode.setNext(firstEdgeNode);
			firstEdgeNode = newEdgeNode;
			vertices[indexFrom].setFirstEdgeNode(firstEdgeNode);
		}
	}
	
	public void print() throws Exception {
		if(isEmpty()) throw new Exception("Graph is empty.");
		for(int i = 0; i < counter; i++) {
			System.out.print(vertices[i].getElement() + " ---> ");
			MyEdgeNode tempEdge = vertices[i].getFirstEdgeNode();
			while(tempEdge != null) {
				System.out.print(vertices[tempEdge.getIndexOfNeighbour()].getElement() + "[" + tempEdge.getWeight() + "km];");
				tempEdge = tempEdge.getNext();
			}
			System.out.println();
		}
	}
}
