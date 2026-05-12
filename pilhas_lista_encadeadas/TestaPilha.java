public class TestaPilha {
    public static void main(String[] args) throws Exception {
        Pilha<String> p = new Pilha<>();
        p.push("A");
        p.push("B");
        p.push("C");
        p.exibe();
        while (!p.isEmpty()) {
            p.pop();
            p.exibe();
        }
    }
}