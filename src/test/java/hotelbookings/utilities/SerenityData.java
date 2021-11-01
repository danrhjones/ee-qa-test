package hotelbookings.utilities;

import java.util.Objects;
import lombok.NoArgsConstructor;

import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class SerenityData {

    private static Logger logger = LoggerFactory.getLogger(SerenityData.class);

    public <T> void setData(DataKeys key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public <T> T getData(DataKeys key) {
        return Serenity.sessionVariableCalled(key);
    }

    private boolean keyExist(DataKeys key) {
        return Serenity.hasASessionVariableCalled(key);
    }

    private boolean keyNotExist(DataKeys key) {
        return !Serenity.hasASessionVariableCalled(key);
    }

    public boolean dataExist(DataKeys key) {
        return keyExist(key) && Objects.nonNull(getData(key));
    }

    public boolean dataNotExist(DataKeys key) {
        return keyNotExist(key) || Objects.isNull(getData(key));
    }

    public enum DataKeys {
        BASE_URL,
        BOOKING,
        THIS_ONE
    }
}
