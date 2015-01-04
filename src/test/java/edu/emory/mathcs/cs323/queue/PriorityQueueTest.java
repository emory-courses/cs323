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

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import edu.emory.mathcs.cs323.utils.DSUtils;
import edu.emory.mathcs.cs323.utils.StringUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class PriorityQueueTest
{
	@Test
	public void testAccuracy()
	{
		testAccuracy(new LazyPriorityQueue<>());
		testAccuracy(new EagerPriorityQueue<>());
		testAccuracy(new BinaryHeap<>());
	}
	
	void testAccuracy(AbstractPriorityQueue<Integer> q)
	{
		List<Integer> keys = DSUtils.toIntegerList(4,1,3,2,5,6,8,3,4,7,5,9,7);
		
		for (Integer key : keys)
			q.add(key);
		
		Collections.sort(keys, Collections.reverseOrder());
		
		for (Integer key : keys)
			assertEquals(q.removeMax(), key);
	}
	
	@Test
	@Ignore
	@SuppressWarnings("unchecked")
	public void testSpeed()
	{
		testSpeed(new EagerPriorityQueue<>(), new BinaryHeap<>());
	}
	
	@SuppressWarnings("unchecked")
	void testSpeed(AbstractPriorityQueue<Integer>... qs)
	{
		final int ITER = 1000, LENGTH = qs.length;
		final Random rand = new Random(0);
		
		StringBuilder build = new StringBuilder();
		long[][] times = new long[LENGTH][2];
		int[]    keys;
		
		for (int size=100; size<=1000; size+=100)
		{
			for (int j=0; j<ITER; j++)
			{
				keys = DSUtils.getRandomIntArray(rand, size);
				
				for (int k=0; k<LENGTH; k++)
					addRuntime(qs[k], times[k], keys);
			}
			
			build.append(size);
			
			for (long[] time : times)
			{
				build.append("\t");
				build.append(StringUtils.join(time, "\t"));
			}
			
			build.append("\n");
		}
		
		System.out.println(build.toString());
	}
	
	void addRuntime(AbstractPriorityQueue<Integer> queue, long[] times, int[] keys)
	{
		long st, et;
		
		st = System.currentTimeMillis();
		
		for (int key : keys)
			queue.add(key);
		
		et = System.currentTimeMillis();
		times[0] += et - st;
		
		st = System.currentTimeMillis();
		
		while (!queue.isEmpty())
			queue.removeMax();
		
		et = System.currentTimeMillis();
		times[1] += et - st;
	}
}
