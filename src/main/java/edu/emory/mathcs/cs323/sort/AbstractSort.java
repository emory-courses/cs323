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
package edu.emory.mathcs.cs323.sort;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractSort<T extends Comparable<T>>
{
	protected long n_comparisons;
	protected long n_assignments;
	
	public AbstractSort()
	{
		resetCounts();
	}
	
	/**
	 * Sorts the array in ascending order.
	 * @param array an array of comparable keys.
	 */
	public void sort(T[] array)
	{
		sort(array, 0, array.length);
	}
	
	/**
	 * Sorts the array[beginIndex:endIndex] in ascending order.
	 * @param array an array of comparable keys.
	 * @param beginIndex the index of the first key to be sorted (inclusive).
	 * @param endIndex the index of the last key to be sorted (exclusive).
	 */
	abstract public void sort(T[] array, int beginIndex, int endIndex);
	
	public void resetCounts()
	{
		n_comparisons = 0;
		n_assignments = 0;
	}
	
	/** @return the total number of comparisons performed by this sort. */
	public long getComparisonCount()
	{
		return n_comparisons;
	}
	
	/** @return the total number of assignments performed by this sort. */
	public long getAssignmentCount()
	{
		return n_assignments;
	}
	
	/**
	 * @param array an array of comparable keys.
	 * @param i the index of the first key.
	 * @param j the index of the second key.
	 * @return {@code array[i].compareTo(array[j])}
	 */
	protected int compareTo(T[] array, int i, int j)
	{
		n_comparisons++;
		return array[i].compareTo(array[j]);
	}
	
	/**
	 * {@code array[index] = value}
	 * @param array an array of comparable keys.
	 * @param index the index of the array to assign.
	 * @param value the value to be assigned.
	 */
	protected void assign(T[] array, int index, T value)
	{
		n_assignments++;
		array[index] = value;
	}
	
	/**
	 * Swaps {@code array[i]} and {@code array[j]}. 
	 * @param array an array of comparable keys.
	 * @param i the index of the first key.
	 * @param j the index of the second key.
	 */
	protected void swap(T[] array, int i, int j)
	{
		T t = array[i];
		assign(array, i, array[j]);
		assign(array, j, t);
	}
}
