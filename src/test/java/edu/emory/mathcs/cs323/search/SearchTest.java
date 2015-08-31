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
package edu.emory.mathcs.cs323.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SearchTest
{
	@Test
	public void testAccuracy()
	{
		List<Integer> list = DSUtils.toIntegerList(5, 2, 3, 2, 1, 1, 4, 2);
		ISearch<Integer> s1 = new LinearSearch<>();
		ISearch<Integer> s2 = new BinarySearch<>();
		
		assertEquals(s1.search(list, 1), 4);
		assertEquals(s1.search(list, 2), 1);
		assertEquals(s1.search(list, 3), 2);
		assertEquals(s1.search(list, 4), 6);
		assertEquals(s1.search(list, 5), 0);
		
		assertTrue(s1.search(list, 0) < 0);
		assertTrue(s1.search(list, 6) < 0);
		
		// list = [1, 1, 2, 2, 2, 3, 4, 5]
		Collections.sort(list);
		
		assertEquals(s2.search(list, 1), 1);
		assertEquals(s2.search(list, 2), 3);
		assertEquals(s2.search(list, 3), 5);
		assertEquals(s2.search(list, 4), 6);
		assertEquals(s2.search(list, 5), 7);
		
		assertTrue(s2.search(list, 0) < 0);
		assertTrue(s2.search(list, 6) < 0);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void compareSpeed()
	{
		compareSpeed(new LinearSearch<Integer>(), new BinarySearch<Integer>());
	}
	
	@SuppressWarnings("unchecked")
	void compareSpeed(final ISearch<Integer>... engines)
	{
		final int INC = 100, WARM = 10, ITER = 1000000;
		final Random rand = new Random(0);
		
		StringBuilder build = new StringBuilder();
		List<Integer> list  = new ArrayList<>();
		
		for (int i=0; i<10; i++)
		{
			list.addAll(DSUtils.getRandomIntegerList(rand, INC));
			build.append(list.size());
			Collections.sort(list);
			
			// warm-up
			for (ISearch<Integer> engine : engines)
				getRuntime(list, engine, WARM, i);
			
			// benchmark
			for (ISearch<Integer> engine : engines)
				build.append("\t"+getRuntime(list, engine, ITER, i));
			
			build.append("\n");
		}
		
		System.out.println(build.toString());
	}
	
	long getRuntime(List<Integer> list, ISearch<Integer> engine, int iterations, int id)
	{
		final Random rand = new Random(id);
		long st, et;
		
		st = System.currentTimeMillis();
		
		for (int i=0; i<iterations; i++)
			engine.search(list, rand.nextInt());
		
		et = System.currentTimeMillis();
		
		return et - st;
	}
}
