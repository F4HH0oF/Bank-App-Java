import java.util.ArrayList;
import java.util.LinkedList;

public class Sortirane {

    static void smqna(ArrayList<Integer> list, int a, int b){
        list.set(b, list.get(a));
    }

    void InsertionSort(ArrayList<Integer> struktura){


        for(int i=1; i<struktura.size(); i++){
            int currentValue = struktura.get(i);
            int j= i-1;
            while(j>=0 && currentValue<struktura.get(j)){
                smqna(struktura, j, j+1);
                j--;
            }
            struktura.set(j+1, currentValue);
        }

        for(int i=0; i<struktura.size(); i++){
            System.out.print(struktura.get(i) +  ", ");
        }
    }

}

