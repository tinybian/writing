package sort;
/**  
 * �鲢����<br/>  
 * <ul>�ϲ�����  
 * <li>����ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ��������</li>  
 * <li>�趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ��</li>  
 * <li>�Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ��</li>  
 * <li>�ظ�����3ֱ��ĳһָ��ﵽ����β</li>  
 * <li>����һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β</li>  
 * </ul>  
 *   
 * @param numbers  
 */  


class MergeSort{
	public void mergeSort(int[] array){
		recursive_mergeSort(array, 0, array.length-1);
	}
	private void recursive_mergeSort(int[] array, int begin, int end){
		if(begin>=end)
			return;
		int middle = (begin+end)/2;
		recursive_mergeSort(array, begin, middle);
		recursive_mergeSort(array, middle+1, end);
		merge(array, begin, middle, end);
	}
	private void merge(int[] array, int begin, int middle, int end){
		int[] result = new int[end-begin+1];//��ʱ��Ž��
		int i = begin, j=middle+1, resIndex=0;
		
		while(i<=middle && j<=end)//�ҵ���С�Ĵ��������� ֱ��һ��ȫ������
		{
			if(array[i]<=array[j])//ע�⣡��һ��Ҫ�еȺţ�����Ͳ��ȶ��ˡ����ʱԭ����ǰ��array[i]�ȷš�
				result[resIndex++]=array[i++];
			else
				result[resIndex++]=array[j++];
		}
		
		//��ʣ���Ԫ�ش�����
		while(j<=end)
			result[resIndex++]=array[j++];
		
		while(i<=middle)
			result[resIndex++]=array[i++];
		
		//��������鸴�ƽ�ԭ����
		for(int k = begin, p=0;p<result.length;k++, p++)
			array[k]=result[p];
	}
	
	/*�ǵݹ鷽ʽ
	 * ��ʼ�Լ��Ϊ1�Ľ��й鲢��Ҳ����˵����һ��Ԫ�ظ��ڶ������й鲢������������ĸ����й鲢��
	 * Ȼ�����Լ��Ϊ2�Ľ��й鲢��1-2��3-4���й鲢��5-6��7-8���й鲢��
	 * ����2*2�ļ����ͬ��ֱ��2*k�������鳤��Ϊֹ��
	 * 
	 * 
	 * */
	public void mergeSort_no_recursive(int[] array)
	{
		int size = 1;//ÿ��Ԫ�ظ��� �鲢��С��Ԫ��С
		while(size < array.length)
		{
			int i=0;//�鲢��һ��Ĺ��
			int j=i+size;//�鲢�ڶ���Ĺ��
			while(i<array.length && j<array.length)
			{
				merge(array, i, i+size-1, j+size-1 > array.length-1 ? array.length-1 : j+size-1);//�ϲ�һ��
				i = i+size*2;//��λ
				j = j+size*2;//��λ
			}
			size*=2;
		}
	}
}