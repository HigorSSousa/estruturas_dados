package ed.II_Unidade.pilha.exercicio_carro.dao;

import ed.II_Unidade.pilha.exercicio_carro.model.Car;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CarDAOLinkedList implements CarDAO {

    private LinkedList<Car> cars = new LinkedList<>();
    private final int maxCapacity = 20; // capacidade máxima

    // ---------------------- CRUD ----------------------

    @Override
    public void addCar(Car car) {
        if (isParkingFull()) {
            throw new IllegalStateException("Estacionamento cheio!");
        }
        cars.addLast(car); // adiciona no final da lista
    }

    @Override
    public Car getCar(String plateLicense) {
        for (Car c : cars) {
            if (c.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Car[] getAllCars() {
        return cars.toArray(new Car[0]);
    }

    @Override
    public void updateCar(Car newCar) {
        ListIterator<Car> iterator = cars.listIterator();
        boolean updated = false;
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.getPlateLicense().equalsIgnoreCase(newCar.getPlateLicense())) {
                iterator.set(newCar);
                updated = true;
            }
        }
        if (!updated) {
            throw new IllegalArgumentException("Carro não encontrado: " + newCar.getPlateLicense());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                iterator.remove();
                return c;
            }
        }
        return null;
    }

    // ---------------------- CONSULTAS ----------------------

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        return cars.stream().filter(c -> c.getMark().equalsIgnoreCase(mark)).toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByModel(String model) {
        return cars.stream().filter(c -> c.getModel().equalsIgnoreCase(model)).toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        return cars.stream().filter(c -> c.getColor().equalsIgnoreCase(color)).toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        return cars.stream().filter(c -> c.getOwner().equalsIgnoreCase(owner)).toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        return cars.stream()
                .filter(c -> !c.getMomentArrival().isBefore(initialMoment) &&
                             !c.getMomentArrival().isAfter(finalMoment))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        LocalDateTime now = LocalDateTime.now();
        return cars.stream()
                .filter(c -> Duration.between(c.getMomentArrival(), now).toHours() >= thresholdHours)
                .toArray(Car[]::new);
    }

    // ---------------------- ANÁLISE ----------------------

    @Override
    public Car getCarByNewestArrival() {
        return cars.stream().max(Comparator.comparing(Car::getMomentArrival)).orElse(null);
    }

    @Override
    public Car getCarByOldestArrival() {
        return cars.stream().min(Comparator.comparing(Car::getMomentArrival)).orElse(null);
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()) return 0;
        LocalDateTime now = LocalDateTime.now();
        return (long) cars.stream()
                .mapToLong(c -> Duration.between(c.getMomentArrival(), now).toHours())
                .average().orElse(0);
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car c = getCar(plateLicense);
        return (c == null) ? -1 : Duration.between(c.getMomentArrival(), LocalDateTime.now()).toHours();
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        LocalDateTime now = LocalDateTime.now();
        return cars.stream()
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
        for (Car c : cars) sb.append(c.toString()).append("\n");
        return sb.toString();
    }

    @Override
    public String getMostPopularMark() {
        return getMostFrequent(cars.stream().map(Car::getMark).collect(Collectors.toList()));
    }

    @Override
    public String getMostPopularModel() {
        return getMostFrequent(cars.stream().map(Car::getModel).collect(Collectors.toList()));
    }

    @Override
    public String getMostPopularColor() {
        return getMostFrequent(cars.stream().map(Car::getColor).collect(Collectors.toList()));
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
        cars.clear();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        cars.removeIf(c -> c.getOwner().equalsIgnoreCase(owner));
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        cars.removeIf(c -> c.getMomentArrival().isBefore(date));
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public int getAvailableSpaces() {
        return maxCapacity - cars.size();
    }

    @Override
    public boolean isParkingFull() {
        return cars.size() >= maxCapacity;
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public int getOccupancyRate() {
        return (int) ((cars.size() / (double) maxCapacity) * 100);
    }
}
