package datastr.nodes;

public class MyEdgeNode {
	private int indexOfNeighbour;
	private float weight;
	private MyEdgeNode next = null;
	private MyEdgeNode previous = null;
	
	public int getIndexOfNeighbour() {
		return indexOfNeighbour;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public MyEdgeNode getNext() {
		return next;
	}
	
	public MyEdgeNode getPrevious() {
		return previous;
	}
	
	public void setIndexOfNeighbour(int indexOfNeighbour) {
		if(indexOfNeighbour > 0)
			this.indexOfNeighbour = indexOfNeighbour;
		else
			this.indexOfNeighbour = -1;
	}
	
	public void setWeight(float weight) {
		if(weight > 0 && weight < 40000)
			this.weight = weight;
		else
			this.weight = 0;
	}
	
	public void setNext(MyEdgeNode next) {
		this.next = next;
	}
	
	public void setPrevious(MyEdgeNode previous) {
		this.previous = previous;
	}
	
	public MyEdgeNode(int indexOfNeighbour, float weight) {
		setIndexOfNeighbour(indexOfNeighbour);
		setWeight(weight);
	}
	
	public String toString() {
		return weight + "km";
	}
}
