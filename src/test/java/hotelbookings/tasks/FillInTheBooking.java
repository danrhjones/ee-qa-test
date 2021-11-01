package hotelbookings.tasks;


import com.github.javafaker.Faker;
import hotelbookings.models.Booking;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class FillInTheBooking implements Performable {

    private Faker faker = new Faker();

    public static final Target FIRST_NAME = Target.the("campaign name field").located(By.id("firstname"));
    public static final Target LAST_NAME = Target.the("campaign name field").located(By.id("lastname"));
    public static final Target PRICE = Target.the("campaign name field").located(By.id("totalprice"));
    public static final Target DEPOSIT = Target.the("campaign name field").located(By.id("depositpaid"));
    public static final Target CHECKIN = Target.the("campaign name field").located(By.id("checkin"));
    public static final Target CHECKOUT = Target.the("campaign name field").located(By.id("checkout"));

    private static String firstName;
    private static String lastName;
    private static Double price;
    private static Boolean depositPaid;
    private static String checkin;
    private static String checkout;

    public static Performable withTheirInformation(Booking booking) {
        firstName = booking.getFirstname();
        lastName = booking.getLastname();
        price = booking.getTotalprice();
        depositPaid = booking.getDepositpaid();
        checkin = booking.getBookingdates().getCheckin();
        checkout = booking.getBookingdates().getCheckout();


        return Instrumented.instanceOf(FillInTheBooking.class).withProperties(booking);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(FIRST_NAME),
            Enter.theValue(lastName).into(LAST_NAME),
            Enter.theValue(price.toString()).into(PRICE),
//            Enter.theValue(depositPaid).into(DEPOSIT),
            Enter.theValue(checkin).into(CHECKIN),
            Enter.theValue(checkout).into(CHECKOUT)
        );
    }
}
