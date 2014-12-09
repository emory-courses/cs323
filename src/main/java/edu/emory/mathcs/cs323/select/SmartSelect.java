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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SmartSelect<T extends Comparable<T>> extends AbstractSelect<T>
{
	@Override
	public T max(List<T> list, int k)
	{
		List<T> maxK = new ArrayList<>(k);
		
		for (T item : list)
			insert(maxK, item, k);
		
		return maxK.get(maxK.size()-1);
	}
	
	private void insert(List<T> maxK, T item, int k)
	{
		int index = Collections.binarySearch(maxK, item, Collections.reverseOrder());
		if (index < 0) index = -(index + 1);
		
		if (index < k)
		{
			maxK.add(index, item);
			if (maxK.size() > k) maxK.remove(maxK.size()-1);
		}
	}
}
