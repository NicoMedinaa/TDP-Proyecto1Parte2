
public class Arco<E>{

	private E predecesor, sucesor;
	
	public Arco(E pre, E suc) {
		predecesor = pre;
		sucesor = suc;
	}
	
	public void setPredecesor(E pre) {
		predecesor = pre;
	}

	public void setSucesor(E suc) {
		sucesor = suc;
	}
	
	public E getPredecesor() {
		return predecesor;
	}
	
	public E gerSucesor() {
		return sucesor;
	}
}
