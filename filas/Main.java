/**
 * Suponha duas filas circulares chamadas qpar e qimpar e uma pilha s. 
 * Considere que as três estruturas são representadas por vetores com, 
 * no máximo, 30 elementos. Solicita-se o desenvolvimento de um algoritmo 
 * que lê uma sequência indeterminada de valores inteiros. 
 * Assumir que o valor zero finaliza a entrada de dados. 
 * Em seguida, deve ser determinado se um número lido é par ou ímpar. 
 * Se o número for par, devemos colocá-lo na fila qpar; caso contrário, 
 * na fila qímpar. Logo após a entrada do valor zero, alternadamente 
 * (começando-se pela fila qímpar), devemos retirar um elemento de cada 
 * fila até o momento em que ambas tornam-se vazias. 
 * Se o elemento retirado de uma das filas for um valor positivo, 
 * devemos colocá-lo na pilha s; caso contrário, 
 * removemos um elemento da pilha s.  Quando finalizarmos esse processo, 
 * devemos exibir todo o conteúdo da pilha s.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Fila<Integer> filaPar = new Fila<Integer>(30);
        Fila<Integer> filaImpar = new Fila<Integer>(30);
        Pilha<Integer> pilha = new Pilha<Integer>(30);

        int numero;
        do {
            System.out.print("Número: ");
            numero = entrada.nextInt();
            if (numero != 0) {
                if (numero % 2 == 0) {
                    filaPar.enqueue(numero);
                }
                else {
                    filaImpar.enqueue(numero);
                }
            }
        } while (numero != 0);

        boolean vezImpar = true;
        Integer valor;
        while (!filaImpar.isEmpty() && !filaPar.isEmpty()) {
            if (vezImpar)
                valor = filaImpar.dequeue();
            else
                valor = filaPar.dequeue();
            if (valor > 0) {
                pilha.push(valor);
            }
            else {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                }
            }
            vezImpar = !vezImpar;
        }

        while (!filaImpar.isEmpty()) {
            valor = filaImpar.dequeue();
            if (valor > 0) {
                pilha.push(valor);
            }
            else {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                }
            }
        }

        while (!filaPar.isEmpty()) {
            valor = filaPar.dequeue();
            if (valor > 0) {
                pilha.push(valor);
            }
            else {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                }
            }
        }

        while (!pilha.isEmpty()) {
            valor = pilha.pop();
            System.out.println(valor);
        }

        entrada.close();
    }
}