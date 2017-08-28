/*
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractPriorityQueue<T extends Comparable<T>>
{
    protected Comparator<T> comparator;

    public AbstractPriorityQueue(Comparator<T> comparator)
    {
        this.comparator = comparator;
    }

    /** @param key a comparable key to be added. */
    abstract public void add(T key);

    /**
     * @return the key with the highest priority.
     * @throws NoSuchElementException if the queue is empty.
     */
    abstract protected T removeAux();

    /** @return the size of this queue. */
    abstract public int size();

    /** @return {@code true} if the queue is empty; otherwise, {@code false}. */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    public T remove()
    {
        if (isEmpty()) throw new NoSuchElementException("No key exists.");
        return removeAux();
    }
}
