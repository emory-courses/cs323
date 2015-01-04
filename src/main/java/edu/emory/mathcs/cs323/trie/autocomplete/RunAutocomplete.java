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
package edu.emory.mathcs.cs323.trie.autocomplete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import edu.emory.mathcs.cs323.utils.StringUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class RunAutocomplete
{
	private IAutocomplete<?> t_auto;
	
	public RunAutocomplete()
	{
		t_auto = new DummyAutocomplete();
	}
	
	public void putDictionary(InputStream in) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		
		while ((line = reader.readLine()) != null)
			t_auto.put(line.trim(), null);
	}
	
	public void run() throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> candidates;
		String prefix, pick;
		
		do 
		{
			System.out.print("Enter a prefix: ");
			prefix = reader.readLine();
			
			// TODO: print out the top 10 candidates
			candidates = t_auto.getCandidates(prefix);
			System.out.println(StringUtils.join(candidates, "\n"));
			
			System.out.print("Pick: ");
			pick = reader.readLine();
			
			// TODO: update your Trie with this pick.
			t_auto.pickCandidate(prefix, pick);
			System.out.println("\""+pick+"\" is learned.\n");
		}
		while (true);
	}
	
	static public void main(String[] args) throws Exception
	{
		String dictFile = "/Users/jdchoi/Documents/Archive/Emory/webpage/public_html/courses/cs323-14f/dat/dict.txt";
		RunAutocomplete tr = new RunAutocomplete();
		
		tr.putDictionary(new FileInputStream(dictFile));
		tr.run();
	}
}
