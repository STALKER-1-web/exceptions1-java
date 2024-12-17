package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public String upDateDate(Date checkIn, Date checkOut) {//deixa de ser void para retornar (String)mensagem
		Date now = new Date();
		if(checkIn.before(now)||checkOut.before(now)) {//se entrada ou saida forem antes(before)de agora 
			return " Reservations dates for must be future dates.";
		}
		else if(!checkOut.after(checkIn)) {//se checkOut !não for depois de checkIn(em portugues claro: se a saida for antes da entrada)
			return "Check-out date must be after check-in date.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;//se retornar nulo é pq as falhas não ocorreram
		
	}

	@Override
	public String toString() {
		return "Room "
			  + roomNumber
			  + ", check-in: "
			  + sdf.format(checkIn)
			  + ", check-out: "
			  + sdf.format(checkOut)
			  + ", "
			  + duration()
			  + " nights";
	}
	
	

}
