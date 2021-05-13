package za.co.flysaa.people;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import za.co.flysaa.airways.Flight;
import za.co.flysaa.airways.Ticket;
import za.co.flysaa.transaction.Payment;

public class Customer extends Person {
	private static long customer_id_number;
	private int number_of_tickets;
	private String emergency_contact;
	private int pin_code;
	private Ticket ticket;
	private Flight flight;
	private Payment payment;

	public Customer() {
	}

	public long getCustomer_id_number() {
		return customer_id_number;
	}

	public void setCustomer_id_number(long customer_id_number) {
		this.customer_id_number = customer_id_number;
	}

	public int getNumber_of_tickets() {
		return number_of_tickets;
	}

	public void setNumber_of_tickets(int number_of_tickets) {
		this.number_of_tickets = number_of_tickets;
	}

	public String getEmergency_contact() {
		return emergency_contact;
	}

	public void setEmergency_contacts(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (customer_id_number ^ (customer_id_number >>> 32));
		result = prime * result + ((emergency_contact == null) ? 0 : emergency_contact.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + number_of_tickets;
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + pin_code;
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		Customer other = (Customer) obj;
		if (customer_id_number != other.customer_id_number)
			return false;
		if (emergency_contact == null) {
			if (other.emergency_contact != null)
				return false;
		} else if (!emergency_contact.equals(other.emergency_contact))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (number_of_tickets != other.number_of_tickets)
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (pin_code != other.pin_code)
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}

	public void bookTicket(long customer_id_number, String first_name, String last_name, String cell_phone_number,
			String date_of_birth, String nationality, String email_address, int number_of_tickets,
			String emmergency_contact, int pin_code, Ticket ticket, int ticketNo, int seatNo, String type) {

		this.setCustomer_id_number(customer_id_number);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setCell_phone_number(cell_phone_number);
		this.setDate_Of_Birth(date_of_birth);
		this.setNationality(nationality);
		this.setEmail(email_address);
		this.setNumber_of_tickets(number_of_tickets);
		this.setEmergency_contacts(emmergency_contact);
		this.setPin_code(pin_code);

		ticket.setTicketNo(ticketNo);
		ticket.setSeatNo(seatNo);
		ticket.setType(type);

		if (type.equalsIgnoreCase("economy")) {
			ticket.setPrice(500.0);
		} else if (type.equalsIgnoreCase("business")) {
			ticket.setPrice(700.0);
		} else if (type.equalsIgnoreCase("first class")) {
			ticket.setPrice(1000.0);
		}

		try {
			// double price = 0;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saairway_db", "root",
					"Generaloben@111");
			Statement statement = connection.createStatement();
			String custmoerQuery = "INSERT INTO customer(customer_id_number, first_name, last_name, cell_phone_number, date_of_birth, nationality, email_address, number_of_tickets, emmergency_contact, pin_code)"
					+ "VALUES(" + customer_id_number + ", '" + first_name + "', '" + last_name + "', '"
					+ cell_phone_number + "', '" + date_of_birth + "', '" + nationality + "', '" + email_address + "', "
					+ number_of_tickets + ", " + emmergency_contact + ", " + pin_code + ")";

			String ticketQuery = "INSERT INTO ticket(ticket_number, seat_number, price, ticket_type, customer_id_number)"
					+ "VALUES(" + ticketNo + ", " + seatNo + ", " + ticket.getPrice() + ", '" + type + "', "
					+ customer_id_number + ")";

			statement.execute(custmoerQuery);
			statement.execute(ticketQuery);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}// end of book ticket method();

//	public static void availableSeats() {
//		try {
//		System.out.println("===========Available Seats===========");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saairway_db", "root",
//				"Generaloben@111");
//		Statement statement = connection.createStatement();
//		String availableSeatsQuery = "SELEC * FROM customer c join ticket t WHERE c.customer_id_number = t.customer_id_number = "+ customer_id_number;
//				
//		ResultSet resultSet = statement.executeQuery(availableSeatsQuery);
//			while(resultSet.next()) {
//				if()
//				
//			}		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	

	@Override
	public String toString() {
		return "Customer [customer_id_number: " + customer_id_number + ", number_of_tickets: " + number_of_tickets
				+ ", emergency_contact: " + emergency_contact + ", pin_code: " + pin_code + ", ticket number: "
				+ ticket.getTicketNo() + ", seat number: " + ticket.getSeatNo() + ", ticket type: " + ticket.getType()
				+ ", flight name: " + flight.getFlightName() + ", flight number: " + flight.getFlightNo()
				+ ", flight from: " + flight.getFrom() + ", flight to: " + flight.getTo() + ", flight departure date: "
				+ flight.getDepartureDate() + ", flight arrival date: " + flight.getDepartureDate() + ", arrival date: "
				+ flight.getArrivalDate() + "]";
	}

}
