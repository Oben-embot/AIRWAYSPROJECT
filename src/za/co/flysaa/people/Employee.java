package za.co.flysaa.people;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee extends Person {
	private long employee_id_number;
	private double salary;
	private String position;
	private String user_name;
	private int password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(double salary, String position, String user_name, int password) {
		super();
		this.salary = salary;
		this.position = position;
		this.user_name = user_name;
		this.password = password;
	}

	public long getEmployee_id_number() {
		return employee_id_number;
	}

	public void setEmployee_id_number(long employee_id_number) {
		this.employee_id_number = employee_id_number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employee_id_number: " + employee_id_number + ", salary: " + salary + ", position: " + position
				+ ", user_name: " + user_name + ", password: " + password + ", first_name: " + getFirst_name()
				+ ", last_name: " + getLast_name() + ", cell_phone_number: " + getCell_phone_number()
				+ ", date_of_birth: " + getDate_of_birth() + ", nationality: " + getNationality() + ", email_address: "
				+ getEmail_address() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (employee_id_number ^ (employee_id_number >>> 32));
		result = prime * result + password;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employee_id_number != other.employee_id_number)
			return false;
		if (password != other.password)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	public void register(long employee_id_number, String first_name, String last_name, String cell_phone_number,
			String date_of_birth, String nationality, String email_address, double salary, String position,
			String user_name, int password) {
		this.setEmployee_id_number(employee_id_number);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setCell_phone_number(cell_phone_number);
		this.setDate_Of_Birth(date_of_birth);
		this.setNationality(nationality);
		this.setEmail(email_address);
		this.setSalary(salary);
		this.setPosition(position);
		this.setUser_name(user_name);
		this.setPassword(password);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saairway_db", "root",
					"Generaloben@111");
			Statement statement = connection.createStatement();
			String employeeQuery = "INSERT INTO employee(employee_id_number, first_name, last_name, cell_phone_number, date_of_birth, nationality, email_address, salary, position, user_name, password)"
					+ "VALUES(" + employee_id_number + ", '" + first_name + "', '" + last_name + "', '"
					+ cell_phone_number + "', '" + date_of_birth + "', '" + nationality + "', '" + email_address + "', "
					+ salary + ", '" + position + "', '" + user_name + "', " + password + ")";

			statement.execute(employeeQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
