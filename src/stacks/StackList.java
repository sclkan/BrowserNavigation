package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to create singly linked list.  This class provides the methods to manipulate StackList type objects
 * @author Sean Kan
 *
 * @param <E>
 */
public class StackList<E> implements Iterable <E>
{
    /**
     * Inner class that holds the data for each item in the StackList object
     */
    private class Node
    {
        Node next;
        E data;

        /**
         * Constructor
         * @param x   The element to insert
         */
        Node(E x)
        {
            next = null;
            data = x;
        }

        /**
         * Returns the data of Node
         * @return   The generic data of the Node
         */
        E getData()
        {
            return data;
        }
    }

    private String name;
    private Node top;
    private int mSize;

    /**
     * Constructor that initializes attributes
     * @param name   Name of the StackList
     */
    StackList(String name)
    {
        clear();
        this.name = name;
    }

    /**
     * StackList iterator
     * @return   A new StackIterator
     */
    public Iterator<E> iterator()
    {
        return new StackIterator();
    }

    /**
     * Add data to the top of the stack
     * @param x   An item that will be added to the top of the stack
     */
    public void push(E x)
    {
        Node newTop = new Node(x);
        newTop.next = top;
        top = newTop;
        mSize++;
    }

    /**
     * Removes the item from the top of the stack
     * @return   The removed item
     */
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

    /**
     * Returns the top of stack without actually removing that element
     * @return  The generic item at the top of the stack or null if empty
     */
    public E peek()
    {
        if (isEmpty())
            return null;
        return top.getData();
    }

    /**
     * Empties the stack
     */
    public void clear()
    {
        top = new Node(null);
        mSize = 0;
    }

    /**
     * Converts data to string
     * @return  A string with the name of the list with its size and items formatted
     */
    public String toString()
    {
        int counter=0;
        String results = "";
        Iterator<E> iterator = iterator();
        results = name + " with " + mSize + " links \n[";

        //Returns an empty bracket if there is no data
        if (isEmpty())
            return results += "]";

        //Formats it nicely if there is data in stack
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

    /**
     * Checks if the top of the stack is pointing to anything
     * @return  A boolean that indicates whether stack is empty
     */
    public boolean isEmpty()
    {
        return (top.getData() == null);
    }

    /**
     * Returns stack size
     * @return   An integer that indicates the size of the list
     */
    public int size()
    {
        return mSize;
    }

    /**
     * An inner class that is used to traverse the StackList
     */
    private class StackIterator implements Iterator<E>
    {
        protected Node current;
        protected Node mLastNodeReturned;

        /**
         * Constructor
         */
        StackIterator()
        {
            current = top;
        }

        /**
         * Returns current node and moves the cursor forward
         * @return   The data of current node
         */
        public E next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            mLastNodeReturned = current;
            current = current.next;
            return mLastNodeReturned.getData();
        }

        /**
         * Traverses list and checks if there is a following node
         * @return   A boolean that indicates whether there is a next node
         */
        public boolean hasNext()
        {
            return (current.getData() != null);
        }
    }
}