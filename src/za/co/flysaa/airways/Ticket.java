package za.co.flysaa.airways;

public class Ticket {
	private int ticketNo;
    private int seatNo;
    private double price;
    private String type;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int ticketNo, int seatNo, double price, String type) {
		super();
		this.ticketNo = ticketNo;
		this.seatNo = seatNo;
		this.price = price;
		this.type = type;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", seatNo=" + seatNo + ", price="
				+ price + ", type=" + type + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + seatNo;
		result = prime * result + ticketNo;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Ticket other = (Ticket) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seatNo != other.seatNo)
			return false;
		if (ticketNo != other.ticketNo)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
