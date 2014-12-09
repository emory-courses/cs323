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
package edu.emory.mathcs.cs323.trie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TrieTest
{
	@Test
	public void test()
	{
		final String[] vocab = {"she","shell","sell","selling","shore","woman","women","won"};
		Trie<Integer> trie = new Trie<>();
		int i, len = vocab.length;
		
		for (i=0; i<len; i++)
			trie.put(vocab[i], i);
		
		for (i=0; i<len; i++)
			assertEquals(i, trie.get(vocab[i]).intValue());
		
		assertEquals(null, trie.get("wom"));
		assertEquals(null, trie.get("wons"));
		
		assertEquals(false, trie.remove("wom"));
		assertEquals(5, trie.get("woman").intValue());
		
		assertEquals(false, trie.remove("wons"));
		assertEquals(7, trie.get("won").intValue());
		
		trie.remove("won");
		assertEquals(null, trie.get("won"));
		assertEquals(5, trie.get("woman").intValue());
		
		trie.remove("selling");
		assertEquals(null, trie.get("selling"));
		assertEquals(2, trie.get("sell").intValue());
		
		trie.remove("she");
		assertEquals(null, trie.get("she"));
		assertEquals(1, trie.get("shell").intValue());
		assertEquals(4, trie.get("shore").intValue());
		
		System.out.println("sell".compareTo("selling"));
	}
}
