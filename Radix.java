import java.util.*;
public class Radix{

  public static void radixsort(int[] data){
    MyLinkedList[] bucket = new MyLinkedList[10];
    craftBucket(bucket);
    int count = biggest(data);
    int place = 0;
    while(count != 0){
      fillBucket(data,bucket,place);
      takeWater(data,bucket);
      place++;
      count--;
    }
    lastfill(data,bucket);
    lastBucket(data,bucket);
  }

  public static void Radixsort(int[] data){
    MyLinkedList[] bucket = new MyLinkedList[10];
    craftBucket(bucket);
    int count = biggest(data);
    fillBucket(data,bucket,0);
    int place = 1;
    while(count != 0){
      substitute(bucket);
      count--;
    }
  }

  private static void substitute(MyLinkedList[] bucket){

  }

  public static String printArray(int[] ary) {
  String result = "[";
  for (int i = 0; i < ary.length ; i++) {
  result += " " + ary[i];
  if (i != ary.length - 1) {
    result += ",";
  }
  }
  return result + "]";
  }

  private static void lastfill(int[] data, MyLinkedList[] bucket){
    for(int i = 0; i < data.length; i++){
      if(data[i] >= 0){bucket[0].add(data[i]);}
      else{bucket[0].add(0,data[i]);}
    }
  }

  private static void lastBucket(int[] data, MyLinkedList[] bucket){
    for(int i = 0; i < data.length; i++){
      data[i] = bucket[0].removeFront();
    }
  }

  public static void takeWater(int[] data, MyLinkedList[] bucket){
    int counter = 0;
    for(int i = 0; i < 10; i++){
      int num = bucket[i].size();
      for(int j = 0; j < num; j++){
        data[counter] = bucket[i].removeFront();
        counter++;
      }
    }
}

  private static void concentrate(MyLinkedList[] bucket){
    for(int i = 1; i < 10; i++){
      for(int j = 0; j < bucket[i].size(); j++){
        int num = bucket[i].removeLast();
        if(num >= 0){bucket[0].add(num);}    // Finish remove and improve this area, then clearBucket becomes irrelivent
        else{bucket[0].add(0,num);}
      }
    }
  }

  public static String toStringBucket(MyLinkedList[] bucket){
    String result = "";
    int max = 0;
    for(int i = 0; i < 10; i++){
        int count = bucket[i].size();
        if(count > max){max = count;}
    }
    for(int i = 0; i < max; i++){
      for(int j = 0; j < 10; j++){
        try{
        result += bucket[j].get(i) + "  ";
      }catch(IndexOutOfBoundsException e){
        result += "__  ";
      }catch(NullPointerException e){
        result += "__  ";
      }
      }
      result += "\n";
    }
    return result;
  }

  private static void craftBucket(MyLinkedList[] bucket){
    for(int i = 0; i < 10; i++){
      bucket[i] = new MyLinkedList();
    }
  }

  private static void clearBucket(int point, MyLinkedList[] bucket){
    for(int i = point; i < 10; i++){
      bucket[i].clear();
    }
  }

  private static void fillBucket(int[] data, MyLinkedList[] bucket, int place){
    for(int i = 0; i < data.length; i++){
      int digit = Math.abs(getDigit(data,i,place));
      bucket[digit].add(data[i]);
  }
  }

  private static int biggest(int[] data){
    int max = 0;
    for(int num: data){
      int test = num;
      int count = 0;
      while(test != 0){
        count++;
        test = test / 10;
      }
      if(count > max){max = count;}
    }
    return max;
  }

  private static int getDigit(int[] data, int index, int place){
    int num = data[index];
    if(place > 0){num = num / (10*(place+1));}
    return num % 10;
  }

  public static void main(String args[]){
    int[] test = new int[]{10,11,-645,12,13,14,-7557,-291,15,16,17,18,19,20,32,54,65332,23,45,76,87,23,98,12,47,-61,29,80, 455, 21, 34};
    MyLinkedList[] bucket = new MyLinkedList[10];
    radixsort(test);
    System.out.println(printArray(test));
  }

}
