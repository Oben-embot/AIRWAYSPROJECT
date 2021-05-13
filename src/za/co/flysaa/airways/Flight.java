package za.co.flysaa.airways;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int flightNo;
	private String flightName;
	private String from;
	private String to;
	private String departureDate;
	private String arrivalDate;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(int flightNo, String flightName, String from, String to, String departureDate,
			LocalDateTime arrivalDate) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate.toString();
		this.arrivalDate = arrivalDate.toString();
	}

	public Flight(int flightNo, String flightName, String from, String to, String departureDate, String arrivalDate) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate.toString();
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate.toString();
	}

	@Override
	public String toString() {
		return "Flight [flightNo = " + flightNo + ", flightName = " + flightName + ", from = " + from + ", to = " + to
				+ ", departureDate = " + departureDate + ", arrivalDate = " + arrivalDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((flightName == null) ? 0 : flightName.hashCode());
		result = prime * result + flightNo;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		Flight other = (Flight) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (flightName == null) {
			if (other.flightName != null)
				return false;
		} else if (!flightName.equals(other.flightName))
			return false;
		if (flightNo != other.flightNo)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	public void addFlight(int flightNo, String flightName, String from, String to, LocalDateTime departureDate,
			LocalDateTime arrivalDate) {
		this.setFlightNo(flightNo);
		this.setFlightName(flightName);
		this.setFrom(from);
		this.setTo(to);
		this.setDepartureDate(departureDate);
		this.setArrivalDate(arrivalDate);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saairway_db", "root",
					"Generaloben@111");
			Statement statement = connection.createStatement();
			String flightQuery = "INSERT INTO flight(flight_number, flight_name, from_where, to_where, departure, arrival_date)"
					+ "VALUES(" + flightNo + ", '" + flightName + "','" + from + "','" + to + "','" + departureDate
					+ "','" + arrivalDate + "')";
			statement.execute(flightQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Flight> avaiableFlight() {
		List<Flight> availableFlights = new ArrayList();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saairway_db", "root",
					"Generaloben@111");
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM flight WHERE flight_number = flight_number;";
			ResultSet resultSet = statement.executeQuery(query);


			while (resultSet.next()) {
				int flightNo = resultSet.getInt("flight_number");
				String flightName = resultSet.getString("flight_name");
				String from = resultSet.getString("from_where");
				String to = resultSet.getString("to_where");
				String departure = resultSet.getString("departure");
				String arrivalDate = resultSet.getString("departure");
				
				availableFlights.add(new Flight(flightNo, flightName, from, to, departure, arrivalDate));
			}
			return availableFlights;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return availableFlights;
	}

}
