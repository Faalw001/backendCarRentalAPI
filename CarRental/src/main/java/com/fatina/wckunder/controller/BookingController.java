package com.fatina.wckunder.controller;

import com.fatina.wckunder.VO.ResponseTemplateVO;
import com.fatina.wckunder.model.Booking;
import com.fatina.wckunder.model.Car;
import com.fatina.wckunder.model.User;
import com.fatina.wckunder.repo.BookingRepository;
import com.fatina.wckunder.repo.CarRepository;
import com.fatina.wckunder.service.BookingService;
import com.fatina.wckunder.service.CarService;
import com.fatina.wckunder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

        @Autowired
        private BookingService bookingService;
        @Autowired
        private BookingRepository bookingRepository;


        @PostMapping(value="/ordercar")
        public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
            return new ResponseEntity<Booking>(bookingService.saveBooking(booking), HttpStatus.CREATED);
        }
        @GetMapping(value="/orders")
        public List<Booking> getAllBookings(){return bookingService.getAllBookings();}

        @GetMapping(value="/myorders")
       public List<Booking> getBookingById(@RequestBody User user){
                return bookingService.getBookingById(user);}


        @PutMapping("/updateorder")
        public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
                return new ResponseEntity<Booking>(bookingService.updateBooking(booking), HttpStatus.OK);

        }

        @PutMapping("/cancelorder")
        public ResponseEntity<Booking> cancelBooking(@RequestBody Booking booking){
             return new  ResponseEntity<Booking>(bookingService.cancelBooking(booking), HttpStatus.OK);
        }


        @GetMapping("/exchange")
        public ResponseTemplateVO getBookingWithExchange(@RequestBody  Booking booking){
                return bookingService.getBookingWithExchange(booking);
        }


}
