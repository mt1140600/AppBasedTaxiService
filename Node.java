public class Node<E> {
	protected E element;
	protected Node<E> next;
	
	public Node(E elem, Node<E> node){
		element = elem;
		next = node;
	}
	
	public void setNext(Node<E> newn){
		next=newn;
	}
	
	public void setElement(E newe){
		element = newe;
	}
	
	public E getElement(){
		return element;
	}
	
	public Node<E> getNext(){
		return next;
	}
}
