import java.util.*;
public class Quick{

  //swap 2 values of an array
  public static void swap(int[] arr, int a, int b){
    int old = arr[a];
    arr[a] = arr[b];
    arr[b] = old;
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
    int lo = 0;
    int hi = data.length - 1;
    //System.out.println("toString" + Arrays.toString(data));
    int idx = partition(data,lo,hi);
    while(k != idx) {
      //if k is less than pivot look from beginning to the pivot
      if (k < idx){
        hi = idx;
      }
      //else start at the pivot and go to the hi
      else if (k > idx){
        lo = idx;
      }
      idx = partition(data,lo,hi);
      //System.out.println("Index: " + idx + " k: " + k + " lo: " + lo + " hi:" + hi);
      //System.out.println("toString: " + Arrays.toString(data));
    }
    return data[k];
  }
  //chooses a pivot and reorders the array
  public static int partition(int[] data, int lo, int hi){
    Random rand = new Random();
    //index of pivot value
    int pivot = rand.nextInt(hi-lo+1) + lo;
    int pivotIdx = lo;
    //System.out.println("pivot #: " + pivot + " value: " + data[pivot]);
    //swap pivot to the first number of index
    swap(data,lo,pivot);
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
  public static void main(String[] args){
    int[] data = new int[]{9,19,8,1,12,99,10};
    int[] data2 = new int[]{1000,99,1881,1,10,12};
    int[] ary = { 2, 10, 15, 23, 0,  5};
    //System.out.println(partition(data,1,6));
    //System.out.println(quickselect(data,1));
    //System.out.println(quickselect(data,data.length-1));
    //System.out.println(quickselect(data,4));
    //System.out.println(Arrays.toString(data));
    System.out.println(quickselect(ary,0) == 0);
    System.out.println(quickselect(ary,1) == 2);
    System.out.println(quickselect(ary,2) == 5);
    System.out.println(quickselect(ary,3) == 10);
    System.out.println(quickselect(ary,4) == 15);
    System.out.println(quickselect(ary,5) == 23);
    //Arrays.sort(ary);
    //System.out.println(Arrays.toString(ary));
    //System.out.println(generateMedian(7));
  }
}
