package sort;

/**  
 * ��������<br/>  
 * <ul>  
 * <li>������������һ��Ԫ�أ���Ϊ����׼��</li>  
 * <li>�����������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ���������ָ�֮��  
 * �û�׼���������λ�á������Ϊ�ָpartition��������</li>  
 * <li>�ݹ�ذ�С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������</li>  
 * </ul>  
 * 
 */

class QuickSort{
	public void quickSort(float[] a, int start, int end){
		if(start<end)
		{
			int middle = partition(a, start, end);
			quickSort(a, start, middle-1);//���ܽ�Middle�ݹ��ȥ ���򵱷ָ�ʧ��ʱ ������ѭ��
			quickSort(a, middle+1, end);
		}
	} 
	private int partition(float[] a, int start, int end)
	{
		float temp = a[start];//ȡ������
		while(start<end)
		{
			while(start<end && a[end]>=temp)//���������ҵ�������С��
				end--;
			a[start]=a[end];//��ֵ�����Ԫ��
			while(start<end && a[start]<=temp)//���������ҵ���������
				start++;
			a[end]=a[start];//��ֵ���Ҳ�Ԫ��
		}//ֱ��start==end
		a[start]=temp;//�����ḳֵ����ǰλ��
		return start;
	}
}

