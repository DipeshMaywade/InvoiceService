import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InvoiceService {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double COST_PER_TIME = 1.0;
    public static String INVOICESUMMARY_FILE_NAME = "invoiceSummary.txt";


    public double CalculateFare(double dis, double time) {

        double fare = (dis*MINIMUM_COST_PER_KM)+(time*COST_PER_TIME);
        return fare >= 5 ? fare : 5;
    }

    public InvoiceSummary CalculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            double fare = this.CalculateFare(ride.dis, ride.time);
            totalFare = totalFare+fare;
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public String invoiceList(int rideID) {
            try{
                String line = Files.readAllLines(Paths.get(INVOICESUMMARY_FILE_NAME)).get((rideID-1));
                return line;
            }
            catch(IOException e){
                System.out.println(e);
                return null;
            }
    }
}
