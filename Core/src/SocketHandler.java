import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler extends Thread {

	ObjectInputStream is;
	
	public SocketHandler(ObjectInputStream is) {
		this.is = is;
	}
	
	public void run() {
		try {

			String className = (String)is.readObject();
			switch (className) {
			case "nozzleMeasure":
				nozzleMeasure();
				break;
			case "tankMeasure":
				tankMeasure();
				break;
			case "refuel":
				refuel();
				break;
			default:
				break;
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void nozzleMeasure() throws ClassNotFoundException, IOException {
		while (true) {
			NozzleMeasure temp = (NozzleMeasure)is.readObject();
			System.out.println(temp.date + " " + temp.locationId + " " + temp.gunId + " " + temp.tankId
					+ " "+ temp.literCounter + " " + temp.totalCounter + " " + temp.status);
		}
	}
	
	private void tankMeasure() throws ClassNotFoundException, IOException {
		while (true) {
			TankMeasure temp = (TankMeasure)is.readObject();
			System.out.println(temp.date + " " + temp.locationId + " " + temp.meterId + " " + temp.tankId
					+ " "+ temp.fuelHeight + " " + temp.fuelVolume + " " + temp.fuelTemperature + " " + temp.waterHeight + " " + temp.waterVolume);
		}
	}
	private void refuel() throws ClassNotFoundException, IOException {
		while (true) {
			Refuel temp = (Refuel)is.readObject();
			System.out.println(temp.date + " " + temp.tankId + " " + temp.fuelVolume + " " + temp.speed);
		}
	}
}
