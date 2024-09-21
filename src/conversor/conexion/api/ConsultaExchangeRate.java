package conversor.conexion.api;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaExchangeRate {
    public String buscarTipoDeCambio(String tipoMoneda){
        String APIKEY = "61180fb4e08722dad8eceb43";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/latest/" + tipoMoneda);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String>response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;
        } catch (Exception e) {
            throw new RuntimeException("No existe tipo de cambio para esa moneda.");
        }
    }
}
