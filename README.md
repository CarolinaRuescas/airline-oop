# Airline

Crea una aplicación que sirva para gestionar los vuelos de una aerolínea.

## POJOs

### Airline

Campos:
- Nombre
- Array de vuelos.

metodos:
- showFlights()
- showFlightsFromOrigin(String origin)
- findFlight(int flightNumber): busca el vuelo y lo devuelve, si no existe devuelve null 
- showPassengerFlights(String nif): muestra todos los vuelos donde haya un pasajero con el nif del parámetro 
- getPassengerSeat(int flightNumber, String nif): Devuelve el asiento del pasajero en el vuelo, 
  si no existe el vuelo o el pasajero, devuelve null 
- updateSeatNumber(int flightNumber, String nif, int seatNumber): busca el pasajero en el vuelo, 
  si existe le cambia el asiento. Si no existe el vuelo o el pasajero muestra mensajes de error.

### Flight

Campos:
- flightNumber: int
- origin
- destination
- gateNumber (puerta de embarque): int
- pasajeros

métodos:
- showInfo()
- hasPassenger(String nif): devuelve true si el pasajero está en el vuelo y false si no lo está 
- findPassenger(String nif): busca el pasajero en el vuelo y lo devuelve, si no existe devuelve null

### Passenger 

Campos:
- NIF
- name
- surname
- seatNumber: Integer (con mayúsculas para que pueda ser null)

métodos:
- showInfo()

## Componentes

### Readers

Crea readers para todos los beans

### AirlineApp1


Tendrá un método run() que realice los siguiente:
- Pide los datos de la aerolínea
- Pide al usuario un número de vuelo
- Busca el vuelo con ese número de vuelo
    - Si no existe muestra por pantalla un error
    - Si existe:
        - Pide al usuario un pasajero.
        - Busca a ese pasajero dentro del vuelo:
            - Si existe:
                - Muestra los datos del pasajero
                - Pide un número de asiento
                - Cambia el asiento del pasajeor
            - Si no existe muestra un mensaje de error

### AirlineAppMenu

Tendrá un método run() que realice los siguiente:
- Pide los datos de la aerolínea
- Inicia un bucle de menú con las siguientes opciones
    1. Muestra todos los vuelos
    2. Mostrar vuelos origen:
       - Pide un origen al usuario y muestra todos los vuelos que tengan ese origen
    3. Muestra los vuelos de un pasajero:
        - Se pide un nif
        - Se recorren los vuelos comprobando si alguno de sus pasajeros tiene el NIF. 
    4. Muestra asiento de pasajero
        - Se pide un flightNumber
        - Se pide un NIF
        - Se busca el vuelo y el pasajero:
          - Si no existe el vuelo se muestra "El vuelo no existe"
          - Si no se encuentra el pasajero en el vuelo se muestra "El pasajero no está registrado en el vuelo"
          - Si se encuentra el pasajero se muestra "El asiento asignado es <seatNumber>"
    5. Cambiar asiento de pasajero
        - Se pide un flightNumber
        - Se pide un NIF
        - Se pide un seatNumber (Integer)
        - Se busca el vuelo y el pasajero:
            - Si no existe el vuelo se muestra "El vuelo no existe"
            - Si no se encuentra el pasajero en el vuelo se muestra "El pasajero no está registrado en el vuelo"
            - Si se encuentra el pasajero se le cambia el asiento y se muestra el mensaje "Asiento asignado"
