package factoryPattern;

import java.util.regex.Pattern;

/*抽象产品*/
/*这里因为Car有共性name，所以使用抽象类，若没有共性，可使用interface*/
abstract class Car{
	public String brand;
	public String name;
	public abstract void drive();
}

/*抽象子产品1*/
abstract class Benz extends Car{
	public String brand;
	public Benz() {
		this.brand = "Benz";
	}
}

/*抽象子产品2*/
abstract class BMW extends Car{
	public String brand;
	public BMW() {
		this.brand = "BMW";
	}
}

/*具体产品1*/
class BenzBusiness extends Benz{
	public BenzBusiness() {
		this.name = "BenzBusiness";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*具体产品2*/
class BenzSports extends Benz{
	public BenzSports() {
		this.name = "BenzSports";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*具体产品3*/
class BMWBusiness extends BMW{
	public BMWBusiness() {
		this.name = "BMWBusiness";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*具体产品4*/
class BMWSports extends BMW{
	public BMWSports() {
		this.name = "BMWSports";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*抽象工厂*/
interface Factory{
	public abstract Car getCar(String carName);
}

/*具体工厂1*/
class BusinessCarFactory implements Factory{
	@Override
	public Car getCar(String carName) {
		if(carName == "BenzBusiness")
			return new BenzBusiness();
		if(carName == "BMWBusiness")
			return new BMWBusiness();
		else
			return null;
	}
}

/*具体工厂2*/
class SportsCarFactory implements Factory{
	@Override
	public Car getCar(String carName) {
		if(carName == "BenzSports")
			return new BenzSports();
		if(carName == "BMWSports")
			return new BMWSports();
		else
			return null;
	}
}

/*具体工厂1反射改进*/
class BusinessCarFactoryReflect implements Factory{
	@Override
	public Car getCar(String carName) {
		if(!Pattern.compile("Business$").matcher(carName).matches())
			return null;
		try {
			return (Car) Class.forName(carName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}

/*具体工厂2反射改进*/
class SportsCarFactoryReflect implements Factory{
	@Override
	public Car getCar(String carName) {
		if(!Pattern.compile("Sports$").matcher(carName).matches())
			return null;
		try {
			return (Car) Class.forName(carName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}

/*客户*/
class Client{
	public static void main(String[] args) {
		Factory factory = new SportsCarFactory();
		Car car = null;
		if(factory != null)
			car = factory.getCar("BenzSports");
		if(car != null)
			car.drive();
	}
}
