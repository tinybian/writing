package sort;

import java.util.Timer;

class HeapSort{
	public void heapSort(int[] array){
		if(array == null)
			return;
		
		//整理成大根堆
		makeMaxHeap(array);
		
		//res为末尾有序区光标 将根节点与无序区末尾交换 再将无序区整理成大根堆 如此重复 直至res为1
		for(int res = array.length-1;res>0;res--)
		{
			int temp = array[res];
			array[res] = array[0];
			array[0] = temp;
			
			maxChildHeap(array, 0, res);
		}
	}
	private void makeMaxHeap(int[] array)//将前length个元素整理成大根堆
	{
		//从最底下的子树开始，将每个子树整理成大根堆，直至根节点，这样整个堆就是大根堆了。有子树的节点数量为length/2,下标为length/2-1
		for(int i=array.length/2-1;i>=0;i--)
			maxChildHeap(array, i, array.length);
	}
	private void maxChildHeap(int[] array, int root, int length)//将前length个元素中，以root为根的子树整理成大根堆
	{
		int leftChild = 2*root+1;
		
		int rightChild = 2*root+2; 
		//如果不是叶子节点，找到根与左右孩子中最大的数，将其换至根处。
		int largest = root;
		if(leftChild<length && array[leftChild]>array[root])//如果左孩子存在，且大于根节点，则交换
			largest = leftChild;
		if(rightChild<length && array[rightChild]>array[largest])//如果右孩子存在，且大于根节点，则交换
			largest = rightChild;
		
		if(largest != root){
			int temp  = array[largest];
			array[largest] = array[root];
			array[root] = temp;
			maxChildHeap(array, largest, length);
		}
		
	}
}