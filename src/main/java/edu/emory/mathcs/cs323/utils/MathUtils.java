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
	/**
	 * @param beginIndex inclusive.
	 * @param endIndex inclusive.
	 * @return the middle index between the beginning and the end indexes.
	 */
	static public int getMiddleIndex(int beginIndex, int endIndex)
	{
		return beginIndex + (endIndex - beginIndex) / 2;
	}
	
	static public void main(String[] args)
	{
		System.out.println(getMiddleIndex(0, 10));
	}
}
