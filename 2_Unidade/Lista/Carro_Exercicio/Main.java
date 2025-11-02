package ed.II_Unidade.pilha.exercicio_carro.dao;

import ed.II_Unidade.pilha.exercicio_carro.dao.CarDAO;
import ed.II_Unidade.pilha.exercicio_carro.dao.CarDAOLinkedList;
import ed.II_Unidade.pilha.exercicio_carro.model.Car;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // DAO usando LinkedList
        CarDAO listCar = new CarDAOLinkedList();

        // Adicionando carros à lista (ordem de chegada)
        listCar.addCar(new Car("2006", "Chevrolet", "Prisma", "Branco", "Renan", LocalDateTime.now()));
        listCar.addCar(new Car("1665", "Kia", "Sorento", "Preto","Higor", LocalDateTime.now()));
        listCar.addCar(new Car("4689", "Honda", "Civic", "Branco","Erick", LocalDateTime.now()));

        // Imprime todos os carros
        System.out.println("Todos os carros:");
        System.out.println(listCar.printCars());
        System.out.println("Total de carros: " + listCar.getTotalCars());

        // Remove carros de um dono específico
        listCar.removeCarsByOwner("Erick");

        System.out.println("Após remover carros do Erick:");
        System.out.println(listCar.printCars());
        System.out.println("Total de carros: " + listCar.getTotalCars());
    }
}
