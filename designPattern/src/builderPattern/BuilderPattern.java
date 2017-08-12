package builderPattern;

import java.util.regex.Pattern;

/*产品*/
class Dishes{
	public int food;
	public int dish;
}

/*抽象建造者*/
interface Cooking{
	public abstract void prepareFoodMaterial();
	public abstract void prepareCooker();
	public abstract void cook();
	public abstract Object getProducts();
}

/*具体建造者*/
class CheifCook implements Cooking{
	private Dishes newDishes;
	
	public CheifCook() {
		newDishes = new Dishes();
	}
	
	@Override
	public void prepareFoodMaterial() {
		System.out.println("get food material");
	}
	@Override
	public void prepareCooker() {
		newDishes.dish = 2;
		System.out.println("get Cooker");
	}
	@Override
	public void cook() {
		newDishes.food =100;
		System.out.println("cook food");
	}
	
	public Dishes getProducts(){
		return newDishes;
	}
}

/*主管*/
class Boss{
	private Cooking cooking;
	public Boss(Cooking builder){
		cooking = builder;
	}
	public Object LetCookDo(){
		cooking.prepareFoodMaterial();
		cooking.prepareCooker();
		cooking.cook();
		return cooking.getProducts();
	}
}

/*客户*/
class Client{
	public static void main(String[] args) {
		Cooking cook = new CheifCook();
		Boss boss = new Boss(cook);
		Dishes myDish = (Dishes)boss.LetCookDo();
	}
}