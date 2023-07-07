import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    // enqueue() - помещает элемент в конец очереди,
    // dequeue() - возвращает первый элемент из очереди и удаляет его,
    // first() - возвращает первый элемент из очереди, не удаляя.
    Queue<String> queue = new LinkedList<>();

    void enqueue(String item){
        queue.add(item);
    }

    String dequeue(){
        if (queue.size()==0)
            return null;

        return queue.remove();
    }
    
    String first(){
        return queue.peek();
    }
}