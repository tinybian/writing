package factoryPattern;

/*�����Ʒ*/
/*������ΪCar�й���name������ʹ�ó����࣬��û�й��ԣ���ʹ��interface*/
abstract class Car{
	public String name;
	public abstract void drive();
}

/*�����Ʒ1*/
class Benz extends Car{
	public Benz() {
		this.name = "Benz";
	}
	@Override
	public void drive() {
		System.out.println(name+":---------------");
	}
}

/*�����Ʒ2*/
class BMW extends Car{
	public BMW() {
		this.name = "BMW";
	}
	@Override
	public void drive() {
		System.out.println(name+":---------------");
	}
}

/*�򵥹���*/
class Factory{
	/*�򵥹���ͨ��ʹ�þ�̬������ȡ��Ʒ����*/
	public static Car getCar(String carName){
		Car newCar = null;
		
		switch (carName) {
			case "Benz":
				newCar = new Benz();
				break;
			case "BMW":
				newCar = new BMW();
				break;
		}
		
		return newCar;
	}
}

/*�ͻ�*/
class Client{
	public static void main(String[] args) {
		Car car1 = Factory.getCar("BMW");
		Car car2 = Factory.getCar("Benz");
		if(car1 != null)
			car1.drive();
		if(car2 != null)
			car2.drive();
	}
}

