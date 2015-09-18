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
package lab.lab3_20150917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 17, 2015
 */
public class MapPractice {
	
	@Test
	@Ignore
	public void iterateMap1(){
		Map<String, Integer> map = createMap();
		
		for(String key : map.keySet())
			System.out.println(key + " -> " + map.get(key));
	}
	
	@Test
	@Ignore
	public void iterateMap2(){
		Map<String, Integer> map = createMap();
		
		for(Entry<String, Integer> e : map.entrySet())
			System.out.println(e.getKey() + " -> " + e.getValue());
	}
	
	@Test
	@Ignore
	public void iterateMapByValue1(){
		Map<String, Integer> map = createMap();
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		for(Entry<String, Integer> e : entries)
			System.out.println(e.getKey() + " -> " + e.getValue());
	}
	
	@Test
	@Ignore
	public void iterateMapByValue2(){
		Map<String, Integer> map = createMap();
		Map<String, Integer> sorted_map = new TreeMap<>(map);
		
		for(Entry<String, Integer> e : sorted_map.entrySet())
			System.out.println(e.getKey() + " -> " + e.getValue());
	}
	
	public Map<String, Integer> createMap(){
		Map<String, Integer> map = new HashMap<>();
		
		List<String> input = Arrays.asList("Henry", "Lab", "CS323", "Jinho", "CS323", "Henry", "CS323");
		for(String item : input){
			map.putIfAbsent(item, 0);
			map.computeIfPresent(item, (k, v) -> v+1);
		}
		
		return map;
	}
}
