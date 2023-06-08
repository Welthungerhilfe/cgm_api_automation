package api.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	static Faker faker = new Faker();

	public String getRegexifyName() {

		String RegexifyName = faker.regexify("[A-Za-z0-9 ,_-]{10}");
		return RegexifyName;
	}

	public String getfirstName() {

		String firstName = faker.name().firstName();
		return firstName;
	}
	
	public String getNameWithMiddle() {

		String NameWithMiddle =faker.name().nameWithMiddle();
		return NameWithMiddle;
	}

	public String getlastName() {

		String lastName = faker.name().lastName();
		return lastName;
	}

	public String getfullName() {

		String fullName = faker.name().fullName();
		return fullName;
	}

	public String getName() {

		String Name =faker.name().name();
		return Name;
	}

	public String getUserName() {

		String UserName =faker.name().username();
		return UserName;
	}
	
	public String getfullAddress() {

		String fullAddress =faker.address().fullAddress();
		return fullAddress;
	}
	
	public String getAnimalName() {

		String AnimalName =faker.animal().name();
		return AnimalName;
	}
	
	public String getdigit() {

		String digit =faker.number().digit();
		return digit;
	}
	
	public int getrandomDigit() {

		int randomDigit =faker.number().randomDigit();
		return randomDigit;
	}
	
	public long getrandomNumber() {

		long randomNumber =faker.number().randomNumber();
		return randomNumber;
	}
	

	public static void main(String a[]) {
		FakerUtils fu = new FakerUtils();
		System.out.println("RegexifyName: "+fu.getRegexifyName());
		System.out.println("firstName: "+fu.getfirstName());
		System.out.println("NameWithMiddle: "+fu.getNameWithMiddle());
		System.out.println("lastName: "+fu.getlastName());
		System.out.println("fullName: "+fu.getfullName());
		System.out.println("Name: "+fu.getName());
		System.out.println("UserName: "+fu.getUserName());
		System.out.println("fullAddress: "+fu.getfullAddress());
		System.out.println("AnimalName: "+fu.getAnimalName());
		System.out.println("digit: "+fu.getdigit());
		System.out.println("randomDigit: "+fu.getrandomDigit());
		System.out.println("randomNumber: "+fu.getrandomNumber());
	}

}
