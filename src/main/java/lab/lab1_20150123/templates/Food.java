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
package lab.lab1_20150123.templates;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 23, 2015
 */
public class Food implements Comparable<Food>{
	private String Name;
	private int Quantity;
	
	public Food(String n, int q){
		//To be filled
	}
	
	public int addQuantity(int q){ 
		//To be filled 
		return 0;
	}

	public String getName(){ return Name; }
	public int getQuantity(){ return Quantity; }
	
	@Override
	public int compareTo(Food o) {
		//To be filled
		return 0;
	}
	
	@Override
	public String toString(){
		//To be filled
		return null;
	}
}