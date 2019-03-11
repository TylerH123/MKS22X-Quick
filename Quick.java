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
    return partition(data,0,data.length-1, k);
  }
  //recursive helper for quickselect
  public static int partition(int[] data, int start, int end, int index){
    Random rand = new Random();
    //index of pivot value
    int pivot = rand.nextInt(data.length);
    System.out.println(pivot);
    System.out.println(data[pivot]);
    //swap pivot to the first number of index
    swap(data,0,pivot);
    System.out.println(toString(data));
    //base case
    if (start == end){
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
      pivot = start-1;
    }
    else{
      swap(data,0,start);
      pivot = start;
    }
    if (pivot < index){
      return partition(data,start+1,end,index);
    }
    else{
      return partition(data,0,start-1,index);
    }
  }
  public static void main(String[] args){
    int[] data = new int[]{9,19,8,1,12,99,10};
    System.out.println(quickselect(data,1));
  }
}
