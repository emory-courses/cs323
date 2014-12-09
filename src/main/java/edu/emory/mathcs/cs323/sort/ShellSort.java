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

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class ShellSort<T extends Comparable<T>> extends InsertionSort<T>
{
	@Override
	public void sort(T[] array, int beginIndex, int endIndex)
	{
		int h = getMaxH(endIndex - beginIndex);
		
		while (h >= 1)
		{
			sort(array, beginIndex, endIndex, h);
			h = getNextH(h);
		}
	}
	
	public int getMaxH(int n)
	{
		final int upper = n / 3;
		int h = 1, t;
		
		while (true)
		{
			t = 3*h + 1;
			if (t > upper) break;
			h = t;
		}
		
		return h;
	}
	
	public int getNextH(int h)
	{
		return h / 3;
	}
}
