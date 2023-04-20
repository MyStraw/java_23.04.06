package chapter10;

import java.util.HashSet;
import java.util.Iterator;

class User {
	String ssn;
	String name;

	public User(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}

	public String toString() {
		return ssn + ":" + name;
	}

	public boolean equals(Object obj) {
		if (this.ssn.equals(obj.ssn))
			return true;
		else
			return false;
	}
}

public class Test11 {
	public static void main(String[] args) {
		User u1 = new User("123", "홍길동");
		User u2 = new User("123", "홍길순");
		HashSet<User> users = new HashSet<>();
		if (u1.equals(u2))
			users.add(u2);
		else
			users.add(u1);
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println(u);
			if (u.equals(u))
		}

	}

}
