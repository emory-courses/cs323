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
package edu.emory.mathcs.cs323.select;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SelectTest 
{
	@Test
	public void testAccuracy()
	{
		testAccuracy(new DumbSelect<>());
		testAccuracy(new SmartSelect<>());
	}
	
	void testAccuracy(AbstractSelect<Integer> s)
	{
		List<Integer> originalList = DSUtils.toIntegerList(4,1,3,2,5,6,8,3,4,7,5,9,7);
		List<Integer> sortedList   = new ArrayList<>(originalList);
		Collections.sort(sortedList, Collections.reverseOrder());
		
		for (int k=0; k<originalList.size(); k++)
			assertEquals(sortedList.get(k), s.max(originalList, k+1));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void compareSpeed()
	{
		compareSpeed(1000, new DumbSelect<Integer>(), new SmartSelect<Integer>());
	}
	
	@SuppressWarnings("unchecked")
	void compareSpeed(final int SIZE, final AbstractSelect<Integer>... ss)
	{
		final int WARM = 10, ITER = 1000, MAX_K = 100, LENGTH = ss.length;
		long[][] times = new long[LENGTH][MAX_K];
		Random rand = new Random(1);
		List<Integer> list;

		// warm-up
		for (int i=0; i<WARM; i++)
		{
			list = DSUtils.getRandomIntegerList(rand, SIZE);
					
			for (int j=0; j<LENGTH; j++)
				for (int k=0; k<MAX_K; k++)
					getRuntime(ss[j], list, k+1);
		}
		
		// benchmark
		for (int i=0; i<ITER; i++)
		{
			list = DSUtils.getRandomIntegerList(rand, SIZE);
					
			for (int j=0; j<LENGTH; j++)
				for (int k=0; k<MAX_K; k++)
					times[j][k] += getRuntime(ss[j], list, k+1);
		}

		print(times);
	}
	
	long getRuntime(AbstractSelect<Integer> s, List<Integer> list, int k)
	{
		long st, et;
		
		st = System.currentTimeMillis();
		s.max(list, k);
		et = System.currentTimeMillis();
		
		return et - st;
	}
	
	void print(long[][] times)
	{
		StringBuilder build = new StringBuilder();
		
		for (int k=0; k<times[0].length; k++)
		{
			build.append(k+1);
			
			for (int j=0; j<times.length; j++)
				build.append("\t"+times[j][k]);
			
			build.append("\n");
		}
		
		System.out.println(build.toString());
	}
}
