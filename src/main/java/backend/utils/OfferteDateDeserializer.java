package backend.utils;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Date;

public class OfferteDateDeserializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        long timestamp = json.getAsJsonPrimitive().getAsLong();
        return new Date(timestamp);
    }
}
