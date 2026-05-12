public class Pilha<T> {
    private Node<T> topo;

    public Pilha() {
        topo = null;
    }
 
    public boolean isFull() {
        Node<T> aux = new Node<T>();
        return aux == null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(T elemento) throws Exception {
        if (!isFull()) {
            Node<T> novoNo = new Node<T>(elemento, topo);
            topo = novoNo;
        }
        else {
            throw new Exception("Overflow - Pilha Cheia.");
        }
    }

    public T pop() throws Exception {
        if (!isEmpty()) {
            Node<T> aux = topo;
            topo = aux.getProx();
            return aux.getDado();
        }
        else {
            throw new Exception("Pilha Vazia.");
        }
    }

    public void exibe() {
        Node<T> pAnda = topo;
        while (pAnda != null) {
            System.out.print(pAnda.getDado() + " ");
            pAnda = pAnda.getProx();
        }
        System.out.println();
    }
}