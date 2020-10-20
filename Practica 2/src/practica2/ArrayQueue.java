package practica2;

public class ArrayQueue<T> implements Queue<T> {
    int front;
    int rear;
    T[] queue;

    public ArrayQueue(int initialCapacity){
        if(initialCapacity<1)
            throw new IllegalArgumentException("inicialCampacity must be > 1");
        queue = (T[]) new Object[initialCapacity +1 ];
        front = rear= 0;
    }

    public ArrayQueue(){
        this(10);
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public T getFrontElement(){
        if(isEmpty()) return null;
        else return queue[(front + 1)% queue.length];
    }

    public T getRearElement(){
        if (isEmpty()) return null;
        else return queue[rear];
    }

    public void put(T theElement){
        if((rear+1)%queue.length==front){
            T[] newQueue=(T[]) new Object[2*queue.length];
            int start=(front+1)%queue.length;
            if(start<2) System.arraycopy(queue, start, newQueue, 0, queue.length-1);
            else{
                System.arraycopy(queue, start, newQueue, 0, queue.length-start);
                System.arraycopy(queue, 0, newQueue, queue.length-start, rear+1);
            }
            front=newQueue.length-1;
            rear=queue.length-2;
            queue=newQueue;
        }
        rear=(rear+1)%queue.length;
        queue[rear]=theElement;
    }

    public T remove(){
        if (isEmpty()) return null;
        front=(front+1)%queue.length;
        T frontElement=queue[front];
        queue[front]=null;
        return frontElement;
    }

}