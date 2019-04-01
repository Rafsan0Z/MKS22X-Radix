public class Radix{

  public static void radixsort(int[] data){
    MyLinkedList[] bucket = new MyLinkedList[10];
    int count = biggest(data);
    while(count != 0){
      fillBucket();
    }
  }

  private static void fillBucket(){
    
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
