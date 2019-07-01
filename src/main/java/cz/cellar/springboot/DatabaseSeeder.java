package cz.cellar.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       List<CarBooking> bookings = new ArrayList<>();

        bookings.add(new CarBooking("Skoda Octavia v2", 3500.0, 2));

        bookings.add(new CarBooking("Ferrari 950c", 9000.0, 1));

        bookings.add(new CarBooking("Mercedes Benz", 4500.0, 4));

        bookingRepository.saveAll(bookings);

    }
}
