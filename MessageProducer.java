package ThreadSafety;

/**
 * Created by vineshroshan on 4/13/16.
 */
public class MessageProducer implements Runnable{
    private MessageQueue messageQueue;
    String message;

    MessageProducer(MessageQueue messageQueue, String message) {
        this.messageQueue = messageQueue;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageQueue getMessageQueue() {
        return messageQueue;
    }

    public void run() {
        messageQueue.enqueue(this.message);
    }
}
