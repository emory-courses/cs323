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
package edu.emory.mathcs.cs323.sort.distribution;

import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class LSDRadixSort extends BucketSort<Integer>
{
	private final int MAX;
	private int div;
	
	public LSDRadixSort(int maxDigits)
	{
		this(maxDigits, Comparator.naturalOrder());
	}
	
	public LSDRadixSort(int maxDigits, Comparator<Integer> comparator)
	{
		super(10, false, comparator);
		MAX = maxDigits;
	}
	
	@Override
	public void sort(Integer[] array, int beginIndex, int endIndex)
	{
		for (int i=0; i<MAX; i++)
		{
			div = (int)Math.pow(10, i);
			super.sort(array, beginIndex, endIndex);
		}
	}
	
	@Override
	protected int getBucketIndex(Integer key)
	{
		return (key / div) % 10;
	}
}
