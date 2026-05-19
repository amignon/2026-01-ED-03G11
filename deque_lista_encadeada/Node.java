public class Node <T>{
	private T dado; 
	private Node<T> prox; 
	private Node<T> ant;
	
	public Node() {
		this(null, null, null);
	}
	
	public Node(Node<T> ant, T dado, Node<T> prox) {
		this.dado = dado;
		this.prox = prox;
		this.ant = ant;
	}
    
	public Node<T> getAnt() { return ant; }

	public Node<T> getProx() { return prox; }

	public T getDado(){ return dado; }
	
	public void setAnt(Node<T> ant) { this.ant = ant; }

	public void setProx(Node<T> prox) { this.prox = prox; }

	public void setDado(T dado) { this.dado = dado;	}
}
