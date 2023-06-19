package com.fatina.wckunder.service;

import com.fatina.wckunder.VO.Exchange;
import com.fatina.wckunder.VO.ResponseTemplateVO;
import com.fatina.wckunder.model.Booking;
import com.fatina.wckunder.model.User;
import com.fatina.wckunder.repo.BookingRepository;
import com.fatina.wckunder.repo.BookingServiceRepository;
import com.fatina.wckunder.repo.CarRepository;
import com.fatina.wckunder.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingService implements BookingServiceRepository {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarRepository carRepository;
  @Autowired
    private RestTemplate restTemplate;


    @Override
    public Booking saveBooking(Booking booking) {
        booking.setDays((int) DAYS.between(booking.getStartDay(),booking.getEndDay())+1); // +1 för vi räknar heldag
        booking.setPrice(booking.getDays() * carRepository.findById(booking.getCarId()).get().getPricePerDay());
        return bookingRepository.save(booking);
    }
    @Override
    public  List<Booking> getAllBookings() {return bookingRepository.findAll();}


    @Override
    public List<Booking> getBookingById(User user) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("UserId not found")));;
        List<Booking> bookings =  foundUser.get().getUserBookings();
        return bookings;
    }


    @Override
    public Booking updateBooking(Booking booking) {
        Booking b = bookingRepository.findById(booking.getBookingId()).orElseThrow(() -> new RuntimeException("BookingId not found"));
        b.setStartDay(booking.getStartDay());
        b.setEndDay(booking.getEndDay());
        b.setUserId(booking.getUserId());
        b.setCarId(booking.getCarId());
        bookingRepository.save(b);
        return b;
    }
    @Override
    public Booking cancelBooking(Booking booking) {
        Booking b = bookingRepository.findById(booking.getBookingId()).orElseThrow(() -> new RuntimeException("BookingId not found"));
       //changes to new value
        b.setCanceled(booking.isCanceled());
       //sets old value
        b.setBookingId(b.getBookingId());
        b.setStartDay(b.getStartDay());
        b.setEndDay(b.getEndDay());
        b.setUserId(b.getUserId());
        b.setCarId(b.getCarId());
        return bookingRepository.save(b);

    }

    // for Exchange ms

    public ResponseTemplateVO getBookingWithExchange(Booking booking){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Booking foundBooking = bookingRepository.findById(booking.getBookingId()).get();
        Exchange exchange = restTemplate.getForObject("http://EXCHANGE-SERVICE/exchange/" + foundBooking.getPrice(), Exchange.class);
        vo.setBooking(foundBooking);
        vo.setExchange(exchange);
        return vo;

    }

}
