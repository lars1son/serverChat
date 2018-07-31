package operators;

import com.google.gson.Gson;
import model.Message;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

/**
 * Created by Артем on 31.07.2018.
 */public class Encoder implements javax.websocket.Encoder.Text<Message> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Message message) throws EncodeException {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}