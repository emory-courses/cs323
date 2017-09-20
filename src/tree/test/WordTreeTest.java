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
package tree.test;


import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class WordTreeTest
{
	@Test
	void test()
	{
		BinarySearchTree<WordNode> tree = new BinarySearchTree<>();
		String[] array = {"Hello","World","I","love","programming"};
		
		for (int i=0; i<array.length; i++)
			tree.add(new WordNode(array[i], i));
		
		for (int i=0; i<array.length; i++)
			assertEquals(i, tree.get(new WordNode(array[i], 0)).getKey().i_id);
	}
	
	class WordNode implements Comparable<WordNode>
	{
		String s_word;
		int i_id;
		
		public WordNode(String word, int id)
		{
			s_word = word;
			i_id   = id; 
		}

		@Override
		public int compareTo(WordNode node)
		{
			return s_word.compareTo(node.s_word);
		}
	}
}
