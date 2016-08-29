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
package edu.emory.mathcs.cs323.lab.lab1_20150123.keys;

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
		numOfFoodType = 0;
	}
	
	public void addFood(Food newFood){
		for(Food f : getContent()){
			if(f.getName().equals(newFood.getName())){
				f.addQuantity(newFood.getQuantity());
				return;
			}
		}
		getContent().add(newFood);
		numOfFoodType++;
	}
	
	public boolean removeFood(Food food){
		for(Food f : getContent()){
			if(f.getName().equals(food.getName())){
				if(f.addQuantity(-food.getQuantity()) <= 0){
					getContent().remove(f);
					numOfFoodType--;
				}
				return true;
			}
		}
		return false;
	}

	public int getNumOfFoodType(){ return numOfFoodType; }
	
	@Override
	public Food getMostValue() {
		return Collections.max(getContent());
	}
	
	@Override
	public String toString(){
		String FridgeLog = "This fridge belongs to " + getOwnerName() + " and has " + getNumOfFoodType() + " types of food:\n";
		for(Food f : getContent())
			FridgeLog += f.toString()+"\n";
		return FridgeLog;
	}
	
}
