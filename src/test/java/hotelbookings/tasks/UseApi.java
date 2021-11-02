package hotelbookings.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class UseApi implements Performable {

    public static Performable toDeleteBooking() {
        return Instrumented.instanceOf(UseApi.class).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        String fakeBookingId = String.valueOf(faker.number().randomNumber(5, true));

        actor.attemptsTo(
            Delete.from("booking/" + fakeBookingId)
                .with(request -> request.log().all()
                    .header("Host", " hotel-test.equalexperts.io")
                    .header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                )
        );
    }
}
