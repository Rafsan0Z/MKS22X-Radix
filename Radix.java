public class Radix{

  public static void radixsort(int[] data){
    MyLinkedList[] bucket = new MyLinkedList[data.length];
    int count = biggest(data);
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

  public static void main(String args[]){
    int[] test = new int[]{2,1,-1,-2};
  }

}
