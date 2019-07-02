package cz.cellar.springboot;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
@Api(name="Car Booking API", description = "Provides a list of methods that manage car bookings", stage = ApiStage.PRE_ALPHA)
public class BookingController {

    private BookingRepository bookingRepository;
    @Autowired
    public BookingController(BookingRepository bookingRepository){
       this.bookingRepository=bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all car bookings from the database")
    public List<CarBooking> getAll(){
        return bookingRepository.findAll();
    }

    @ApiMethod(description = "Get all car bookings where the price per day is less than provided value")
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<CarBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price){
      return bookingRepository.findByPricePerDayLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a car booking and save it to the database")
    public List<CarBooking> create(@RequestBody CarBooking carBooking){
        bookingRepository.save(carBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the car booking with the provided id from the database")
    public List<CarBooking> remove(@ApiPathParam(name = "id")@PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }

}
