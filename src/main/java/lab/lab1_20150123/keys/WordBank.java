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
package lab.lab1_20150123.keys;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 23, 2015
 */
public class WordBank extends Storage<String>{

	private String FavoriteWord;
	
	public WordBank(String o) {
		super(o);
		FavoriteWord = null;
	}
	
	public boolean hasWord(String w){
		return getContent().contains(w);
	}
	
	public void addWord(String w){
		if(!hasWord(w)) getContent().add(w);
	}
	
	public void setFavoriteWord(String w){
		addWord(w);
		FavoriteWord = w;
	}

	@Override
	public String getMostValue() {
		return FavoriteWord;
	}

	@Override
	public String toString(){
		String WordBankLog = getOwnerName() + "'s WordBank:\n";
		for(String s : getContent())
			WordBankLog += s+"\n";
		WordBankLog += "Favorite word: " + getMostValue() + "\n";
		return WordBankLog;
	}
	
}
