package sort;

class RadixSort{
	public void radixSort(int[] array, int digit){
		for(int i=0;i<digit;i++)
			countSort(array, i);
	}
	private void countSort(int[] array, int dig){
			
		//�����������
		int[] count=new int[10];
		
		int op = 1;
		for(int i=0;i<dig;i++)
			op*=10;
		
		for(int i=0;i<array.length;i++)
			count[array[i]/op%10]++;
		
		//�����飺���� ʹcount�����Ϊ��¼Ԫ��λ��o(k)
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		
		//����������
		int[] result=new int[array.length];
		//���ı飺����count�����¼��λ��,��array�������δ���result�е���Ӧλ��o(n)
		for(int i=array.length-1;i>=0;i--)
		{
			result[count[array[i]/op%10]-1]=array[i];
			count[array[i]/op%10]--;
		}
		
		//����飺��result���鸴�Ƶ�array��o(n)
		for(int i=0;i<array.length;i++)
			array[i]=result[i];
	}
}