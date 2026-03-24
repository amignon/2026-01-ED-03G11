import java.util.Comparator;

public class FilaPrioridade<T> {
    private Deque<T> fila;
    private Comparator<T> comparator;

    public FilaPrioridade(Comparator<T> comparator) {
        this.fila = new Deque<>();
        this.comparator = comparator;
    }

    public void enqueue(T elemento) throws Exception {
        // Adicione seu código aqui...
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