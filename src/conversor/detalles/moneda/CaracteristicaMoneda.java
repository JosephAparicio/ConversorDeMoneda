package conversor.detalles.moneda;

import conversor.conexion.api.Moneda;
import conversor.conexion.api.MonedaGson;

import java.util.Map;

public class CaracteristicaMoneda {
    private String base;
    private String destino;
    private Map<String, Double>conversiones;

    public CaracteristicaMoneda() {
    }

    public String getDestino() {
        return destino;
    }

    private void setDestino(String destino) {
        this.destino = destino;
    }

    public String getBase() {
        return base;
    }

    private void setBase(String base) {
        this.base = base;
    }

    public void colocarDatos(int opcion){
        if(opcion == 1){
            setBase("USD");
            setDestino("ARS");
        }else if(opcion == 2){
            setBase("ARS");
            setDestino("USD");
        }else if(opcion == 3){
            setBase("USD");
            setDestino("BRL");
        }else if(opcion == 4){
            setBase("BRL");
            setDestino("USD");
        }else if(opcion == 5){
            setBase("USD");
            setDestino("COP");
        }else if(opcion == 6){
            setBase("COP");
            setDestino("USD");
        }
    }

    public double realizarConversion(Moneda monedaRecord, double valor){
        conversiones = monedaRecord.conversion_rates();
        double valorDeCambio = conversiones.get(destino);
        return valor * valorDeCambio;
    }
}
