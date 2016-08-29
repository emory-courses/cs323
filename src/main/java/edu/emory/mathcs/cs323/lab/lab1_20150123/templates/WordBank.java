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

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 23, 2015
 */
public class WordBank extends Storage<String>{

	String FavoriteWord;
	
	public WordBank(String o) {
		super(o);
		FavoriteWord = null;
	}
	
	public boolean hasWord(String w){
		//To be filled
		return false;
	}
	
	public void addWord(String w){
		//To be filled
	}
	
	public void setFavoriteWord(String w){
		//To be filled
	}

	@Override
	public String getMostValue() {
		//To be filled (return FavoriteWord)
		return null;
	}

	@Override
	public String toString(){
		//To be filled
		/*
		 * Output:
		 * (ownerName)'s WordBank\n
		 * (word 1)\n
		 * (word 2)\n
		 * (word 3)\n
		 * ...
		 * Favorite word: (FavoriteWord)\n
		 */
		return null;
	}
}