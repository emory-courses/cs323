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
package edu.emory.mathcs.cs323.lab.lab1_20150123.templates;

import java.util.Collections;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 23, 2015
 */
public class Fridge extends Storage<Food>{

	private int numOfFoodType;
	
	public Fridge(String o) {
		super(o);
		//To be filled
	}
	
	public void addFood(Food newFood){
		//To be filled
	}
	
	public boolean removeFood(Food food){
		//To be filled
		return false;
	}

	public int getNumOfFoodType(){ return numOfFoodType; }
	
	@Override
	public Food getMostValue() {
		return Collections.max(getContent());
	}
	
	@Override
	public String toString(){
		//To be filled
		/*
		 * Output:
		 * This fridge belongs to (ownerName) and has (numOfFoodType) types of food:\n
		 * (foodName1) - (foodQuantity1) left\n
		 * (foodName2) - (foodQuantity2) left\n
		 * (foodName3) - (foodQuantity3) left\n
		 * ...
		 */
		return null;
	}
	
}