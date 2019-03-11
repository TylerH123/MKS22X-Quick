import java.util.*;
public class Quick{

  //swap 2 values of an array
  public static void swap(int[] arr, int a, int b){
    int old = arr[a];
    arr[a] = arr[b];
    arr[b] = old;
  }
  public static String toString(int[] arr){
    String output = "[";
    for (int i = 0; i < arr.length; i++){
      output += arr[i] + ", ";
    }
    output += "]";
    return output;
  }
  public static int quickselect(int[] data, int k){
    Random rand = new Random();
    //index of pivot value
    int pivot = rand.nextInt(data.length);
    System.out.println(pivot);
    System.out.println(data[pivot]);
    //swap pivot to the first number of index
    swap(data,0,pivot);
    System.out.println(toString(data));
    int start = 1;
    int end = data.length - 1;
    //base case
    if (start == end && start == k){
      return data[pivot];
    }
    while (start != end){
      if (data[start] > data[pivot]){
        swap(data,start, end);
        end--;
        System.out.println("swap to end" + toString(data));
      }
      if (data[start] < data[pivot]){
        start++;
      }
    }
    if (data[start] > data[pivot]){
      swap(data,0,start-1);
    }
    else{
      swap(data,0,start);
    }
    return quickselect(data, k);
  }
  public static void main(String[] args){
    int[] data = new int[]{9,19,8,1,12,99,10};
    System.out.println(quickselect(data,1));
  }
}
