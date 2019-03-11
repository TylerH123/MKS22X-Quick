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
    int start = 0;
    int end = data.length - 1;
    while(true){
      int pivot = partition(data,start,end,end-start + 1);
      //if pivot equals k then return the num at k
      if (k == pivot){
        return data[k];
      }
      //if k is less than pivot look from beginning to the pivot
      if (k < pivot){
        end = pivot;
      }
      //else look at the end startingg from pivot
      else{
        start = pivot;
      }
    }
  }
  //chooses a pivot and reorders the array
  public static int partition(int[] data, int start, int end, int length){
    Random rand = new Random();
    //index of pivot value
    int pivot = rand.nextInt(length);
    //swap pivot to the first number of index
    swap(data,0,pivot);
    while (start != end){
      //if val is bigger than pivot val then swap to end and end moves back
      if (data[start] > data[pivot]){
        swap(data,start, end);
        end--;
      }
      //if val is smaller than pivot val then do not swap, but instead start moves forward
      if (data[start] < data[pivot]){
        start++;
      }
    }
    //if the val is bigger than pivot val then swap with the value before it
    if (data[start] < data[pivot]){
      start--;
    }
    swap(data,start,pivot);
    //return the index of start val
    return start;
  }
  public static void main(String[] args){
    int[] data = new int[]{9,19,8,1,12,99,10};
    System.out.println(quickselect(data,1));
    System.out.print(toString(data));
  }
}
