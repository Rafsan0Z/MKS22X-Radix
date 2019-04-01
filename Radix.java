public class Radix{

  public static void radixsort(int[] data){
    MyLinkedList[] bucket = new MyLinkedList[10];
    craftBucket(bucket);
    int count = biggest(data);
    int place = 0;
    while(count != 0){
      fillBucket(data,bucket,place);
      place++;
    }
  }

  private static void craftBucket(MyLinkedList[] bucket){
    for(int i = 0; i < 10; i++){
      bucket[i] = new MyLinkedList();
    }
  }

  private static void fillBucket(int[] data, MyLinkedList[] bucket, int place){
    for(int i = 0; i < data.length; i++){
      int digit = getDigit(data,i,place);
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
    while(place != 0){
      num = num / 10;
      place--;
    }
    return num % 10;
  }

  public static void main(String args[]){
    int[] test = new int[]{2,1,-1,-2};
  }

}
