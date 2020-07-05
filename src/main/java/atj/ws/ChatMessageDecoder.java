package atj.ws;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {
	private ChatMessage chatMessage;

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public ChatMessage decode(String jsonMsg) throws DecodeException {
		if (willDecode(jsonMsg)) {
			return chatMessage;
		}
		return null;
	}

	@Override
	public boolean willDecode(String jsonMsg) {
		try {
			chatMessage = JsonbBuilder.create().fromJson(jsonMsg, ChatMessage.class);
		} catch (JsonbException e) {
			return false;
		}
		return true;
	}
}
