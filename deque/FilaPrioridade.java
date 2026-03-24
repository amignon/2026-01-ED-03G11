import java.util.Comparator;

public class FilaPrioridade<T> {
    private Deque<T> fila;
    private Comparator<T> comparator;

    public FilaPrioridade(Comparator<T> comparator) {
        this.fila = new Deque<>();
        this.comparator = comparator;
    }

    public void enqueue(T elemento) throws Exception {
        if (fila.isEmpty()) {
            fila.enqueueLeft(elemento);
            return;
        }
        int tamanho = fila.size();
        int movidos = 0;
        while(movidos < tamanho 
            && comparator.compare(elemento, fila.getLeft()) <= 0) {
            fila.enqueueRight(fila.dequeueLeft());
            movidos++;
        }
        fila.enqueueRight(elemento);
        for (int i = 0; i < tamanho - movidos; i++) {
            fila.enqueueRight(fila.dequeueLeft());
        }
    }

    public T dequeue() throws Exception {
        if (fila.isEmpty()) {
            throw new Exception("Fila vazia.");
        }
        return fila.dequeueLeft();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}