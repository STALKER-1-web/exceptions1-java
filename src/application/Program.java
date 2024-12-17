package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		//primeira solução - muito ruim
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date(DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out(DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {//se checkOut não for depois de checkIn
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out(DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now)||checkOut.before(now)) {
				System.out.println("Error in reservation: Reservations dates for update for future dates.");
			}
			else if(!checkOut.after(checkIn)) {//se checkOut não for depois de checkIn
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			}
			else {
				reservation.upDateDate(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}
		sc.close();
		
	}

}
