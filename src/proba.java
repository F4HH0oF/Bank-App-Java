import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class proba{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Sortirane obekt = new Sortirane();
        System.out.print("Broi chisla: ");
        int j = input.nextInt();
        MyArrayList<Integer> ime= new MyArrayList<>();
        for(int i=0; i<j; i++){
            int k=i+1;
            System.out.print("Vuvedi element nomer "+ k +"-");
            int n = input.nextInt();
            ime.add(n);
        }
        obekt.InsertionSort(ime);
    }
}