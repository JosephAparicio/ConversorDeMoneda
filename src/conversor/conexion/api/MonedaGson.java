package conversor.conexion.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MonedaGson {
    private Moneda monedaGson;
    public MonedaGson() {
    }

    //Le decimos que se adapte a mi clase Moneda (record) por eso se devuelve un tipo Moneda
    public Moneda crearMonedaGson(String json){
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        monedaGson = gson.fromJson(json, Moneda.class);
        return monedaGson;
    }
}
