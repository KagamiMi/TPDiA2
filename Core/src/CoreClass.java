import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class CoreClass {
	static int portNumber = 7;
	
	public static void main(String args[]) throws ClassNotFoundException {
		try
		{
			ServerSocket ss = new ServerSocket(portNumber,10);
			System.out.println("created socket server ");
			while (true) {
				Socket cs = ss.accept();
				System.out.println("Connected to new client");
				ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
				new SocketHandler(is).start();
				System.out.println("New thread running!");
			}
			
//			za pomoc� JPQL
//			mamy interwa� czasowy t
//			tank measures zawiera "prawid�owe warto�ci"
//			obliczamy warto�� ko�cow� po interwale i por�wnujemy z warto�ci� ko�cow� z tank measures
//			dla ka�dego z tank�w osobno!
//			
//			dla danego tanka w danej chwili czasu startowej, to samo b�dzie dla ko�cowego tylko z inn� dat�
//			double startFuelVolume = em.createQuery("SELECT t.fuelVolume from TankMeasures t WHERE t.tankId=:tankId AND t.date=:date").setParameter("tankId",tankId).setParameter("date",date).getSingleResult();
//			
//			musimy uzwgl�dni� sprzeda� (sales) w tym okresie czasu. 
//			status - 1 od�o�ony, 0 podniesiony
//			literCounter - bie��cy licznik transkacji (status 0)
//			totalCounter - ko�cowy licznik transakcji (status 1)
//			podczas 0 musimy zwraca� uwag� na poprzedni stan aby odj�� dobr� warto��: literCounter - poprzedni_literCounter z pomiaru (mo�e by� ze statusu 1 gdy to pierwszy raz w serii), 
//			podczas 1 jesli mamy totalCounter to odejmujemy ostatni literCounter ze statusem 0
//			dopiero t� warto�� mo�emy odj�� od warto�ci startowej
//			
//			przy dostawach paliwa podobny problem - po pierwsze w jakiej jednostce jest szybko�c tankowania?!
//			musimy sami na podstawie szybko�ci obliczy� czy paliwo zosta�o ju� wpompowane i ile  i czy jest jeszcze co pompowa�
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
