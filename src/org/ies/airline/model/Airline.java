package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    // Mostrar información

    public void showInfo() {
        System.out.println("Nombre aerolinea: " + name + "Vuelos: ");
        for (var flight : flights) {
            flight.showInfo();
        }
    }

    // showFlightsFromOrigin(String origin)

    public void showFlightsFromOrigin(String origin) {
        for (var flight : flights) {
            if (flight.getOrigin().equals(origin)) {
                flight.showInfo();
            }
        }
    }

    // Busca el vuelo y lo devuelve, si no existe devuelve null

    public Flight findFlight(int flightNumber) {
        for (var flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    // Muestra todos los vuelos donde haya un pasajero con el nif del parámetro
    // utilizamos el hasPassenger porque tenemos un array de pasajeros, y tenemos que invocar el método
    // creado en Flight

    public void showPassengerFlights(String nif) {
        for (var flight : flights) {
            if (flight.hasPassenger(nif)) {
                flight.showInfo();
            }
        }
    }

    // Devuelve el asiento del pasajero en el vuelo, si no existe el vuelo o el pasajero, devuelve null

    public Integer getPassengerSeat(int flightNumber, String nif) {
        var flight = findFlight(flightNumber);  // esto se hace para guardar el vuelo

        if (flight != null){
            var passenger = flight.findPassenger(nif);
            if (passenger != null){
                return passenger.getSeatNumber();
            }
        }
        return null;
    }

    //  Busca el pasajero en el vuelo, si existe le cambia el asiento. Si no existe el vuelo
    //  o el pasajero muestra mensajes de error.

    public void updateSeatNumber(int flightNumber, String nif, int seatNumber){

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Objects.deepEquals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(flights));
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
