package codes.razvan.hacktm.bikeapp.bikeapp.request;

import codes.razvan.hacktm.bikeapp.bikeapp.HelloApplication;
import codes.razvan.hacktm.bikeapp.bikeapp.TokenPersister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class BikeFormRequest {

    //    @NonNull
    private String bike_secret;
    private String bike_code;
    private double lat = 45.7975, lon = 21.2541;
    private double battery = 2.5;

    public BikeFormRequest setBikeSecret(String bike_secret) {
        this.bike_secret = bike_secret;
        return this;
    }

    public BikeFormRequest setLatitude(double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        lon += HelloApplication.randomDouble(0.00001, 0.0001) * (HelloApplication.randomInt(0, 1) == 0 ? -1 : 1);
        return lon;
    }

    public double getLat() {
        lat += HelloApplication.randomDouble(0.00001, 0.0001) * (HelloApplication.randomInt(0, 1) == 0 ? -1 : 1);
        return lat;
    }

    public BikeFormRequest setLongitude(double lon) {
        this.lon = lon;
        return this;
    }

    public double getBattery() {
        this.battery += HelloApplication.randomDouble(0.005, 0.01);
        if (this.battery > 4.2) this.battery = 4.2;
        return battery;
    }

    public BikeFormRequest setBattery(double battery) {
        this.battery = battery;
        return this;
    }

    public BikeFormRequest setBikeCode(String code) {
        this.bike_code = code;
        return this;
    }

    public String getBike_secret() {
        return TokenPersister.token;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> local = new HashMap<>();

        local.put("bike_secret", TokenPersister.token);
        if (bike_code != null) local.put("bike_code", bike_code);
        local.put("lat", getLat() + "");
        local.put("lon", getLon() + "");
        local.put("battery", getBattery());

        return local;
    }
}
