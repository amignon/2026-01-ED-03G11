import java.util.Scanner;
public class BalanceamentoParenteses {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Expressão: ");
        String expressao = entrada.nextLine();
        if (estaBalanceada(expressao)) {
            System.out.println("Os parenteses estão balanceados.");
        }
        else {
            System.out.println("Os parenteses não estão balanceados.");
        }
    }
 
    public static boolean estaBalanceada(String expressao) {
        Pilha<Character> p = new Pilha<Character>();
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            try {
                if (c == '(') {
                    p.push(c);
                }
                else if (c == ')') {
                    if (!p.isEmpty()) {
                        p.pop();
                    }
                    else {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return p.isEmpty();
    }
}