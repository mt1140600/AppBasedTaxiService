
public class TaxiService {
	protected MySet<taxi> taxies;
	protected graph city;
	public TaxiService() {
		taxies = new MySet<taxi>();
		city = new graph();
	}

	public graph getGraph(){
		return city;
	}

	public MySet<taxi> getTaxiSet(){
		return taxies;
	}

	public void performAction(String actionMessage)throws Exception {
		try{String[] action = actionMessage.split("\\s+");
		System.out.println("action to be performed :"+actionMessage);
		if(action[0].equals("edge")){
			this.getGraph().addEdge(action[1], action[2], Integer.valueOf(action[3]));
		}
		
		else if(action[0].equals("taxi")){
			this.addTaxi(action[1],action[2]);
		}
		
		else if(action[0].equals("customer")){
			this.customerRequest(action[1], action[2], Integer.valueOf(action[3]));
		}
		
		else if(action[0].equals("printTaxiPosition")){
			this.printTaxies(Integer.valueOf(action[1]));
		}}
		catch(Exception e){
			System.out.println("Invalid Input");
		}
	}

	public void customerRequest(String a, String b, int n)throws Exception{
		MySet<taxi> available = new MySet<taxi>();
		int i=0;
			for(;i<this.getTaxiSet().getSize();i++){
				if(this.getTaxiSet().getm(i).getStatus()==0||n>this.getTaxiSet().getm(i).getStatus())
					available.addElement(this.getTaxiSet().getm(i));
			}
			int j=0;
			int c=999999999;
			for(i=0;i<available.getSize();i++){
				if(this.getGraph().getShortestPathLength(a,available.getm(i).getSource())<c)
					j=i;
				c=Math.min(c,this.getGraph().getShortestPathLength(a,available.getm(i).getSource()));
				
			}
				System.out.println("Available Taxis:");
			for(i=0;i<available.getSize();i++){
				System.out.println("Path of taxi "+available.getm(i).getname()+" :"+" ");
				this.getGraph().getShortPath(available.getm(i).getSource(),a);
				System.out.print(".  time taken is "+this.getGraph().getShortestPathLength(available.getm(i).getSource(), a)+" units");System.out.println();
			}
			
			System.out.println("**choose taxi"+" "+available.getm(j).getname()+"to serve customer request**");
			System.out.println("Path of customer");
			this.getGraph().getShortPath(a, b);
			System.out.print("  "+"time taken is"+this.getGraph().getShortestPathLength(a,b)+" units");
			available.getm(j).setStatus(n+this.getGraph().getShortestPathLength(a, available.getm(j).getSource())+this.getGraph().getShortestPathLength(a,b));
			available.getm(j).setSource(b);
			System.out.println();
			System.out.println();
	}

	public void addTaxi(String name, String vertex)throws Exception{
			boolean flag=false;
			taxi abc = new taxi(vertex,name);
			Node <vertexNode> head1 = this.getGraph().getvertexList().gethead();
			while(head1!=null){
				if(head1.getElement().getName().equals(vertex))
					flag=true;
				head1=head1.getNext();
			}
			if(flag)
				this.getTaxiSet().addElement(abc);
			else
				throw new Exception(name+" vertex doesn't exists");
	}
	
	public void printTaxies(int n){
		MySet<taxi> available = new MySet<taxi>();
		int i=0;
			for(;i<this.getTaxiSet().getSize();i++){
				if(this.getTaxiSet().getm(i).getStatus()==0||n>this.getTaxiSet().getm(i).getStatus())
					available.addElement(this.getTaxiSet().getm(i));
			}
			for(i=0;i<available.getSize();i++){
				System.out.println(available.getm(i).getname()+"; "+available.getm(i).getSource());
			}
			System.out.println();
	}

}
