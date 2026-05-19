public class TestaDeque {
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new Deque<>();

        deque.enqueueLeft(1);
        deque.enqueueRight(2);
        deque.enqueueLeft(3);
        deque.enqueueRight(4);
        System.out.println(deque);
    }
}
