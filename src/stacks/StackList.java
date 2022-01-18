package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackList<E> implements Iterable <E>
{
    private class Node
    {
        Node next;
        E data;

        Node(E x)
        {
            next = null;
            data = x;
        }

        E getData()
        {
            return data;
        }
    }

    private String name;
    private Node top;
    private int mSize;

    StackList(String name)
    {
        clear();
        this.name = name;
    }

    public Iterator<E> iterator()
    {
        return new StackIterator();
    }

    public void push(E x)
    {
        Node newTop = new Node(x);
        newTop.next = top;
        top = newTop;
        mSize++;
    }

    public E pop()
    {
        E retVal;
        if (isEmpty())
            throw new NoSuchElementException();
        retVal = top.getData();
        top = top.next;
        mSize--;
        return retVal;
    }

    public E peek()
    {
        if (isEmpty())
            return null;
        return top.getData();
    }

    public void clear()
    {
        top = new Node(null);
        mSize = 0;
    }

    public String toString()
    {
        int counter=0;
        String results = "";
        Iterator<E> iterator = iterator();
        results = name + " with " + mSize + " links \n[";

        if (isEmpty())
            return results += "]";
        while (iterator.hasNext())
        {
            counter++;
            if (counter - mSize == 0)
                results += iterator.next() + "]";
            else
                results += iterator.next() + ", ";
        }
        return results;
    }

    public boolean isEmpty()
    {
        return (top.getData() == null);
    }

    public int size()
    {
        return mSize;
    }

    private class StackIterator implements Iterator<E>
    {
        protected Node current;
        protected Node mLastNodeReturned;

        StackIterator()
        {
            current = top;
        }

        public E next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            mLastNodeReturned = current;
            current = current.next;
            return mLastNodeReturned.getData();
        }

        public boolean hasNext()
        {
            return (current.getData() != null);
        }
    }
}