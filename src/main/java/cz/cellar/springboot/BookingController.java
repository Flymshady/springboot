package cz.cellar.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private List<CarBooking> bookings;

    public BookingController(){
        bookings = new ArrayList<>();

        bookings.add(new CarBooking("Skoda Octavia v2", 3500.0, 2));

        bookings.add(new CarBooking("Ferrari 950c", 9000.0, 1));

        bookings.add(new CarBooking("Mercedes Benz", 4500.0, 4));

    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CarBooking> getAll(){
        return bookings;
    }

    @RequestMapping(value = "/affordable/{cena}", method = RequestMethod.GET)
    public List<CarBooking> getAffordable(@PathVariable double price){
        return bookings.stream().filter(x->x.getPricePerDay()<=price).collect(Collectors.toList());

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<CarBooking> create(@RequestBody CarBooking carBooking){
        bookings.add(carBooking);
        return bookings;
    }

}
