package ThreadSafety;

/**
 * Created by vineshroshan on 4/13/16.
 */
public interface IMessageQueue {
    void remove(Message item);
    Message peek();
    Message dequeue();
    Message enqueue(String messageBody);
}
