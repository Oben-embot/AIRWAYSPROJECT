package za.co.flysaa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import za.co.flysaa.people.Customer;
import za.co.flysaa.people.Employee;
import za.co.flysaa.airways.Flight;
import za.co.flysaa.airways.Ticket;

public class Application {

	public static void main(String[] args) {

		Employee employee = null;
		Customer customer = null;
		Ticket ticket = null;
		Flight flight = null;
		LocalDateTime departureDate = null;
		LocalDateTime arrivalDate = null;

		Scanner scan = new Scanner(System.in);
		for (int b = 0; b < 100; b++) {
			System.out.println();
			System.out.println("AIRWAYS SYSTEMS.");
			System.out.println("Select from the options below");
			System.out.println("1.  For Employee to Register");
			System.out.println("2.  For Employee to login");
			System.out.println();

			int option = scan.nextInt();

			if (option == 1) {
				employee = new Employee();
				System.out.println("Enter Employee IdNumber: ");
				long employeIdNumber = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter first Name: ");
				String firstName = scan.nextLine();
				System.out.println("Enter last Name: ");
				String lastName = scan.nextLine();
				System.out.println("Enter cell Phone Number: ");
				String cellPhoneNumber = scan.nextLine();
				System.out.println("Enter Date of birth: ");
				String dateOfBirth = scan.nextLine();
				System.out.println("Enter Nationality: ");
				String nationality = scan.nextLine();
				System.out.println("Enter your Email Address: ");
				String emailAddress = scan.nextLine();
				System.out.println("Enter your salary: ");
				Double salary = scan.nextDouble();
				scan.nextLine();
				System.out.println("Enter your position");
				String position = scan.nextLine();
				System.out.println("Enter your User Name: ");
				String userName = scan.nextLine();
				System.out.println("Enter your password: ");
				int password = scan.nextInt();

				employee.register(employeIdNumber, firstName, lastName, cellPhoneNumber, dateOfBirth, nationality,
						emailAddress, salary, position, userName, password);
				System.out.println(employee);
				System.out.println();

			} else if (option == 2) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localHost:3306/saairway_db",
							"root", "Generaloben@111");
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM employee WHERE user_name = user_name AND password = password;";
					ResultSet resultSet = statement.executeQuery(query);

					System.out.println("For Employee to Login: ");
					scan.nextLine();
					System.out.println("Enter Position: ");
					String position = scan.nextLine();
					System.out.println("Enter user name: ");
					String userName = scan.nextLine();
					System.out.println("Enter password: ");
					int password = scan.nextInt();

					while (resultSet.next()) {
						String uName = resultSet.getString("user_name");
						int pass = resultSet.getInt("password");
						if (uName.equalsIgnoreCase(userName) && pass == password
								&& position.equalsIgnoreCase("manager")) {
							System.out.println("Login successful. Welcome, " + resultSet.getString("first_name"));
							System.out.println();

							LogoutManager: for (;;) {
								System.out.println();
								System.out.println("  select from the options below");
								System.out.println("1.  To add Flight");
								System.out.println("2.  To book ticket");
								System.out.println("3.  To checkin");
								System.out.println("4.  To Exit");
								System.out.println("5.  To cancel Ticket");
								System.out.println("6.  To check customers in paticular flight");

								int choice = scan.nextInt();

								if (choice == 1) {
									System.out.println("To add flight");
									flight = new Flight();
									System.out.println("Enter flight number: ");
									int flightNo = scan.nextInt();
									scan.nextLine();
									System.out.println("Enter flight name: ");
									String flightName = scan.nextLine();
									System.out.println("from: ");
									String from = scan.next();
									System.out.println("to: ");
									String to = scan.next();
									scan.nextLine();
									System.out.println("Enter the year: ");
									int year = scan.nextInt();
									System.out.println("Enter the month: ");
									int month = scan.nextInt();
									System.out.println("Enter the day: ");
									int dayOfMonth = scan.nextInt();
									System.out.println("Enter the hour: ");
									int hour = scan.nextInt();
									System.out.println("Enter the minute: ");
									int minute = scan.nextInt();

									departureDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
									System.out.println("Departure date: " + departureDate);

									System.out.println();
									System.out.println("for arrival date");
									System.out.println("Enter the year: ");
									year = scan.nextInt();
									System.out.println("Enter the month: ");
									month = scan.nextInt();
									System.out.println("Enter the day: ");
									dayOfMonth = scan.nextInt();
									System.out.println("Enter the hour: ");
									hour = scan.nextInt();
									System.out.println("Enter the minute: ");
									minute = scan.nextInt();

									arrivalDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
									System.out.println("Arrival date: " + arrivalDate);
									flight.addFlight(flightNo, flightName, from, to, departureDate, arrivalDate);
									System.out.println(flight);

								} else if (choice == 2) {
									customer = new Customer();
									ticket = new Ticket();
									customer.setTicket(ticket);// to make use of ticket object inside customer;
									flight = new Flight();
									customer.setFlight(flight);// to make use of flight object inside customer;
									System.out.println("Enter customer IdNumber: ");
									long customerIdNumber = scan.nextLong();
									scan.nextLine();
									System.out.println("Enter first Name: ");
									String firstName = scan.nextLine();
									System.out.println("Enter last Name: ");
									String lastName = scan.nextLine();
									System.out.println("Enter cell Phone Number: ");
									String cellPhoneNumber = scan.nextLine();
									System.out.println("Enter Date of birth: ");
									String dateOfBirth = scan.nextLine();
									System.out.println("Enter Nationality: ");
									String nationality = scan.nextLine();
									System.out.println("Enter your Email Address: ");
									String emailAddress = scan.nextLine();
									System.out.println("Enter Number of ticket: ");
									int numberOfTickets = scan.nextInt();
									scan.nextLine();
									System.out.println("Enter Emmergency contact: ");
									String emmergencyContact = scan.nextLine();
									System.out.println("Enter Pin code");
									int pinCode = scan.nextInt();
									System.out.println("Enter ticket Number: ");
									int ticketNo = scan.nextInt();
									System.out.println("Enter seat Number: ");
									int seatNo = scan.nextInt();

									List<Flight> avaiableFlight = Flight.avaiableFlight();
									System.out.println("<<<<<<<<choose from the Available flights>>>>>>>>");
									int pos = 1;
									for (Flight avflight : avaiableFlight) {
										System.out.println(pos++ + ". " + avflight.getFlightNo() + " : "
												+ avflight.getFlightName() + " : " + avflight.getFrom() + " : "
												+ avflight.getTo() + " : " + avflight.getDepartureDate() + " : "
												+ avflight.getArrivalDate());
									}
									
									System.out.println("Enter flight number");
									pos = scan.nextInt();
									
									flight = avaiableFlight.get(pos - 1);
									customer.setFlight(flight);
									int flightNumber = flight.getFlightNo();
									String flightName = flight.getFlightName();
									String from = flight.getFrom();
									String to = flight.getTo();
									// departureDate = flight.getDepartureDate();
									// arrivalDated = flight.getArrivalDate();

									String type = null;
									System.out.println("select from the type below");
									System.out.println("1.    economy");
									System.out.println("2.    business");
									System.out.println("3.    first class");

									int type1 = scan.nextInt();
									if (type1 == 1) {
										type = "economy";
									} else if (type1 == 2) {
										type = "business";
									} else if (type1 == 3) {
										type = "first class";
									}

									customer.bookTicket(customerIdNumber, firstName, lastName, cellPhoneNumber,
											dateOfBirth, nationality, emailAddress, numberOfTickets, emmergencyContact,
											pinCode, ticket, ticketNo, seatNo, type);
									System.out.println("price: " + ticket.getPrice());
									System.out.println(customer);
									System.out.println("Ticket book successful.");

								} else if (choice == 3) {
									System.out.println("To checkin");

									break LogoutManager;
								}

							} // end of logout loop for manager;

						} else if (!resultSet.next()) {
							System.out.println("login unsuccessful.");
						} // end of else if block for resultSet;
					} // end of while block for resultSet;
				} catch (Exception e) {
					e.printStackTrace();
				} // end of catch block;
			} // end of else if block for login option;

		} // end of main for loop;

	}// end of main method;

}
