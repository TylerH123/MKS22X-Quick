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
  public static int partition(int[] data, int start, int end){
    int pivot = (int)(Math.random() * (end - start + 1)) + start;
    //swap pivot to the first number of index
    if (pivot != start){
      swap(data,start,pivot);
      pivot = start;
      start++;
    }
    //System.out.println("partition first toString: " + Arrays.toString(data) + "lo: " + data[lo] + " loIdx: " + lo + " hi: " + data[hi] + " hiIdx: " + hi);
    while (start != end){
      //if val is bigger than pivot val then swap to hi and hi moves back
      if (data[start] > data[pivot]){
        swap(data,start, end);
        //System.out.println("partition toString: " + Arrays.toString(data) + "lo: " + data[lo] + " lo: " + lo + " hi: " + data[hi]);
        end--;
      }
      //if val is smaller than pivot val then do not swap, but instead lo moves forward
      else{
        start++;
        //System.out.println("partition toString: " + Arrays.toString(data) + "lo: " + data[lo] + " hi: " + data[hi]);
      }
    }
    //if the val is bigger than pivot val then swap with the value before it
    if (data[start] <= data[pivot]) {
     swap(data,pivot,start);
     pivot = start;
    }
    else {
     swap(data,pivot,start-1);
     pivot = start-1;
    }
    //return the index of lo val
    //System.out.println(Arrays.toString(data));
    return pivot;
  }
  public static void quicksort(int[] data){
    quicksort(data,0,data.length - 1);
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (lo >= hi) {
     return;
    }
    int pivot = partition(data, lo, hi);
    quicksort(data, lo, pivot-1);
    quicksort(data, pivot+1, hi);
  }
  public static void main(String[] args){
    //int[] data = new int[]{9,19,8,1,12,99,10};
    //int[] data2 = new int[]{1000,99,1881,1,10,12};
    //int[] ary = { 2, 10, 15, 23, 0,  5};
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
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST) {
      for(int size = 31250; size < 2000001; size*=2) {
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++) {
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)) {
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
