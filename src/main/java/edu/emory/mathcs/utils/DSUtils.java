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
package edu.emory.mathcs.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/** @author Jinho D. Choi ({@code jinho.choi@emory.edu}) */
public class DSUtils
{
	static public List<Integer> toIntegerList(int... array)
	{
		List<Integer> list = new ArrayList<>(array.length);
		for (int item : array) list.add(item);
		return list;
	}
	
	static public Integer[] toIntegerArray(int... array)
	{
		Integer[] nArray = new Integer[array.length];
		for (int i=0; i<array.length; i++) nArray[i] = array[i];
		return nArray;
	}
	
	static public <T>List<T> toList(T[] array)
	{
		List<T> list = new ArrayList<>(array.length);
		for (T item : array) list.add(item); 
		return list;
	}
	
	static public List<Integer> getRandomIntegerList(Random rand, int size)
	{
		return getRandomIntegerList(rand, size, Integer.MAX_VALUE);
	}
	
	static public List<Integer> getRandomIntegerList(Random rand, int size, int range)
	{
		List<Integer> list = new ArrayList<>(size);
		
		for (int i=0; i<size; i++)
			list.add(rand.nextInt(range));
		
		return list;
	}
	
	static public Integer[] getRandomIntegerArray(Random rand, int size)
	{
		return getRandomIntegerArray(rand, size, Integer.MAX_VALUE);
	}
	
	static public Integer[] getRandomIntegerArray(Random rand, int size, int range)
	{
		Integer[] array = new Integer[size];
		
		for (int i=0; i<size; i++)
			array[i] = rand.nextInt(range);
		
		return array;
	}
	
	static public int[] getRandomIntArray(Random rand, int size)
	{
		int[] array = new int[size];
		
		for (int i=0; i<size; i++)
			array[i] = rand.nextInt();
		
		return array;
	}
	
	static public <T extends Comparable<T>>int compareTo(List<T> list, int i, int j)
	{
		return list.get(i).compareTo(list.get(j));
	}
	
	static public <T>boolean equals(T[] array1, T[] array2)
	{
		if (array1.length != array2.length) return false;
		int i, len = array1.length;
		
		for (i=0; i<len; i++)
		{
			if (!array1[i].equals(array2[i]))
				return false;
		}
		
		return true;
	}
	
	static public <T>List<T> createNullList(int length)
	{
		List<T> list = new ArrayList<T>(length);
		for (int i=0; i<length; i++) list.add(null);
		return list;
	}
	
	static public <T>boolean equals(List<T> a, List<T> b)
	{
		if (a.size() != b.size()) return false;
		int i, size = a.size();
		
		for (i=0; i<size; i++)
		{
			if (!a.get(i).equals(b.get(i)))
				return false;
		}
		
		return true;
	}
	
	static public <T>List<?>[] createEmptyListArray(int size)
	{
		List<?>[] array = new ArrayList<?>[size];
		
		for (int i=0; i<size; i++)
			array[i] = new ArrayList<T>();
		
		return array;
	}
	
	static public <T>Deque<?>[] createEmptyDequeArray(int size)
	{
		Deque<?>[] deque = new ArrayDeque<?>[size];
		
		for (int i=0; i<size; i++)
			deque[i] = new ArrayDeque<T>();
		
		return deque;
	}
	
	static public <T>Set<?>[] createEmptySetArray(int size)
	{
		Set<?>[] set = new HashSet<?>[size];
		
		for (int i=0; i<size; i++)
			set[i] = new HashSet<T>();
		
		return set;
	}
	
	static public <K,V>Map<?,?>[] createEmptyMapArray(int size)
	{
		Map<?,?>[] map = new HashMap<?,?>[size];
		
		for (int i=0; i<size; i++)
			map[i] = new HashMap<K,V>();
		
		return map;
	}
	
	static public <T>PriorityQueue<?>[] createEmptyPriorityQueueArray(int size)
	{
		PriorityQueue<?>[] queue = new PriorityQueue<?>[size];
		
		for (int i=0; i<size; i++)
			queue[i] = new PriorityQueue<T>();
		
		return queue;
	}
	
	static <T>void swap(T[] array, int i, int j)
	{
		T t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	static public <T>void shuffle(T[] array, Random rand)
	{
		int i, j, size = array.length - 1;
		
		for (i=0; i<size; i++)
		{
			j = rand.nextInt(size - i) + i + 1;
			swap(array, i, j);
		}
	}
}
