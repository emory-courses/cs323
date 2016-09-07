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
package edu.emory.mathcs.cs323.hw.hybridsort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import edu.emory.mathcs.cs323.hw.hybridsort.HybridSort;
import edu.emory.mathcs.cs323.hw.hybridsort.HybridSortChoi;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HybridSortTest
{
	Random rand = new Random();
	
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
	}
	
	@Test
	public void testSpeed()
	{
		HybridSort<Integer> choi = new HybridSortChoi<>();
		HybridSort<Integer> mine = new HybridSortChoi<>();
		
		int row = 100, col = 100;
		double ratio = 0.1;
		
		long[] time = testSpeed(choi, mine, row, col, ratio); // time[0] = choi, time[1] = mine
		System.out.printf("Row: %d, Col: %d, ratio: %4.2f\t%d\t%d", row, col, ratio, time[0], time[1]);
	}
	
	/**
	 * @param choi
	 * @param mine
	 * @param row the row size of the input.
	 * @param col the column size of the input.
	 * @param ratio the ratio of the input to be shuffled (for the 3rd and 4th cases).
	 */
	long[] testSpeed(HybridSort<Integer> choi, HybridSort<Integer> mine, int row, int col, double ratio)
	{
		long choiTime = 0, mineTime = 0, st, et;
		final int warm = 10, iter = 100;
		Integer[][] input0, input1;
		
		for (int i=0; i<warm; i++)
		{
			input0 = randomInput(row, col, ratio);
			input1 = copyOf(input0);
			choi.sort(input0);
			mine.sort(input1);
		}
		
		for (int i=0; i<iter; i++)
		{
			input0 = randomInput(row, col, ratio);
			input1 = copyOf(input0);
			
			st = System.currentTimeMillis();
			choi.sort(input0);
			et = System.currentTimeMillis();
			choiTime += et - st;
			
			st = System.currentTimeMillis();
			mine.sort(input1);
			et = System.currentTimeMillis();
			mineTime += et - st;
		}
		
		return new long[]{choiTime, mineTime};
	}
	
	Integer[][] copyOf(Integer[][] input)
	{
		Integer[][] copy = new Integer[input.length][];
		
		for (int i=0; i<input.length; i++)
			copy[i] = Arrays.copyOf(input[i], input[i].length);
		
		return copy;
	}
	
	Integer[][] randomInput(int row, int col, double ratio)
	{
		Integer[][] input = new Integer[row][];
		
		for (int i=0; i<row; i++)
			input[i] = randomArray(col, ratio);
		
		return input;
	}
	
	Integer[] randomArray(int size, double ratio)
	{
		switch (rand.nextInt(5))
		{
		case 0: return randomArray(size, 0, Comparator.naturalOrder());
		case 1: return randomArray(size, 0, Comparator.reverseOrder());
		case 2: return randomArray(size, ratio, Comparator.naturalOrder());
		case 3: return randomArray(size, ratio, Comparator.reverseOrder());
		case 4: return randomArray(size, 0, null);
		default: throw new IllegalArgumentException();
		}
	}
	
	Integer[] randomArray(int size, double ratio, Comparator<Integer> comparator)
	{
		Integer[] array = new Integer[size];
		int shuffle = (int)(size*ratio);
		
		for (int i=0; i<size; i++) array[i] = rand.nextInt();
		if (comparator != null) Arrays.sort(array, comparator);
		
		for (int i=0; i<shuffle; i++)
			swap(array, rand.nextInt(array.length), rand.nextInt(array.length));
		
		return array;
	}
	
	void swap(Integer[] array, int i, int j)
	{
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
