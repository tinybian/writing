package sort;

/**  
 * 插入排序 
 * 
 * 从第一个元素开始，该元素可以认为已经被排序  
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置 
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 
 * 将新元素插入到该位置中重复步骤2
 *   
 * @param numbers  
 */  

class InsertSort{
	public void insertSort(int[] array){
		for(int i = 1;i<array.length;i++)//从第二个元素开始向前插入
		{
			int temp = array[i];//要插入的数
			int j = i-1;
			while(j>=0 && array[j]>temp)//注意！！！！！！这里一定是大于号 即遇到等于temp的数也停止 否则就是不稳定排序了
			{//在已排序序列中 从后往前直到找到比要插入的元素array[i]小或相等的元素
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=temp;//将temp插在这个元素后面
		}
	}
}