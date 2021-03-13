import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double COST_PER_TIME = 1.0;

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

    public InvoiceSummaryWithId invoiceList(int rideID) {
        Map<Integer, InvoiceSummaryWithId> summaryMap = new HashMap<>();
        InvoiceSummaryWithId summary = new InvoiceSummaryWithId(2,30.0,1);
        InvoiceSummaryWithId summary2 = new InvoiceSummaryWithId(1,30.2,2);
        InvoiceSummaryWithId summary3 = new InvoiceSummaryWithId(1,30.2,2);
        summaryMap.put(1,summary);
        summaryMap.put(2,summary2);
        summaryMap.put(3,summary3);

        Collection<InvoiceSummaryWithId> values = summaryMap.values();
        InvoiceSummaryWithId[] targetArray = values.toArray(new InvoiceSummaryWithId[0]);
        return targetArray[rideID-1];
    }
}
