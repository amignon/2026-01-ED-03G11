import java.util.Comparator;
public class TestaFila {
    public static void main(String[] args) throws Exception {
        FilaPrioridade<Paciente> fila = new FilaPrioridade<>(
            Comparator.comparingInt(Paciente::getGravidade)
        );

        fila.enqueue(new Paciente("C", 2));
        fila.enqueue(new Paciente("A", 3));
        fila.enqueue(new Paciente("D", 1));
        fila.enqueue(new Paciente("B", 3));

        fila.enqueue(new Paciente("E", 2));

        while (!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }
    }
}