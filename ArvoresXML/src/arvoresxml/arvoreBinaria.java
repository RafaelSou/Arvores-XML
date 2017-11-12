package no;
import java.util.Scanner;
public class NO {
    int valor; // valor da Árvore Binária.
    NO esquerda, direita; // Apontadores.
    
    public NO(int valor){ //construtor.
        this.valor = valor;
    }
    public static NO raiz; // Árvore.
    
    public static NO minimo(NO no){
	if(no != null){
            while(no.esquerda != null){
                no=no.esquerda;
            }
	}
	return no;
    }
    
    public static void inserir(int valor){
        inserir(raiz, valor);
    }
    public static void inserir(NO no, int valor){
        if(no == null){
            raiz = new NO(valor); // cria um NÓ raiz
        }else{
            if(valor < no.valor){
                if(no.esquerda != null){
                    inserir(no.esquerda, valor);
                }else no.esquerda = new NO(valor);
                
            }else{
                if(valor > no.valor){
                    if(no.direita != null){
                        inserir(no.direita, valor);
                    }else no.direita = new NO(valor);
                }
            }
        }
    }
     public static NO remover(NO no, int valor) {
        NO p, p2, r = null;
        if (no.valor == valor) {
            if (no.esquerda == no.direita) {
                return null;
            } else if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            } else {
                p2 = no.direita;
                p = no.direita;
                while (p.esquerda != null) {
                	r = p;
                    p = p.esquerda;
                }
                no.valor = p.valor;
                p = null;
                r.esquerda = null;
                return no;
            }
        } else if (no.valor < valor) {
            no.direita = remover(no.direita, valor);
        } else {
            no.esquerda = remover(no.esquerda, valor);
        }
        return no;
    }
    
    public static void pre_ordem(NO no) {
        System.out.print("<");
        if (no != null) {
            System.out.print(no.valor);
            pre_ordem(no.esquerda);
            pre_ordem(no.direita);
        }
        System.out.print(">");
    }
    public static void intra_ordem(NO no) {
        System.out.print("<");
        if (no != null) {
            pre_ordem(no.esquerda);
            System.out.print(no.valor);
            pre_ordem(no.direita);
        }
        System.out.print(">");
    }
    public static void pos_ordem(NO no) {
        System.out.print("<");
        if (no != null) {
            pos_ordem(no.esquerda);
            pos_ordem(no.direita);
            System.out.print(no.valor);
        }
        System.out.print(">");
    }
    public static int Menu(){
        Scanner entrada = new Scanner(System.in);
        int opc; 
        System.out.println("\n\n[[MENU]: Árvore-Binária]");
        System.out.println("1.Inserir NÓ...........:");
        System.out.println("2.Remover NÓ...........:");
        System.out.println("3.Imprimir Pré-Ordem...:");
        System.out.println("4.Imprimir intra-Ordem.:");
        System.out.println("5.Imprimir Pós-Ordem...:");
        System.out.println("0.Encerrar o Programa..:");
        System.out.print("-Opção:"); 
        opc = entrada.nextInt(); //Recebe os dados do usuário.
        return opc;
    }
    public static void Executar(){
        int x,aux;
        do{
            aux = Menu();
            
            switch(aux){
                case 1:
                    Scanner entrada = new Scanner(System.in);
                    System.out.print("-Informe o valor a se inserido:");
                    x = entrada.nextInt();
                    inserir(x);
                    break;
                case 2:
                    Scanner entr = new Scanner(System.in);
                    System.out.print("-Informe o valor a se removido:");
                    x = entr.nextInt();
                    remover(raiz,x);
                    break;
                case 3:
                    pre_ordem(raiz);
                    break;
                case 4:
                    intra_ordem(raiz);
                    break;
                case 5:
                    pos_ordem(raiz);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Comando Inválido... Tente novamente.");
                    break;
            } 
            System.out.println();
        }while(aux != 0);
    }
    
    public static void main(String[] args) {
        Executar();
    }
}   
