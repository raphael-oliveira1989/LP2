abstract class Animal {
	abstract String talk();
	static void letsHear(final Animal a) {
		System.out.println(a.talk());//vai pegar o animal do objeto referenciado
	}
	public static void main(String[] args) {
		letsHear(new Cat());//polimorfo. Pode ser qualquer animal
		letsHear(new Dog());//polimorfo. Pode ser qualquer animal
	}
}

class Cat extends Animal {
	String talk() {//sobrescreveu metodo
		return "Meow!";
	}
}

class Dog extends Animal {
	String talk() {//sobrescreveu metodo
		return "Woof!";
	} 
}

//site referencia: https://pt.qaz.wiki/wiki/Polymorphism_(computer_science)
