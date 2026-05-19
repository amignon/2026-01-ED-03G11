public class Deque <T>{
	
    private Node<T> inicio;
    private Node<T> fim;
	private	int quantidade;

	public	Deque() {
		this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
	}

	public boolean isEmpty( ) {
		return quantidade == 0;
	}

	public boolean isFull( ) {
		Node<T> tmp = new Node<>();
        return tmp == null;
	}

	public T getLeft ( ) throws Exception {
		if (! isEmpty( )){
		    return inicio.getDado();
		} else {
			throw new Exception("deque empty");
		} 		
	}
	
	public T getRight ( ) throws Exception {
		if (! isEmpty( )){
		    return fim.getDado();
		} else {
			throw new Exception("deque empty");
		} 
	}

	public void enqueueLeft ( T e ) throws Exception {
		if (! isFull( )){
		    Node<T> aux = new Node<T>(null, e, inicio);
            if (inicio != null) {
                inicio.setAnt(aux);
            }
			if (fim  == null) {
				fim  = aux;
			}
			inicio = aux;
			quantidade++;
		  } else 
			  throw new Exception("deque overflow");		
	}
	
	public void enqueueRight ( T e ) throws Exception {
		if (! isFull( )){
		    Node<T> aux = new Node<>(fim, e, null);
			if (fim != null) {
				fim.setProx(aux);
			} 
			if (inicio == null) {
				inicio = aux;
			}
			fim = aux;
			quantidade++;
		} else 
			throw new Exception("deque overflow");
		
	}
	
	public T dequeueLeft( ) throws Exception {
		T aux;
		if (! isEmpty( )){
		   aux = inicio.getDado();
		   inicio = inicio.getProx();
		   if (inicio != null) {
			inicio.getAnt().setProx(null); // opcional
			inicio.setAnt(null);
		   }
		   else {
			fim = null;
		   }
		   quantidade--;
		   return aux;
		}else{
			throw new Exception("deque underflow");
		}
	}	
	
	public T dequeueRight( ) throws Exception {
		  T aux;
		  if (! isEmpty( )){
		    aux = fim.getDado();
			fim = fim.getAnt();
			if (fim != null) {
				fim.getProx().setAnt(null); // opcional
				fim.setProx(null);
			}
			else {
				inicio = fim;
			}
		    quantidade--;
		    return aux;
		  }else{
			  throw new Exception("deque underflow");
		  } 		
	}	
	// Retorna o total de elementos
	// armazenados no deque
	public int size() {
		return quantidade;
	}
	
	@Override
	public String toString() {
	   try {
		StringBuilder sb = new StringBuilder();
		sb.append("[Deque] quantidade: ")
			.append(quantidade);
		if (quantidade != 0) {
			sb.append(", primeiro (Esquerda): ")
				.append(getLeft())
				.append(", último (Direita): ")
				.append(getRight());
		} 
		
		sb.append("\nConteudo do Deque: [ ");
		if (quantidade != 0) {
			Node<T> pAnda = inicio;
			while (pAnda != null) {
				sb.append(pAnda.getDado())
				.append(" ");
				pAnda = pAnda.getProx();
			}
		}
		sb.append(" ]");
		return sb.toString();
	   }catch(Exception e) {
		   return "Erro: " + e.getMessage();
	   }
	}
}
