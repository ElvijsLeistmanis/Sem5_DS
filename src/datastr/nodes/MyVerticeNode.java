package datastr.nodes;

public class MyVerticeNode<T> {
	private T element;
	private MyEdgeNode firstEdgeNode = null;
	
	public T getElement() {
		return element;
	}
	
	public MyEdgeNode getFirstEdgeNode() {
		return firstEdgeNode;
	}
	
	public void setElement(T element) {
		if(element != null)
			this.element = element;
		else
			this.element = (T)new Object();
	}
	
	public void setFirstEdgeNode(MyEdgeNode firstEdgeNode) {
		this.firstEdgeNode = firstEdgeNode;
	}
	
	public MyVerticeNode(T element) {
		setElement(element);
	}
	
	public String toString() {
		return "" + element;
	}
}
