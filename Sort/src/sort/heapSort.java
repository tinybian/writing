package sort;

import java.util.Timer;

class HeapSort{
	public void heapSort(int[] array){
		if(array == null)
			return;
		
		//����ɴ����
		makeMaxHeap(array);
		
		//resΪĩβ��������� �����ڵ���������ĩβ���� �ٽ�����������ɴ���� ����ظ� ֱ��resΪ1
		for(int res = array.length-1;res>0;res--)
		{
			int temp = array[res];
			array[res] = array[0];
			array[0] = temp;
			
			maxChildHeap(array, 0, res);
		}
	}
	private void makeMaxHeap(int[] array)//��ǰlength��Ԫ������ɴ����
	{
		//������µ�������ʼ����ÿ����������ɴ���ѣ�ֱ�����ڵ㣬���������Ѿ��Ǵ�����ˡ��������Ľڵ�����Ϊlength/2,�±�Ϊlength/2-1
		for(int i=array.length/2-1;i>=0;i--)
			maxChildHeap(array, i, array.length);
	}
	private void maxChildHeap(int[] array, int root, int length)//��ǰlength��Ԫ���У���rootΪ������������ɴ����
	{
		int leftChild = 2*root+1;
		
		int rightChild = 2*root+2; 
		//�������Ҷ�ӽڵ㣬�ҵ��������Һ����������������任��������
		int largest = root;
		if(leftChild<length && array[leftChild]>array[root])//������Ӵ��ڣ��Ҵ��ڸ��ڵ㣬�򽻻�
			largest = leftChild;
		if(rightChild<length && array[rightChild]>array[largest])//����Һ��Ӵ��ڣ��Ҵ��ڸ��ڵ㣬�򽻻�
			largest = rightChild;
		
		if(largest != root){
			int temp  = array[largest];
			array[largest] = array[root];
			array[root] = temp;
			maxChildHeap(array, largest, length);
		}
		
	}
}