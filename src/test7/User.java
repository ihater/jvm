package test7;

import java.sql.Date;

public class User {

	private String name;
	private int  age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	private Date birth;
}
