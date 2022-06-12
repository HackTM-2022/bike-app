package codes.razvan.hacktm.bikeapp.bikeapp;

import codes.razvan.hacktm.bikeapp.bikeapp.responses.PingResponse;

public interface Internet {

    PingResponse ping();

    PingResponse ping(String toString);
}
