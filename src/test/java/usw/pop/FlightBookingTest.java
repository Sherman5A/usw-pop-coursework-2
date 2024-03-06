package usw.pop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlightBookingTest {
    private Flight testFlight;
    private FlightBooking testFlightBooking;


    @Test
    @DisplayName("Check-in process with an on-time flight booking")
    public void checkIn() {
        LocalDateTime earlyDateTime = LocalDateTime.now().plusYears(1);
        /*
         Create a mocked class of testFlight
         testFlight could use an API for plane tracking, so mocking
         ensures that the test is independent
        */
        testFlight = Mockito.mock(Flight.class);
        Mockito.when(testFlight.getFlightStart()).thenReturn(earlyDateTime);

        testFlightBooking = new FlightBooking(testFlight, "economy", 12, 200);
        assertTrue(testFlightBooking.checkIn());
    }

    @Test
    @DisplayName("Check-in process with a late flight booking")
    public void checkInLate() {
        LocalDateTime lateDateTime = LocalDateTime.now().minusYears(1);

        // Create another mocked class
        testFlight = Mockito.mock(Flight.class);
        // Set return time to the future to fail check-in
        Mockito.when(testFlight.getFlightStart()).thenReturn(lateDateTime);

        // Call the check-in process
        testFlightBooking = new FlightBooking(testFlight, "economy", 12, 200);
        assertFalse(testFlightBooking.checkIn());
    }
}