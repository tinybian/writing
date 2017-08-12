package factoryPattern;

/*抽象产品*/
/*这里因为Car有共性name，所以使用抽象类，若没有共性，可使用interface*/
abstract class Car{
	public String name;
	public abstract void drive();
}

/*具体产品1*/
class Benz extends Car{
	public Benz() {
		this.name = "Benz";
	}
	@Override
	public void drive() {
		System.out.println(name+":---------------");
	}
}

/*具体产品2*/
class BMW extends Car{
	public BMW() {
		this.name = "BMW";
	}
	@Override
	public void drive() {
		System.out.println(name+":---------------");
	}
}

/*抽象工厂*/
interface Factory{
	public abstract Car getCar();
}

/*具体工厂1*/
class BenzFactory implements Factory{
	public Car getCar(){
		return new Benz();
	}
}

/*具体工厂2*/
class BMWFactory implements Factory{
	public Car getCar(){
		return new BMW();
	}
}

/*客户*/
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

