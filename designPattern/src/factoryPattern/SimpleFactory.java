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

/*简单工厂*/
class Factory{
	/*简单工厂通常使用静态方法获取产品对象*/
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

/*客户*/
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

