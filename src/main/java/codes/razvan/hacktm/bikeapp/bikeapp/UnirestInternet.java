package codes.razvan.hacktm.bikeapp.bikeapp;

import codes.razvan.hacktm.bikeapp.bikeapp.request.BikeFormRequest;
import codes.razvan.hacktm.bikeapp.bikeapp.responses.PingResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;

public class UnirestInternet implements Internet {
    public static final String URL = "https://hacktm.mindhive.ro/";
    public static ObjectMapper mapper = new ObjectMapper();


    @Override
    @SneakyThrows
    public PingResponse ping() {
        HttpResponse<String> response;

        try {
            BikeFormRequest request = new BikeFormRequest().setBattery(2.5);
            response = Unirest
                    .post(URL + "bike-ping/")
                    .header("Content-type", "application/x-www-form-urlencoded")
                    .fields(request.toMap())
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
            System.err.println("Failed to GET data. Connection string was: " + URL);
            return null;
        }

        return mapper.readValue(response.getBody(), PingResponse.class);
    }

    @Override
    @SneakyThrows
    public PingResponse ping(String token) {
        HttpResponse<String> response;

        BikeFormRequest request = new BikeFormRequest().setBikeCode(token).setBattery(2.5);
        try {
            response = Unirest
                    .post(URL + "bike-ping/")
                    .header("Content-type", "application/x-www-form-urlencoded")
                    .fields(request.toMap())
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
            System.err.println("Failed to GET data. Connection string was: " + URL);
            return null;
        }

        return mapper.readValue(response.getBody(), PingResponse.class);
    }
}
