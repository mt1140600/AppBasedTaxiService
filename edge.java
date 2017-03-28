
public class edge {
	public String src;
	public String dest;
	public int n;
	
	public edge(String source, String destination, int length){
		src=source;
		dest=destination;
		n=length;
	}
	
	public int getLength(){
		return n;
	}
	
	public String getSrc(){
		return src;
	}
	
	public String getDestination(){
		return dest;
	}
}
