package operators;

import com.google.gson.Gson;
import model.Message;

import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

/**
 * Created by Артем on 31.07.2018.
 */
public class Decoder implements javax.websocket.Decoder.Text<Message> {

    private static Gson gson = new Gson();

    @Override
    public Message decode(String s) throws DecodeException {
        return gson.fromJson(s, Message.class);
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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