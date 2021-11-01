package hotelbookings.models;

import static hotelbookings.utilities.SerenityData.DataKeys.BOOKING;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.serenitybdd.core.Serenity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {
        private Long bookingid;
        private String firstname;
        private String lastname;
        private Double totalprice;
        private Boolean depositpaid;
        private Dates bookingdates;


        public Booking booking() {
                Faker faker = new Faker();
                Booking booking = new Booking();
                booking.setFirstname(faker.name().firstName());
                booking.setLastname(faker.name().lastName());
                booking.setDepositpaid(faker.bool().bool());
                booking.setTotalprice(faker.number().randomDouble(2, 100, 1000));

                Date from = faker.date().future(5, TimeUnit.DAYS);
                booking.setBookingDates(
                    faker.date().future(5, TimeUnit.DAYS),
                    faker.date().future(5, TimeUnit.DAYS, from)
                );

                Serenity.setSessionVariable(BOOKING).to(booking);


                return booking;
        }

        public void setBookingDates(Date from, Date until) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Dates dates = new Dates();
                dates.setCheckin(simpleDateFormat.format(from));
                dates.setCheckout(simpleDateFormat.format(until));

                this.bookingdates = dates;
        }
}
