
public class taxi {
	String src;
	int status;
	String name;
	
	public taxi(String source, String abc){
		src=source;
		status=0;
		name=abc;
	}
	
	public void setSource(String source){
		src=source;
	}
	
	public String getname(){
		return name;
	}
	
	public void setStatus(int stats){
		status = stats;
	}
	
	public String getSource(){
		return src;
	}
	
	public int getStatus(){
		return status;
	}
}
