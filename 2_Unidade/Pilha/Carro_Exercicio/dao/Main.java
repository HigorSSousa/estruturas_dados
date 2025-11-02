package ed.II_Unidade.pilha.exercicio_carro.dao;
import ed.II_Unidade.pilha.Stackable;
import ed.II_Unidade.pilha.exercicio_carro.dao.CarDaoLinkedStack;
import ed.II_Unidade.pilha.exercicio_carro.dao.CarDAO;
import ed.II_Unidade.pilha.exercicio_carro.model.Car;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        CarDaoLinkedStack stackCar = new CarDaoLinkedStack();

        Car c1 = new Car("2006", "Chevrolet", "Prisma", "Branco", "Renan", LocalDateTime.now());
        stackCar.addCar(c1);

        Car c2 = new Car("1665", "Kia", "Sorento", "Preto","Higor", LocalDateTime.now());
        stackCar.addCar(c2);

        Car c3 = new Car("4689", "Honda", "Civic", "Branco","Erick", LocalDateTime.now());
        stackCar.addCar(c3);


        System.out.println(stackCar.printCars());
        System.out.println(stackCar.getTotalCars());

        stackCar.removeCarsByOwner("Erick");

        System.out.println(stackCar.printCars());
    }
}
