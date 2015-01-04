/**
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
package edu.emory.mathcs.cs323.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class BinaryHeap<T extends Comparable<T>> extends AbstractPriorityQueue<T>
{
	private List<T> l_keys;
	private int n_size;
	
	public BinaryHeap()
	{
		l_keys = new ArrayList<>();
		l_keys.add(null);
		n_size = 0;
	}

	@Override
	public int size()
	{
		return n_size;
	}

	@Override
	public void add(T key)
	{
		l_keys.add(key);
		swim(++n_size);
	}

	@Override
	public T removeMax()
	{
		throwNoSuchElementException();
		Collections.swap(l_keys, 1, n_size);
		T max = l_keys.remove(n_size--);
		sink(1);
		return max;
	}
	
	private void swim(int k)
	{
		while (k > 1 && DSUtils.compareTo(l_keys, k/2, k) < 0)
		{
			Collections.swap(l_keys, k/2, k);
			k /= 2;
		}
	}
	
	private void sink(int k)
	{
		for (int i=k*2; i<=n_size; k=i,i*=2)
		{
			if (i < n_size && DSUtils.compareTo(l_keys, i, i+1) < 0) i++;
			if (DSUtils.compareTo(l_keys, k, i) >= 0) break;
			Collections.swap(l_keys, k, i);
		}
	}
}
