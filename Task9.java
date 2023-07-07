
public class Task9 {
    /*
    Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
     */
    public static void main(String[] args) {
        MyQueue queue =  new MyQueue();
        queue.enqueue("Сирожа маладец!");
        queue.enqueue("Сирожа умеет в джаву");
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
    }
}