
public class vertexNode {
	protected String name;
	protected linkedList<vertexNode> adjcntVrtces;
	protected int n;
	protected vertexNode previous;
	
	public vertexNode(String abc){
		name=abc;
		adjcntVrtces = new linkedList<vertexNode>();
	}
	
	public void setPrevious(vertexNode a){
		previous=a;
	}
	
	public vertexNode getPrevious(){
		return previous;
	}
	
	public void setD(int a){
		n=a;
	}
	
	public int getD(){
		return n;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public linkedList<vertexNode> getList(){
		return adjcntVrtces;
	}
	
	public String getName(){
		return name;
	}
}
