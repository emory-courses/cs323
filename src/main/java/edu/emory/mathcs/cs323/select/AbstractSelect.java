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

import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractSelect<T extends Comparable<T>>
{
	/**
	 * @param list a list of unsorted keys.
	 * @param k the k'th maximum key to search.
	 * @return the k'th maximum key in the list.
	 * @throws IllegalArgumentException if the size of the list is smaller than {@code k}. 
	 */
	abstract public T max(List<T> list, int k);
	
	protected void throwIllegalArgumentException(List<T> list, int k)
	{
		if (list.size() < k)
			throw new IllegalArgumentException("The array size is smaller than k.");
	}
}
