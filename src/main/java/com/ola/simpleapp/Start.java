package com.ola.simpleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.ola.simpleapp.Color.PINK;

@Component
public class Start {

    private CarRepo carRepo;

    @Autowired
    public Start (CarRepo carRepo) {

        this.carRepo = carRepo;
    }


        @EventListener(ApplicationReadyEvent.class)  //uruchomienie po starcie aplikacji
        public void runExample () {
          Car car1 = new Car("audi", "a8",Color.WHITE);
          Car car2 = new Car("bmw", "x5",Color.BLUE);
          Car car3 = new Car("mazda", "cx5",Color.PINK);
          carRepo.save(car1);
          carRepo.save(car1);
          carRepo.save(car3);
    //      carRepo.deleteById(6L);
          Iterable<Car> all = carRepo.findAll();
           // Iterable<Car> all = carRepo.findAllByColor(PINK);// wyswitelenie w konsoli obiektow w kolorze pink
            all.forEach(System.out::println); //pobieranie rekordow z DB i wystetlenie w konosli
        }

}
