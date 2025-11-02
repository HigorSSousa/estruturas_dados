package br.edu.ifba.vdc.bsi.linkeddequedao.dao;

import br.edu.ifba.vdc.bsi.linkedstackdao.model.Car;
import java.time.LocalDateTime;

public interface CarDAOLinkedDEQue {
    // Operações básicas CRUD (Deque: inserção/removal início/fim)
    void addCarToFront(Car car);              // Adiciona carro no início da fila
    void addCarToRear(Car car);               // Adiciona carro no final da fila
    Car removeCarFromFront();                 // Remove carro do início da fila
    Car removeCarFromRear();                  // Remove carro do final da fila
    Car peekFrontCar();                       // Olha o carro no início sem remover
    Car peekRearCar();                        // Olha o carro no final sem remover
    Car[] getAllCars();                       // Retorna todos os carros no deque
    void updateCar(Car newCar);               // Atualiza um carro no deque
    Car removeCarByPlate(String plateLicense);// Remove carro específico
    void removeCarsByOwner(String owner);     // Remove carros de um dono
    void removeCarsOlderThan(LocalDateTime date); // Remove carros que chegaram antes de uma data

    // Operações de consulta específicas para carros
    Car getCarByLicensePlate(String licensePlate);
    Car[] getCarsByMark(String mark);
    Car[] getCarsByModel(String model);
    Car[] getCarsByColor(String color);
    Car[] getCarsByOwner(String owner);
    Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment);
    Car[] getCarsWithLongParking(long thresholdHours);
    long getAverageArrivalTime();

    // Operações de análise e estatísticas
    Car getCarByNewestArrival();
    Car getCarByOldestArrival();
    
    // Operações de relatório e estatísticas
    String printCars();
    int getTotalCars();
    String getMostPopularMark();
    String getMostPopularModel();
    String getMostPopularColor();
    long getParkingDuration(String plateLicense);
    Car[] getCarsByParkingDuration(long minHours, long maxHours);
    
    // Operações de gerenciamento
    boolean isCarInDeque(String plateLicense);
    void clearAllCars();

    // Capacidade do estacionamento
    int getAvailableSpaces();
    int getOccupancyRate();
    boolean isParkingFull();
    boolean isParkingEmpty();
    int getMaxCapacity();
}
