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
package lab.lab2_20150911;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import lab.lab2_20150911.structure.LambdaEum;
import lab.lab2_20150911.structure.LambdaObject;
import lab.lab2_20150911.structure.machine.AbstractLambdaMachine;
import lab.lab2_20150911.structure.machine.LambdaObjectMerger;
import lab.lab2_20150911.structure.machine.StringMixer;

import org.junit.Test;

import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 11, 2015
 */
public class LambdaPractice {
	
	public List<LambdaObject> getObjects(){
		List<LambdaObject> list = new ArrayList<>();
		list.add(new LambdaObject("A", 1, "A1"));
		list.add(new LambdaObject("A", 2, "A2"));
		list.add(new LambdaObject("B", 1, "B1"));
		list.add(new LambdaObject("B", 2, "B2"));
		list.add(new LambdaObject("C", 1, "C1"));
		list.add(new LambdaObject("C", 2, "C2"));
		list.add(new LambdaObject("D", 1, "D1"));
		list.add(new LambdaObject("D", 2, "D2"));
		return list;
	}
	
	@Test
	public void testSum(){
		List<Integer> list = DSUtils.getRandomIntegerList(new Random(), 10, 10);
		
		int sum = 0,  key = 0;
		
		for(int i : list) key += i;
		sum = list.stream().mapToInt(i -> i).sum();
		
		assertEquals(key, sum);
	}
	
	@Test
	public void testAverage(){
		List<Integer> list = DSUtils.getRandomIntegerList(new Random(), 10, 10);
		
		int size = list.size();
		double average = 0, key = 0;
		
		for(int i : list) key += (double)i / size;
		average = list.stream().mapToInt(i -> i).average().getAsDouble();
				
		assertEquals(average, key, 1e-5);
	}
	
	@Test
	public void testCollector(){
		List<LambdaObject> objects = getObjects();
		List<String> values = objects.stream()
				.map(obj -> obj.getValue())
				.collect(Collectors.toList());
		
		for(String value : values)
			System.out.print(value + " ");
		System.out.println();
	}
	
	@Test
	public void testFilter(){
		List<LambdaObject> objects = getObjects();
		List<LambdaObject> filtered = objects.stream()
				.filter(obj -> obj.getType() != LambdaEum.A)
				.filter(obj -> obj.getType() != LambdaEum.C)
				.collect(Collectors.toList());
		
		for(LambdaObject obj : filtered)
			System.out.println(obj);
	}
	
	@Test
	public void testLambdaMachine(){
		String result;
		AbstractLambdaMachine<LambdaObject, LambdaObject, String> machine = new LambdaObjectMerger();
		
		result = machine.run(new LambdaObject("A", 1, "Hello "), new LambdaObject("A", 2, "World!"));
		System.out.println(result);
	}
	
	@Test
	public void testStringMixer(){
		AbstractLambdaMachine<String, String, String> machine = new StringMixer();
		
		System.out.println(machine.run("Henry", "Chen"));
		System.out.println(machine.run("ABCDE", "12345"));
	}
}
