public class linkedList<E> {

	protected int size;
	protected Node<E> head;

	public linkedList(){
		size=0;
		head=null;
	}

	public Node<E> gethead(){
		return head;
	}

	public int getsize(){
		return size;
	}

	public boolean isMem(E e){
		Node<E> x= this.gethead();
		int i=0;
		boolean flag=false;
		while(i<this.getsize()){
			if(x.getElement().equals(e)){
				flag = true;
				break;
			}
			i++;
			x=x.getNext();
		}
		return flag;
	}
	public void asdr(E e){
		Node<E> v = new Node<E>(e,head);
		head=v;
		size++;
	}
	public void addl(E e){
		Node<E> v = new Node<E>(e,null);
		if(this.getsize()==0){
			head=v;
			size++;
		}
		else{
			Node<E> x=this.gethead();
			while(x.getNext()!=null){
				x=x.getNext();
			}
			x.setNext(v);
			size++;
		}
	}

	public void delete(E e) throws Exception{
		boolean fl = false;
		if(this.getsize()==0)
			throw new Exception("trdfcxtrdfctrdcgdfdj");
		Node<E> x = head;
		int i=0;
		if(x.getElement()==e){
			head=x.getNext();
			x.setNext(null);
			size--;
			fl=true;}
		else	
			while(i<size-1){
				if((x.getNext()).getElement()==e){
					Node<E> v = x.getNext();
					x.setNext(v.getNext());
					v.setNext(null);
					size--;
					fl=true;
				}
				x=x.getNext();
				i++;
			}
		if(fl==false)
			throw new Exception("not found");
	}


} 