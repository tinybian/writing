package sort;

class CountSort{
	public void countSort(int[] array){
		int max = 0;
		//��һ�飺�ҵ����Ԫ��o(n)
		for(int i=0;i<array.length;i++)
			if(array[i]>max)
				max=array[i];
		
		//�����������
		int[] count=new int[max+1];
		//�ڶ��飺����o(n)
		for(int i=0;i<array.length;i++)
			count[array[i]]++;
		
		//�����飺���� ʹcount�����Ϊ��¼Ԫ��λ��o(k)
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		
		//����������
		int[] result=new int[array.length];
		//���ı飺����count�����¼��λ��,��array�������δ���result�е���Ӧλ��o(n)
		for(int i=0;i<array.length;i++)
		{
			result[count[array[i]]-1]=array[i];
			count[array[i]]--;
		}
		
		//����飺��result���鸴�Ƶ�array��o(n)
		for(int i=0;i<array.length;i++)
			array[i]=result[i];
	}
}