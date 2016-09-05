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
public class DoubleBucketSort extends BucketSort<Double>
{
	private static final int BUCKET_SIZE = 10;
	private final double GAP;
	
	public DoubleBucketSort(double min, double max)
	{
		this(min, max, Comparator.naturalOrder());
	}
	
	public DoubleBucketSort(double min, double max, Comparator<Double> comparator)
	{
		super(BUCKET_SIZE, true, comparator);
		GAP = -min;
	}
	
	@Override
	protected int getBucketIndex(Double key)
	{
		return (int)((key+GAP) * BUCKET_SIZE); 
	}
}
