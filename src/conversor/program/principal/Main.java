package conversor.program.principal;

import conversor.conexion.api.ConsultaExchangeRate;
import conversor.conexion.api.Moneda;
import conversor.conexion.api.MonedaGson;
import conversor.detalles.moneda.CaracteristicaMoneda;
import conversor.model.menu.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.cabecera();

        //Clase para crear la conexion al API
        ConsultaExchangeRate consulta = new ConsultaExchangeRate();
        Scanner lectura = new Scanner(System.in);

        int opcion=0;
        double valorConvertido;
        while(opcion!=7){
            opcion=menu.elegirOpciones(lectura);
            //Solo manejamos el RunTimeException por si hay alguna falla en la conexion con el API
            try{
                if(opcion>=1 && opcion<=6) {
                    //Clase para guardar los datos de la moneda, en especial, las siglas para el Map
                    CaracteristicaMoneda monedaCambio = new CaracteristicaMoneda();
                    monedaCambio.colocarDatos(opcion);

                    //La clase MonedaGson sirve para convertir el JSON a mi recod Moneda
                    MonedaGson monedaGson = new MonedaGson();

                    //Inicializamos Moneda para obtener lo datos del JSON
                    Moneda moneda = monedaGson.crearMonedaGson(consulta.buscarTipoDeCambio(monedaCambio.getBase()));

                    //Obtenemos el valor convertido con los datos obtenidos del JSON y del usuario
                    valorConvertido = monedaCambio.realizarConversion(moneda,menu.getValor());

                    //Impresión en consola
                    System.out.println("El valor " + menu.getValor() + " [" + monedaCambio.getBase() +"] " +
                            "corresponde al valor final de =>> " +
                            valorConvertido + " [" + monedaCambio.getDestino() + "]");
                    menu.separador("-");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
