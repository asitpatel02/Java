package Assignment_3;

public class PhoneBookEntry {
	private final String name;
	private final long number;

	public PhoneBookEntry(String name, long number) {
		this.name=name;
		this.number=  number;
	}

	public String getName() {
		return name;
	}

	public long getNumber() {
		return number;
	}

}