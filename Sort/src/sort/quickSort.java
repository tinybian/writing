package sort;

/**  
 * 快速排序<br/>  
 * <ul>  
 * <li>从数列中挑出一个元素，称为“基准”</li>  
 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>  
 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>  
 * </ul>  
 * 
 */

class QuickSort{
	public void quickSort(float[] a, int start, int end){
		if(start<end)
		{
			int middle = partition(a, start, end);
			quickSort(a, start, middle-1);//不能将Middle递归进去 否则当分割失败时 可能死循环
			quickSort(a, middle+1, end);
		}
	} 
	private int partition(float[] a, int start, int end)
	{
		float temp = a[start];//取出中轴
		while(start<end)
		{
			while(start<end && a[end]>=temp)//从右向左找到比中轴小的
				end--;
			a[start]=a[end];//赋值给左侧元素
			while(start<end && a[start]<=temp)//从左向右找到比中轴大的
				start++;
			a[end]=a[start];//赋值给右侧元素
		}//直到start==end
		a[start]=temp;//将中轴赋值给当前位置
		return start;
	}
	
	private int improvePartition(int[] array, int start, int end) {
            int mid = getMin3(array, start, start+(end - start)/2, end);//获取开头，结尾，中间三个元素的中位数的下标
            swap(array, start, mid); // 将这个中位数与开头元素交换，以便继续使用上述算法。
            int temp = array[start];
            while(start < end) {
                while(start < end && array[end] >= temp)
                    end--;
                array[start] = array[end];
                while(start < end && array[start] <= temp)
                    start++;
                array[end] = array[start];
            }
            array[start] = temp;
            return start;
        }

	// 获取3个元素的中位数下标
        private int getMin3(int[] array, int i, int j, int k) {
            int min = array[i], max = array[i];
            if( array[j] < min )
                min = array[j];
            else
                max = array[j];

            if( array[k] < min )
                min = array[k];
            else if( array[k] > max )
                max = array[k];

            int mid = array[i] + array[j] + array[k] - max - min; // 找出中位数的大小
            if (array[i] == mid)
                return i;
            if (array[j] == mid)
                return j;
            else
                return k;
        }
}

