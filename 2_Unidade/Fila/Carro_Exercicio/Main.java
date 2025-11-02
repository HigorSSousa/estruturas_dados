package ed.II_Unidade.pilha.exercicio_carro.dao;

import ed.II_Unidade.pilha.exercicio_carro.dao.CarDAO;
import ed.II_Unidade.pilha.exercicio_carro.dao.CarDAOLinkedDeque;
import ed.II_Unidade.pilha.exercicio_carro.model.Car;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // DAO usando LinkedDeque
        CarDAO dequeCar = new CarDAOLinkedDeque();

        // Adicionando carros ao deque (ordem de chegada: last)
        dequeCar.addCar(new Car("2006", "Chevrolet", "Prisma", "Branco", "Renan", LocalDateTime.now()));
        dequeCar.addCar(new Car("1665", "Kia", "Sorento", "Preto","Higor", LocalDateTime.now()));
        dequeCar.addCar(new Car("4689", "Honda", "Civic", "Branco","Erick", LocalDateTime.now()));

        // Imprime todos os carros
        System.out.println("Todos os carros:");
        System.out.println(dequeCar.printCars());
        System.out.println("Total de carros: " + dequeCar.getTotalCars());

        // Remove carros de um dono específico
        dequeCar.removeCarsByOwner("Erick");

        System.out.println("Após remover carros do Erick:");
        System.out.println(dequeCar.printCars());
        System.out.println("Total de carros: " + dequeCar.getTotalCars());
    }
}
