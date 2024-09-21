package conversor.model.menu;

import java.util.Scanner;

public class Menu {
    private static final int n = 50;
    private double valor;
    public Menu() {
    }

    public double getValor() {
        return valor;
    }

    private void setValor(double valor) {
        this.valor = valor;
    }

    public void cabecera(){
        separador("*");
        System.out.println("Sea bienvenido/a al Conversor de Moneda :)");
        separador("-");
    }

    public void separador(String car){
        for(int i=0; i<n; i++) System.out.print(car);
        System.out.println();
    }

    public int elegirOpciones(Scanner lectura){
        mostrarMenu();
        int num = lectura.nextInt();
        if(num>7 || num<0){
            System.out.println("Elija una opción válida entre el 1 y el 6. Si desea salir, escoja el 7");
            return 0;
        }
        if(num==7){
            System.out.println("Gracias por elegirnos!");
            return num;
        }else{
            separador("-");
            System.out.println("Ingrese el valor que desea convertir");
            valor = lectura.nextDouble();
            return num;
        }
    }

    private void mostrarMenu(){
        String cadena = "A continuación nuestras opciones, ingrese un número..." + "\n";
        String menu = """
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                """;
        System.out.println(cadena + menu);
    }
}
