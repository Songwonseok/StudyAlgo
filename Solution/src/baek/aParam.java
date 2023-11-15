package baek;

public class aParam {
	String id;
	int age;
	String name;

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public aParam() {}

	public aParam(String id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
}
