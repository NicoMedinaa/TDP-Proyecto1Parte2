import java.util.logging.*;
import java.util.HashMap;
import java.util.Map;

public class DiGrafo{

	private Map<Integer, Integer> Nodos;
	private Map<String, Arco<Integer>> Arcos;
	private static Logger logger;
	
	@SuppressWarnings("static-access")
	public DiGrafo() {
		this.Nodos = new HashMap<Integer, Integer>();
		this.Arcos = new HashMap<String, Arco<Integer>>();	
		
		if (logger == null) {
			logger = logger.getLogger(DiGrafo.class.getName());
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
				}
			}
	}
	
	public void addNode(int node) {
		boolean esta = Nodos.containsKey(node);
		if(!esta) {
			Nodos.put(node, node);
			logger.info("El nodo " + node + " fue insertado correctamente.");
		}
		else
			logger.warning("No se pudo insertar el nodo " + node + " porque ya existe.");
	}

	public void addEdge(int node1, int node2) {
		boolean estaN1 = Nodos.containsKey(node1);
		boolean estaN2 = Nodos.containsKey(node2);
		
		if (estaN1 && estaN2) {
			Arco<Integer> edge = new Arco<Integer>(node1, node2);
			String key = node1 + "," + node2;
			Arco<Integer> value = Arcos.put(key, edge);
			if(value == null) {
				Arcos.put(key, edge);
				logger.info("Arco con los nodos " + node1+ " y " + node2 + " ingresado con exito");
			}
			else
				logger.warning("El arco con los nodos " + node1 + " y " + node2 + " no fue ingresado porque ya existe");
		}
		else
			logger.warning("No se pudo insertar el arco porque alguno, o los 2 nodos " + node1 + " y "+ node2+ " no existen");
	}

	public void removeNode(int node) {
		boolean esta = Nodos.containsKey(node);
		if(esta) {
			Nodos.remove(node);
			logger.info("Nodo " + node + " removido con exito");
		}
		else
			logger.warning("El nodo " + node + " no se pudo remover porque no existe");
	}

	public void removeEdge(int node1, int node2) {
		boolean estaN1 = Nodos.containsKey(node1);
		boolean estaN2 = Nodos.containsKey(node2);
		
		if(estaN1 && estaN2) {
			Arco<Integer> edge = new Arco<Integer>(node1, node2);
			String key = node1 + "," + node2;
			Arco<Integer> value = Arcos.put(key, edge);
			if (value != null) {
				Arcos.remove(key);
				logger.info("El arco con los nodos " + node1 + " y " + node2 + " fue removido con exito");
			}
			else
				logger.warning("El arco con los nodos " + node1 + " y " + node2 + " no se pudo remover porque no existe");
		}
		else 
			logger.warning("El arco no se pudo remover porque alguno, o los dos nodos " + node1 + " y " + node2 + " no existen");
	}

}
