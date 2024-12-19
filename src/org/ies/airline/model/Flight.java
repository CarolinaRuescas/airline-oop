package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private int getNumber;
    private Passenger[] passengers;

    public Flight(int flightNumber, String origin, String destination, int getNumber, Passenger[] passengers) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.getNumber = getNumber;
        this.passengers = passengers;
    }

    // Mostrar información

    public void showInfo() {
        System.out.println("Número de vuelo: " + flightNumber + " Origen: "
                + origin + "Destino: " + destination + "Puerta de embarque: " + getNumber + "Número de pasajeros:");
        for (var passenger : passengers) {
            passenger.showInfo();
        }
    }

    // Devuelve true si el pasajero está en el vuelo y false si no lo está

    public boolean hasPassenger(String nif) {
        for (var passenger : passengers) {
            if (passenger.getNif().equals(nif)){
                return true;
            }
        }
        return false;
    }

    // Busca el pasajero en el vuelo y lo devuelve, si no existe devuelve null

    public Passenger findPassenger(String nif) {
        for (var passenger : passengers) {
            if(passenger.getNif().equals(nif)){
                return passenger;
            }
        }
        return null;
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getGetNumber() {
        return getNumber;
    }

    public void setGetNumber(int getNumber) {
        this.getNumber = getNumber;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && getNumber == flight.getNumber && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.deepEquals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, origin, destination, getNumber, Arrays.hashCode(passengers));
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", getNumber=" + getNumber +
                ", passengers=" + Arrays.toString(passengers) +
                '}';
    }
}
