
public class MySet<X> {
	linkedList<X> li = new linkedList<X>();

	public boolean isEmpty(){
		return (li.getsize()==0);
	}

	public boolean isMember(X o){
		boolean fl = false;
		if(isEmpty())
			return fl;
		Node<X> a = li.gethead();
		int i=0;
		while(i<li.getsize()){
			if(a.getElement().equals(o)){
				fl=true;
				break;
			}
			else
				a=a.getNext();
			i++;
		}
		return fl;
	}

	public void addElement(X o){
		if(this.isMember(o)==false)
			li.addl(o);
	}

	public int getSize(){
		return li.getsize();
	}
	
	public void Delete(X o) throws Exception{
		if(this.isMember(o)!=true)
			throw new Exception(o+" is not in set");
		else
			li.delete(o);
		}
	public X getm(int i){
		Node<X> x = li.gethead();
		int j=0;
		while(j<i){
			x=x.getNext();j++;}
		return x.getElement();
	}
	public MySet<X> Union(MySet<X> a){
		MySet<X> uset = new MySet<X>();
		uset=a;
		Node<X> x = li.gethead();
		int i=0;
		while(i++<li.getsize()){
			uset.addElement(x.getElement());
			x=x.getNext();
		}
		return uset;
	}

	public MySet<X> Intersection(MySet<X> a){
		MySet<X> inset = new MySet<X>();
		Node<X> x = li.gethead();
		int i=0;
		while(i++<li.getsize()){
			if(a.isMember(x.getElement())){
				inset.addElement(x.getElement());
			}
			x=x.getNext();
		}
		return inset;}

}
