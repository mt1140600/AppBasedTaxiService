
public class graph {
	protected linkedList<edge> edgeList;
	protected linkedList<vertexNode> vertexList;
	
	public graph(){
		edgeList = new linkedList<edge>();
		vertexList = new linkedList<vertexNode>();
	}
	
	public void addVertex(String nameOfVertex){
		vertexNode vertex = new vertexNode(nameOfVertex);
		vertexList.addl(vertex);
	}
	
	public linkedList<vertexNode> getvertexList(){
		return vertexList;
	}
	
	public linkedList<edge> getedgeList(){
		return edgeList;
	}
	
	public void addEdge(String source, String destination, int length){
		int flag1 = 0;
		int flag2 = 0;
		Node<vertexNode> v1 = vertexList.gethead();
		while(v1!=null){
			vertexNode x = v1.getElement();
			if(x.getName().equals(source))
				{flag1=1;break;}
			v1=v1.getNext();
		}

		Node<vertexNode> v2 = vertexList.gethead();
		while(v2!=null){
			vertexNode x = v2.getElement();
			if(x.getName().equals(destination))
				{flag2=1;break;}
			v2=v2.getNext();
		}
		if(flag1==0)
			this.addVertex(source);
		if(flag2==0)
			this.addVertex(destination);
		this.find(source).getList().addl(this.find(destination));
		this.find(destination).getList().addl(this.find(source));
	
		
		edge Edge = new edge(source,destination,length);
		edgeList.addl(Edge);
		
	}
	
	public void printGraph(){
		Node<edge> head1 = this.getedgeList().gethead();
		while(head1!=null){
			edge ed = head1.getElement();
				System.out.println(ed.getSrc()+" is connected to "+ed.getDestination()+" path length "+ed.getLength());
				head1=head1.getNext();
			}
	}
	
	public edge findEdge(String source, String destination){
		Node<edge> head1 = this.getedgeList().gethead();
		while(head1!=null){
			edge Edge = (edge)head1.getElement();
			if((Edge.getSrc().equals(source)&&Edge.getDestination().equals(destination))||(Edge.getSrc().equals(destination)&&Edge.getDestination().equals(source)))
				return Edge;
			head1=head1.getNext();
		}
		return null;
	}
	
	public vertexNode find(String a){
		Node<vertexNode> v4 = this.getvertexList().gethead();
		vertexNode x = v4.getElement();
		while(v4!=null){
			 x = v4.getElement();
			if(x.getName().equals(a))
				{return x;}
			v4=v4.getNext();
		}return null;
	}
	
	
	
	public void findShortestPath(String abcd)throws Exception{
		MySet<vertexNode> abc = new MySet<vertexNode>();
		Node<vertexNode> head1 = this.getvertexList().gethead();
		while(head1!=null){
			vertexNode x = head1.getElement();
			x.setD(999999999);
			x.setPrevious(null);
			abc.addElement(x);
			
			head1=head1.getNext();
		}
		
		this.find(abcd).setD(0);

		while(abc.getSize()!=0){
			int z=999999999;
			for(int i=0;i<abc.getSize();i++){
				z=Math.min(z, abc.getm(i).getD());
			}
			vertexNode x = abc.getm(0);
			
			for(int j=0;j<abc.getSize();j++){
				x=abc.getm(j);
	
				if(x.getD()==z){
					break;}
			}
			
		abc.Delete(x);
		
		Node<vertexNode> head4 = x.getList().gethead();
		while(head4!=null){
			vertexNode ce = head4.getElement();
			if(ce.getName().equals(x.getName()))
				continue;

			int d = x.getD()+this.findEdge(x.getName(),ce.getName()).getLength();
			if(d<ce.getD()){
				ce.setD(d);
				ce.setPrevious(x);
			}
			head4=head4.getNext();
		}
	}
	
	}
	
	public int getShortestPathLength(String a, String b)throws Exception{
		this.findShortestPath(a);
		return this.find(b).getD();
	}
	
	public void getShortPath(String a, String b)throws Exception{
		if(a.equals(b))
			System.out.print(a);
		else{
		linkedList<edge> path = new linkedList<edge>();
		this.findShortestPath(a);
		vertexNode x = this.find(b);
		while(x.getPrevious()!=null){
			edge E = new edge(x.getPrevious().getName(),x.getName(),0);
			path.addl(E);
			x=x.getPrevious();
		}
		linkedList<edge> path1 = new linkedList<edge>();
		Node<edge> asdf = path.gethead();
		while(asdf!=null){
			path1.asdr(asdf.getElement());
			asdf=asdf.getNext();
		}
		Node<edge> asd = path1.gethead();
		System.out.print(asd.getElement().getSrc()+" ,");
		while(asd!=null){
			System.out.print(asd.getElement().getDestination()+" ,");
			asd=asd.getNext();
		}
	}}
		
	
}

