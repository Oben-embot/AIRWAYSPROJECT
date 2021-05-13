package za.co.flysaa.people;

public class Person {
	private String first_name;
	private String last_name;
	private String cell_phone_number;
	private String date_of_birth;
	private String nationality;
	private String email_address;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String first_name, String last_name, String cell_phone_number, String date_Of_Birth,
			String nationality, String email_address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.cell_phone_number = cell_phone_number;
		this.date_of_birth = date_of_birth;
		this.nationality = nationality;
		this.email_address = email_address;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCell_phone_number() {
		return cell_phone_number;
	}

	public void setCell_phone_number(String cell_phone_number) {
		this.cell_phone_number = cell_phone_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_Of_Birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail(String email_address) {
		this.email_address = email_address;
	}



	@Override
	public String toString() {
		return "Person [first_name=" + first_name + ", last_name=" + last_name + ", cell_phone_number=" + cell_phone_number
				+ ", date_of_birth=" + date_of_birth + ", nationality=" + nationality
				+ ", email_address=" + email_address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell_phone_number == null) ? 0 : cell_phone_number.hashCode());
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + ((email_address == null) ? 0 : email_address.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (cell_phone_number == null) {
			if (other.cell_phone_number != null)
				return false;
		} else if (!cell_phone_number.equals(other.cell_phone_number))
			return false;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		if (email_address == null) {
			if (other.email_address != null)
				return false;
		} else if (!email_address.equals(other.email_address))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
				return true;
	}


}
