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

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class LazyPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T>
{
	private List<T> l_keys;
	
	public LazyPriorityQueue()
	{
		l_keys = new ArrayList<>();
	}

	@Override
	public int size()
	{
		return l_keys.size();
	}

	@Override
	public void add(T key)
	{
		l_keys.add(key);
	}

	@Override
	public T removeMax()
	{
		throwNoSuchElementException();
		T max = Collections.max(l_keys);
		l_keys.remove(max);
		return max;
	}
}
