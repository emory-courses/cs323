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
package edu.emory.mathcs.cs323.lab.lab1_20150123;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.emory.mathcs.cs323.lab.lab1_20150123.keys.Food;
import edu.emory.mathcs.cs323.lab.lab1_20150123.keys.Fridge;
import edu.emory.mathcs.cs323.lab.lab1_20150123.keys.WordBank;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 23, 2015
 */
public class StorageTest {
	@Test
	public void testWordBank(){
		WordBank wb = new WordBank("Alex");
		wb.addWord("Emory");
		wb.addWord("CS323");
		wb.addWord("CS323");
		wb.setFavoriteWord("Jinho");
		assertEquals(wb.toString(), "Alex's WordBank:\nEmory\nCS323\nJinho\nFavorite word: Jinho\n");
	}
	
	@Test
	public void testFridge(){
		Fridge f = new Fridge("Henry");
		f.addFood(new Food("Apple", 3));
		f.addFood(new Food("Apple", 1));
		f.addFood(new Food("Tomato", 2));
		f.addFood(new Food("Hamburger", 5));
		f.removeFood(new Food("Tomato", 3));
		f.removeFood(new Food("Egg", 3));
		assertEquals(f.toString(), "This fridge belongs to Henry and has 2 types of food:\nApple - 4 left\nHamburger - 5 left\n");
		assertEquals(f.getMostValue().toString(), "Hamburger - 5 left");
	}
}
