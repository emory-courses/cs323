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
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T>
{
	@Override
	public void sort(T[] array, int beginIndex, int endIndex)
	{
		if (beginIndex + 1 < endIndex)	// more than one key in the range
		{
			//Sort current partition
			int pivotIndex = partition(array, beginIndex, endIndex);
			
			//Sort left partition
			sort(array, beginIndex, pivotIndex);
			//Sort right partition
			sort(array, pivotIndex+1, endIndex);
		}
	}
	
	protected int partition(T[] array, int beginIndex, int endIndex)
	{
		int fst = beginIndex, snd = endIndex;
		
		while (true)
		{
			while (++fst < endIndex   && compareTo(array, beginIndex, fst) >= 0);	// Find where endIndex > fst > pivot 
			while (--snd > beginIndex && compareTo(array, beginIndex, snd) <= 0);	// Find where beginIndex < snd < pivot
			if (fst >= snd) break;
			swap(array, fst, snd);
		}

		swap(array, beginIndex, snd);
		return snd;
	}
	
	protected int getMaxDepthForIntroSort(int beginIndex, int endIndex)
	{
		return 2 * (int)log2(endIndex - beginIndex);
	}
	
	private double log2(int i)
	{
		return Math.log(i) / Math.log(2);
	}
}
