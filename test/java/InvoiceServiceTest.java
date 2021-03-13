import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceServiceTest {

    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDisAndTime_shouldReturn_totalFate() {
        double fare = invoiceService.CalculateFare(10.0 , 30.1);
       Assert.assertEquals(130.1 , fare,0.0);
    }

    @Test
    public void givenMultipleDisAndTime_shouldReturn_InvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceService.CalculateFare(rides);
        InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserID_shouldReturn_invoiceList() {
        int rideId= 2;
        InvoiceSummaryWithId summary = invoiceService.invoiceList(rideId);
        InvoiceSummaryWithId expectedInvoiceSummary = new InvoiceSummaryWithId(1,30.2,2);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}
