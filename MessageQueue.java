package ThreadSafety;

import java.util.Hashtable;

/**
 * Created by vineshroshan on 4/13/16.
 */
public class MessageQueue implements IMessageQueue {
    Hashtable<Integer, Message> hashtable = new Hashtable();
    Hashtable<Message, Integer> reverseHashtable = new Hashtable();
    private volatile int messageCount;


    public void remove(Message item) {
        synchronized (this) {
            hashtable.remove(reverseHashtable.get(item));
            reverseHashtable.remove(item);
        }
    }

    public Message peek() {
        return this.hashtable.get(messageCount);
    }

    public Message dequeue() {
        Message message = null;
        synchronized (this) {
            if (messageCount > 0) {
                this.reverseHashtable.remove(this.hashtable.get(messageCount));
                message = this.hashtable.remove(messageCount);

            }

        }
        return message;
    }

    public Message enqueue(String messageBody) {
        Message message = new Message();
        message.setBody(messageBody);
        synchronized (this) {
            this.hashtable.put(messageCount, message);
            this.reverseHashtable.put(message, messageCount);
            messageCount++;

        }
        return message;
    }
}
