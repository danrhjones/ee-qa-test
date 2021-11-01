package hotelbookings.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheBooking {

    public static final Target BOOKING_TABLE = Target.the("saved bookings")
        .located(By.id("bookings"));

//    public static Question<List<String>> contains() {
//        return Text.of(BOOKING_TABLE)
//            .describedAs("the bookings displayed").asAList();
//    }

    public static Question<String> contains() {
        return Text.of(BOOKING_TABLE)
            .describedAs("the bookings displayed")
            .asAString();
    }
}
