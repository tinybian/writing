package sort;

public class Main{
	public static void main(String[] args) {
		QuickSort qsort = new QuickSort();
		BubbleSort bsort = new BubbleSort();
		InsertSort isort = new InsertSort();
		SelectSort ssort = new SelectSort();
		MergeSort msort = new MergeSort();
		CountSort cSort = new CountSort();
		RadixSort rSort = new RadixSort();
		HeapSort hSort = new HeapSort();
		
		int[] array= new int[]{5,7,3,4,8,9,6,12,5,24,5,0,15,1,5,6,2,7,5};
		
		//qsort.quickSort(array, 0, array.length-1);
		//bsort.improve_bubbleSort(array);
		//isort.insertSort(array);
		//ssort.selectSort(array);
//		msort.mergeSort(array);
		//msort.mergeSort_no_recursive(array);
		//cSort.countSort(array);
		//rSort.radixSort(array, 2);
		hSort.heapSort(array);
		
		printArray(array);
	}
	private static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
class Singleton{
	private static class SingletonHolder{
		private static final Singleton INSTANCE =  new Singleton();
	}
	private Singleton(){};
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}