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
    takeWater(data,bucket);
  }

  public static void takeWater(int[] data, MyLinkedList[] bucket){
    for(int i = 0; i < bucket[0].size(); i++){
      data[i] = bucket[0].get(i);
    }
    craftBucket(bucket);
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

  private static void fillBucket(int[] data, MyLinkedList[] bucket, int place){
    for(int i = 0; i < data.length; i++){
      int digit = getDigit(data,i,place);
      if(data[i] >= 0){
      bucket[digit].add(data[i]);
    }
    else{
      bucket[digit].add(0,data[i]);
    }
  }
    /*for(int i = 1; i < 10; i++){
      for(int j = 0; j < bucket[i].size(); j++){
        bucket[0].add(bucket[i].get(j));
      }
    }*/
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
    while(place != 0){
      num = num / 10;
      place--;
    }
    return num % 10;
  }

  public static void main(String args[]){
    int[] test = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    MyLinkedList[] bucket = new MyLinkedList[10];
    craftBucket(bucket);
    fillBucket(test,bucket,0);
    System.out.println(toStringBucket(bucket));
  }

}
