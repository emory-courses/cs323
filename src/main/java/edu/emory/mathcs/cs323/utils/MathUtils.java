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
package edu.emory.mathcs.cs323.utils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MathUtils
{
	/** @return the sum of all integers in the specific array. */
	static public int sum(int[] array)
	{
		int sum = 0;
		
		for (int i : array)
			sum += i;
		
		return sum;
	}
	
	/**
	 * @param beginIndex inclusive.
	 * @param endIndex inclusive.
	 * @return the middle (center) index between the beginning and the end indexes.
	 */
	static public int getMiddleIndex(int beginIndex, int endIndex)
	{
		return beginIndex + (endIndex - beginIndex) / 2;
	}
	
	static public int getMaxBit(Integer i)
	{
		int exp = 1;
		
		while (Math.pow(10, exp) <= i)
			exp++;
		
		return exp;
	}

	static public double log2(int i)
	{
		return Math.log(i) / Math.log(2);
	}
	
	static public int getMaxDepthForIntroSort(int beginIndex, int endIndex)
	{
		return 2 * (int)log2(endIndex - beginIndex);
	}
	
//	static public void main(String[] args)
//	{
//		System.out.println(sum(new int[]{1,2,3,4,5}));
//	}
}
