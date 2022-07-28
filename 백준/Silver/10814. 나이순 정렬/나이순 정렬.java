import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		int num = Integer.parseInt(str);
		Person[] p = new Person[num];
		for (int i = 0; i < num; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new Person(age, name);
		}
		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}

		});
		for (int i = 0; i < num; i++) {
			System.out.println(p[i].toString());
		}

	}

	public static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}
}
