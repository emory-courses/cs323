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
package edu.emory.mathcs.utils;

import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class StringUtils
{
	static public String join(long[] array, String delim)
	{
		StringBuilder build = new StringBuilder();
		
		for (long item : array)
		{
			build.append(delim);
			build.append(item);
		}
		
		return build.substring(delim.length());
	}
	
	static public <T>String join(List<T> list, String delim)
	{
		StringBuilder build = new StringBuilder();
		
		for (T item : list)
		{
			build.append(delim);
			build.append(item);
		}
		
		return build.length() > delim.length() ? build.substring(delim.length()) : "";
	}
}
