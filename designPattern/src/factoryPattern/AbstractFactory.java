package factoryPattern;

import java.util.regex.Pattern;

/*�����Ʒ*/
/*������ΪCar�й���name������ʹ�ó����࣬��û�й��ԣ���ʹ��interface*/
abstract class Car{
	public String brand;
	public String name;
	public abstract void drive();
}

/*�����Ӳ�Ʒ1*/
abstract class Benz extends Car{
	public String brand;
	public Benz() {
		this.brand = "Benz";
	}
}

/*�����Ӳ�Ʒ2*/
abstract class BMW extends Car{
	public String brand;
	public BMW() {
		this.brand = "BMW";
	}
}

/*�����Ʒ1*/
class BenzBusiness extends Benz{
	public BenzBusiness() {
		this.name = "BenzBusiness";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*�����Ʒ2*/
class BenzSports extends Benz{
	public BenzSports() {
		this.name = "BenzSports";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*�����Ʒ3*/
class BMWBusiness extends BMW{
	public BMWBusiness() {
		this.name = "BMWBusiness";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*�����Ʒ4*/
class BMWSports extends BMW{
	public BMWSports() {
		this.name = "BMWSports";
	}
	@Override
	public void drive() {
		System.out.println(brand+" "+name+":---------------");
	}
}

/*���󹤳�*/
interface Factory{
	public abstract Car getCar(String carName);
}

/*���幤��1*/
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

/*���幤��2*/
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

/*���幤��1����Ľ�*/
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

/*���幤��2����Ľ�*/
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

/*�ͻ�*/
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
