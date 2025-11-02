package br.edu.ifba.vdc.bsi.linkedstackdao.dao;

import br.edu.ifba.vdc.bsi.linkedstackdao.dao.repository.Dequeable;
import br.edu.ifba.vdc.bsi.linkedstackdao.dao.repository.LinkedDeque;
import br.edu.ifba.vdc.bsi.linkedstackdao.model.Car;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CarDAOLinkedDeque implements CarDAO {

    private Dequeable<Car> cars = new LinkedDeque<>(20);

    // ---------------------- CRUD ----------------------

    @Override
    public void addCar(Car car) {
        if (isParkingFull()) throw new IllegalStateException("Estacionamento cheio!");
        cars.addLast(car); // adiciona no final da fila (ordem de chegada)
    }

    @Override
    public Car getCar(String plateLicense) {
        for (Car c : getAllCars()) {
            if (c.getPlateLicense().equalsIgnoreCase(plateLicense)) return c;
        }
        return null;
    }

    @Override
    public Car[] getAllCars() {
        List<Car> list = new ArrayList<>();
        Dequeable<Car> temp = new LinkedDeque<>(cars.getMaxCapacity());

        while (!cars.isEmpty()) {
            Car c = cars.removeFirst();
            list.add(c);
            temp.addLast(c);
        }

        while (!temp.isEmpty()) {
            cars.addLast(temp.removeFirst());
        }

        return list.toArray(new Car[0]);
    }

    @Override
    public void updateCar(Car newCar) {
        Dequeable<Car> temp = new LinkedDeque<>(cars.getMaxCapacity());
        boolean updated = false;

        while (!cars.isEmpty()) {
            Car c = cars.removeFirst();
            if (c.getPlateLicense().equalsIgnoreCase(newCar.getPlateLicense())) {
                temp.addLast(newCar);
                updated = true;
            } else {
                temp.addLast(c);
            }
        }

        while (!temp.isEmpty()) cars.addLast(temp.removeFirst());

        if (!updated) throw new IllegalArgumentException("Carro não encontrado: " + newCar.getPlateLicense());
    }

    @Override
    public Car deleteCar(String plateLicense) {
        Dequeable<Car> temp = new LinkedDeque<>(cars.getMaxCapacity());
        Car removed = null;

        while (!cars.isEmpty()) {
            Car c = cars.removeFirst();
            if (c.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                removed = c;
                break;
            } else {
                temp.addLast(c);
            }
        }

        while (!temp.isEmpty()) cars.addLast(temp.removeFirst());

        return removed;
    }

    // ---------------------- CONSULTAS ----------------------

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        return Arrays.stream(getAllCars())
                .filter(c -> c.getMark().equalsIgnoreCase(mark))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByModel(String model) {
        return Arrays.stream(getAllCars())
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        return Arrays.stream(getAllCars())
                .filter(c -> c.getColor().equalsIgnoreCase(color))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        return Arrays.stream(getAllCars())
                .filter(c -> c.getOwner().equalsIgnoreCase(owner))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        return Arrays.stream(getAllCars())
                .filter(c -> !c.getMomentArrival().isBefore(initialMoment) &&
                             !c.getMomentArrival().isAfter(finalMoment))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        LocalDateTime now = LocalDateTime.now();
        return Arrays.stream(getAllCars())
                .filter(c -> Duration.between(c.getMomentArrival(), now).toHours() >= thresholdHours)
                .toArray(Car[]::new);
    }

    // ---------------------- ANÁLISE ----------------------

    @Override
    public Car getCarByNewestArrival() {
        return Arrays.stream(getAllCars())
                .max(Comparator.comparing(Car::getMomentArrival))
                .orElse(null);
    }

    @Override
    public Car getCarByOldestArrival() {
        return Arrays.stream(getAllCars())
                .min(Comparator.comparing(Car::getMomentArrival))
                .orElse(null);
    }

    @Override
    public long getAverageArrivalTime() {
        Car[] all = getAllCars();
        if (all.length == 0) return 0;
        long total = 0;
        LocalDateTime now = LocalDateTime.now();
        for (Car c : all) total += Duration.between(c.getMomentArrival(), now).toHours();
        return total / all.length;
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car c = getCar(plateLicense);
        return (c == null) ? -1 : Duration.between(c.getMomentArrival(), LocalDateTime.now()).toHours();
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        LocalDateTime now = LocalDateTime.now();
        return Arrays.stream(getAllCars())
                .filter(c -> {
                    long h = Duration.between(c.getMomentArrival(), now).toHours();
                    return h >= minHours && h <= maxHours;
                })
                .toArray(Car[]::new);
    }

    // ---------------------- RELATÓRIOS ----------------------

    @Override
    public String printCars() {
        StringBuilder sb = new StringBuilder();
        for (Car c : getAllCars()) sb.append(c.toString()).append("\n");
        return sb.toString();
    }

    @Override
    public String getMostPopularMark() {
        return getMostFrequent(Arrays.stream(getAllCars()).map(Car::getMark).collect(Collectors.toList()));
    }

    @Override
    public String getMostPopularModel() {
        return getMostFrequent(Arrays.stream(getAllCars()).map(Car::getModel).collect(Collectors.toList()));
    }

    @Override
    public String getMostPopularColor() {
        return getMostFrequent(Arrays.stream(getAllCars()).map(Car::getColor).collect(Collectors.toList()));
    }

    private String getMostFrequent(List<String> list) {
        if (list.isEmpty()) return null;
        Map<String, Long> freq = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // ---------------------- GERENCIAMENTO ----------------------

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        return getCar(plateLicense) != null;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) cars.removeFirst();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        Dequeable<Car> temp = new LinkedDeque<>(cars.getMaxCapacity());
        while (!cars.isEmpty()) {
            Car c = cars.removeFirst();
            if (!c.getOwner().equalsIgnoreCase(owner)) temp.addLast(c);
        }
        while (!temp.isEmpty()) cars.addLast(temp.removeFirst());
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        Dequeable<Car> temp = new LinkedDeque<>(cars.getMaxCapacity());
        while (!cars.isEmpty()) {
            Car c = cars.removeFirst();
            if (!c.getMomentArrival().isBefore(date)) temp.addLast(c);
        }
        while (!temp.isEmpty()) cars.addLast(temp.removeFirst());
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public int getAvailableSpaces() {
        return cars.getMaxCapacity() - cars.size();
    }

    @Override
    public boolean isParkingFull() {
        return cars.size() == cars.getMaxCapacity();
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        return cars.getMaxCapacity();
    }

    @Override
    public int getOccupancyRate() {
        return (int) ((cars.size() / (double) cars.getMaxCapacity()) * 100);
    }
}
