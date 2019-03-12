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
    for (int i = 0; i < arr.length-1; i++){
      output += arr[i] + ", ";
    }
    output += arr[arr.length-1] + "]";
    return output;
  }
  public static int generateMedian(int length){
    Random rand = new Random();
    int a = rand.nextInt(length);
    int b = rand.nextInt(length);
    int c = rand.nextInt(length);
    System.out.println(a + " " + b + " " + c);
    if (a <= b && b <= c ){
      return b;
    }
    if (b <= a  && a <= c ){
      return a;
    }
    else if (b <= c && c <= a){
      return c;
    }
    return -1;
  }
  public static int quickselect(int[] data, int k){
    int lo = 1;
    int hi = data.length - 1;
    int pivot = partition(data,lo,hi);
    System.out.println("toString" + toString(data));
    System.out.println("pivot: " + pivot);
    while(k != pivot) {
      //if k is less than pivot look from beginning to the pivot
      if (k < pivot){
        hi = pivot;
      }
      //else look at the hi loingg from pivot
      else if (k > pivot){
        lo = pivot;
      }
      pivot = partition(data,lo,hi);
      System.out.println(pivot);
      System.out.println("toString" + toString(data));
    }
    return data[k];
  }
  //chooses a pivot and reorders the array
  public static int partition(int[] data, int lo, int hi){
    Random rand = new Random();
    //index of pivot value
    int pivot = rand.nextInt(hi-lo+2);
    System.out.println("pivot #: " + pivot + " value: " + data[pivot]);
    //swap pivot to the first number of index
    swap(data,0,pivot);
    System.out.println("partition first toString: " + toString(data));
    while (lo != hi){
      //if val is bigger than pivot val then swap to hi and hi moves back
      if (data[lo] > data[0]){
        swap(data,lo, hi);
        hi--;
        System.out.println("partition toString: " + toString(data));
      }
      //if val is smaller than pivot val then do not swap, but instead lo moves forward
      if (data[lo] < data[0]){
        lo++;
        System.out.println("partition toString: " + toString(data));
      }
    }
    //if the val is bigger than pivot val then swap with the value before it
    if (data[lo] < data[0]){
      lo--;
    }
    swap(data,0,lo);
    //return the index of lo val
    return lo;
  }
  public static void main(String[] args){
    int[] data = new int[]{9,19,8,1,12,99,10};
    System.out.println(partition(data,1,6));
    //System.out.println("sorted: [1,8,9,10,12,19,99]");
    //System.out.println(quickselect(data,1));
    //System.out.println(toString(data));
    //System.out.println(generateMedian(7));
  }
}
