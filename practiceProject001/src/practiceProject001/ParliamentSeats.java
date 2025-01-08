package practiceProject001;

import java.util.Scanner;

public class ParliamentSeats {

	public static void main(String[] args) {
		int spd;
		int z;
		int kpd;
		int dnvp;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("SPD: ");
		spd = scanner.nextInt();
		System.out.print("Z: ");
		z = scanner.nextInt();
		System.out.print("KPD: ");
		kpd = scanner.nextInt();
		System.out.print("DNVP: ");
		dnvp = scanner.nextInt();
		scanner.close();
		
		int sum;
		sum = spd + z + kpd + dnvp;
		System.out.println("Total Seats: " + sum + "\n");
		
		while(sum > 24) {
			spd = seatsReduce(spd);
			z = seatsReduce(z);
			kpd = seatsReduce(kpd);
			dnvp = seatsReduce(dnvp);
			sum = spd + z + kpd + dnvp;
		}
		
		System.out.println("SPD: " + spd);
		System.out.println("Z: " + z);
		System.out.println("KPD: " + kpd);
		System.out.println("DNVP: " + dnvp);
		System.out.println("Total Seats: " + sum);
		
	}
	
	static int seatsReduce(int seats) {
		if(seats >= 10)
			return seats-=3;
		else if(seats >= 7)
			return seats-=2;
		else if(seats >= 4)
			return seats-=1;
		else
			return seats;
	}

}
