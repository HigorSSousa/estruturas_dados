package ed.II_Unidade.fila;
import java.util.NoSuchElementException;

public class LinkedDEque<T>{
    private int amount;
    private int capacity;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public LinkedDEque(){
        this(20);
    }

    public LinkedDEque(int length) {
        amount = 0;
        capacity = length;
        head = null;
        tail = null;
    }



    public boolean isEmpty(){
        return amount == 0;
    }

    public boolean isFull(){
        return amount == capacity;
    }

    public T front(){
        if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
        return head.getData();
    }

    public T beginDequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
        T auxData = head.getData();
        head = head.getNext();
        if(!isEmpty()){
            head.setPrevious(null);
        } else {
            tail = null;
        }

        return auxData;
    }

    public T endDequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
        amount--;
        T auxData = tail.getData();
        tail = tail.getPrevious();
        if(!isEmpty()){
            tail.setNext(null);
        } else{
            head = null;
        }

        return auxData;
    }

    public void beginEnqueue(T data){
        if(isFull()){
            throw new NoSuchElementException("Fila Cheia!");
        }
        DoubleNode<T> newNode = new DoubleNode<T>();
        newNode.setData(data);
        if(isEmpty()){
            tail = newNode;
            head = newNode;
        } else{
            newNode.setPrevious(head);
            head.setPrevious(newNode);
            head = head.getPrevious();
        }
        amount++;
    }

    public void endEnqueue(T data){
        if(isFull()){
            throw new NoSuchElementException("Fila Cheia!");
        }
        DoubleNode<T> newNode = new DoubleNode<T>();
        newNode.setData(data);
        if(isEmpty()){
            tail = newNode;
            head = newNode;
        } else{
            newNode.setPrevious(tail);
            tail.setNext(tail);
            tail = tail.getNext();
        }
        amount++;
    }

    public String printFrontToRear(){
        String result = "[";
        if(isEmpty()){
            result += "A pilha está vazia!";
        } else{
            DoubleNode<T> aux = head;
            for(int i = 0; i < amount; i++){
                result += aux.getData();
                if(i != amount - 1){
                    result += ", ";
                }
                aux = aux.getNext();
            }
            result += "]";
        }

        return result;
    }

    public String printRearToFront(){
        String result = "[";
        if(isEmpty()){
            result += "A pilha está vazia!";
        } else{
            DoubleNode<T> aux = tail;
            for(int i = 0; i < amount; i++){
                result += aux.getData();
                if(i != amount - 1){
                    result += ", ";
                }
                aux = aux.getPrevious();
            }
            result += "]";
        }

        return result;
    }
}
