/**
 * Copyright 2015, Emory University
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
package hw.hybridsort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HybridSortTest
{
	@Test
	public void testAccuracy()
	{
		HybridSort<Integer> choi = new HybridSortChoi<>();
		HybridSort<Integer> mine = new HybridSortChoi<>();
		
		Integer[][] input = {{0,1,2,3},{7,6,5,4},{0,3,1,2},{4,7,6,5},{9,8,11,10}};
		testAccuracy(input, choi, mine);
	}

	void testAccuracy(Integer[][] input, HybridSort<Integer> choi, HybridSort<Integer> mine)
	{
		Integer[] gold = choi.sort(copyOf(input));
		Integer[] auto = mine.sort(input);
		assertArrayEquals(gold, auto);
		System.out.println(Arrays.toString(auto));
	}
	
	Integer[][] copyOf(Integer[][] input)
	{
		Integer[][] copy = new Integer[input.length][];
		
		for (int i=0; i<input.length; i++)
			copy[i] = Arrays.copyOf(input[i], input[i].length);
		
		return copy;
	}
}
