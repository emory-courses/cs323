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

import java.util.Collections;
import java.util.List;

import edu.emory.mathcs.utils.DSUtils;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractBucketSort<T extends Comparable<T>> extends AbstractSort<T>
{
	/** The list of buckets. */
	private List<T>[] g_buckets;
	/** if {@code true}, sort each bucket. */
	private final boolean b_sort; 
	
	/** @param bucketSize the total number of buckets. */
	@SuppressWarnings("unchecked")
	public AbstractBucketSort(int bucketSize, boolean sort)
	{
		g_buckets = (List<T>[])DSUtils.createEmptyListArray(bucketSize);
		b_sort = sort;
	}
	
	@Override
	public void sort(T[] array, int beginIndex, int endIndex)
	{
		//Add each element to its corresponding bucket
		for (int i=beginIndex; i<endIndex; i++)
			g_buckets[getBucketIndex(array[i])].add(array[i]);
		
		//Spit out all bucket elements and reassign array elements
		for (List<T> bucket : g_buckets)
		{
			//Sort each bucket if b_sort == true
			if (b_sort)
				Collections.sort(bucket);
			
			for (T key : bucket)
				array[beginIndex++] = key;
			
			bucket.clear();
		}
	}
	
	/**
	 * @param key a comparable key.
	 * @return the index of the bucket that the key should be inserted.
	 */
	abstract protected int getBucketIndex(T key);
}
