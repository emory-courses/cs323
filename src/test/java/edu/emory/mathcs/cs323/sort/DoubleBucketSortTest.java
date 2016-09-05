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

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import edu.emory.mathcs.cs323.sort.distribution.DoubleBucketSort;
import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class DoubleBucketSortTest
{
	@Test
	public void test()
	{
		Double[] original = {.32, .25, .51, .44, .21, .31, .17, .52};
		Double[] sorted = Arrays.copyOf(original, original.length);
		
		AbstractSort<Double> s = new DoubleBucketSort(0, 1);
		s.sort(original);
		Arrays.sort(sorted);
		
		assertTrue(DSUtils.equals(original, sorted));
	}
}
