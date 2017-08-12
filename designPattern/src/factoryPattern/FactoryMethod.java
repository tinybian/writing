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

/*���󹤳�*/
interface Factory{
	public abstract Car getCar();
}

/*���幤��1*/
class BenzFactory implements Factory{
	public Car getCar(){
		return new Benz();
	}
}

/*���幤��2*/
class BMWFactory implements Factory{
	public Car getCar(){
		return new BMW();
	}
}

/*�ͻ�*/
class Client{
	public static void main(String[] args) {
		Factory factory = new BenzFactory();
		Car car = null;
		if(factory != null)
			car = factory.getCar();
		if(car != null)
			car.drive();
	}
}

