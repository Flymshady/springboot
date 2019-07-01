package cz.cellar.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository  extends JpaRepository<CarBooking, Long> {

    List<CarBooking> findByPricePerDayLessThan(double price);
}
