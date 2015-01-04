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

import java.util.Arrays;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T>
{
	private T[] l_temp;	// n-extra spaces
	
	@Override
	public void sort(T[] array, int beginIndex, int endIndex)
	{
		if (beginIndex + 1 >= endIndex) return;
		int middleIndex = beginIndex + (endIndex - beginIndex) / 2;

		//Sort left partition
		sort (array, beginIndex, middleIndex);
		//Sort Right partition
		sort (array, middleIndex, endIndex);
		//Merge partitions
		merge(array, beginIndex, middleIndex, endIndex);
	}
	
	/**
	 * @param beginIndex the beginning index of the 1st half (inclusive).
	 * @param middleIndex the ending index of the 1st half (exclusive).
	 * @param endIndex the ending index of the 2nd half (exclusive).
	 */
	private void merge(T[] array, int beginIndex, int middleIndex, int endIndex)
	{
		int fst = beginIndex, snd = middleIndex;
		copy(array);
		
		for (int k=beginIndex; k<endIndex; k++)
		{
			if (fst >= middleIndex)						// no key left in the 1st half
				assign(array, k, l_temp[snd++]);
			else if (snd >= endIndex)					// no key left in the 2nd half
				assign(array, k, l_temp[fst++]);
			else if (compareTo(l_temp, fst, snd) < 0)	// 1st key < 2nd key
				assign(array, k, l_temp[fst++]);
			else
				assign(array, k, l_temp[snd++]);
		}
	}
	
	private void copy(T[] array)
	{
		final int N = array.length;
		n_assignments += N;
		
		if (l_temp == null || l_temp.length < N)
			l_temp = Arrays.copyOf(array, N);
		else
			System.arraycopy(array, 0, l_temp, 0, N);
	}
}
