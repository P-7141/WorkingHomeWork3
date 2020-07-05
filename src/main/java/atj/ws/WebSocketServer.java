package atj.ws;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

@ServerEndpoint(value = "/chatendpoint/{user}")//, encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class WebSocketServer {

	private static final ConcurrentLinkedQueue<Session> sessions = new ConcurrentLinkedQueue<>();

	@OnOpen
	public void onOpen(Session session) {
		sessions.add(session);
	}


	@OnMessage
	public void onMessage(String message, Session session, @PathParam("user") String userName)
			throws EncodeException {
		try {
			for (Session aSession : sessions) {
				if (!aSession.equals(session)) {
					aSession.getBasicRemote().sendText(message + ": " + message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		// System.out.println(closeReason.getReasonPhrase());
		sessions.remove(session);
	}

	@OnError
	public void onError(Throwable error) {
	}

}
