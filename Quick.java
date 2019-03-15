import java.util.*;
public class Quick{

  //swap 2 values of an array
  public static void swap(int[] arr, int a, int b){
    int old = arr[a];
    arr[a] = arr[b];
    arr[b] = old;
  }
  public static int quickselect(int[] data, int k){
    int lo = 0;
    int hi = data.length - 1;
    //System.out.println("toString" + Arrays.toString(data));
    int pivot = partition(data,lo,hi);
    while(k != pivot) {
      //if k is less than pivot look from beginning to the pivot
      if (k < pivot){
        hi = pivot-1;
      }
      //else start at the pivot and go to the hi
      if (k > pivot){
        lo = pivot+1;
      }
      pivot = partition(data,lo,hi);
      //System.out.println("Index: " + idx + " k: " + k + " lo: " + lo + " hi:" + hi);
      //System.out.println("toString: " + Arrays.toString(data));
    }
    return data[k];
  }
  //partition
  public static int partition(int[] data, int lo, int hi){
    int pivotIdx = (int)(Math.random() * (hi - lo + 1)) + lo;
    //swap pivot to the first number of index
    swap(data,lo,pivotIdx);
    pivotIdx = lo;
    lo++;
    //System.out.println("partition first toString: " + Arrays.toString(data) + "lo: " + data[lo] + " loIdx: " + lo + " hi: " + data[hi] + " hiIdx: " + hi);
    while (lo != hi){
      //if val is bigger than pivot val then swap to hi and hi moves back
      if (data[lo] > data[pivotIdx]){
        swap(data,lo, hi);
        //System.out.println("partition toString: " + Arrays.toString(data) + "lo: " + data[lo] + " lo: " + lo + " hi: " + data[hi]);
        hi--;
      }
      //if val is smaller than pivot val then do not swap, but instead lo moves forward
      else if (data[lo] < data[pivotIdx]){
        lo++;
        //System.out.println("partition toString: " + Arrays.toString(data) + "lo: " + data[lo] + " hi: " + data[hi]);
      }
    }
    //if the val is bigger than pivot val then swap with the value before it
    if (data[lo] > data[pivotIdx]){
      lo--;
    }
    swap(data,pivotIdx,lo);
    //return the index of lo val
    //System.out.println(Arrays.toString(data));
    return lo;
  }
  public static void quicksort(int[] data){
    quicksort(data,0,data.length - 1);
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (lo <= hi){
      int pivot = partition(data,lo,hi);
      quicksort(data,lo,pivot-1);
      quicksort(data,pivot+1,lo);
    }
  }
  public static boolean test(int[] ary1, int[] ary2){
    Random rand = new Random();
    for (int i = 0; i < ary1.length; i++){
      int g = rand.nextInt();
      ary1[i] = g;
      ary2[i] = g;
    }
    quicksort(ary1,0,ary1.length-1);
    Arrays.sort(ary2);
    boolean g = true;
    for (int i = 0; i < ary1.length; i++){
      if (ary1[i] != ary2[i]){
        g = false;
      }
    }
    return g;
  }
  public static void main(String[] args){
    //int[] data = new int[]{9,19,8,1,12,99,10};
    //int[] data2 = new int[]{1000,99,1881,1,10,12};
    int[] ary = { 2, 10, 15, 23, 0,  5};
    //quicksort(ary,0,ary.length-1);
    /**Random rand = new Random();
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++){
      int g = rand.nextInt(20);
      arr[i] = g;
    }**/
    //System.out.println(Arrays.toString(arr));
    //quicksort(arr,0,arr.length-1);
    //System.out.println(Arrays.toString(arr));
    //System.out.println(Arrays.toString(ary));
    //System.out.println(partition(data,1,6));
    //System.out.println(quickselect(data,1));
    //System.out.println(quickselect(data,data.length-1));
    //System.out.println(quickselect(data,4));
    //System.out.println(Arrays.toString(data));
    //System.out.println(quickselect(ary,0) == 0);
    //System.out.println(quickselect(ary,1) == 2);
    //System.out.println(quickselect(ary,2) == 5);
    //System.out.println(quickselect(ary,3) == 10);
    //System.out.println(quickselect(ary,4) == 15);
    //System.out.println(quickselect(ary,5) == 23);
    //Arrays.sort(ary);
    //System.out.println(Arrays.toString(ary));
    //System.out.println(generateMedian(7));
  }
}
