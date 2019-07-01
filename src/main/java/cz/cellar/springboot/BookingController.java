package cz.cellar.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;
    @Autowired
    public BookingController(BookingRepository bookingRepository){
       this.bookingRepository=bookingRepository;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CarBooking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<CarBooking> getAffordable(@PathVariable double price){
      return bookingRepository.findByPricePerDayLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<CarBooking> create(@RequestBody CarBooking carBooking){
        bookingRepository.save(carBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<CarBooking> remove(@PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }

}
