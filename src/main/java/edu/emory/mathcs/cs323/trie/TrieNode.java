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

import java.util.HashMap;
import java.util.Map;



/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TrieNode<T>
{
	private Map<Character,TrieNode<T>> m_children;
	private TrieNode<T> n_parent;
	private boolean b_endState;
	private char c_key;
	private T t_value;
	
	public TrieNode(TrieNode<T> parent, char key)
	{
		m_children = new HashMap<Character,TrieNode<T>>();
		setEndState(false);
		setParent(parent);
		setKey(key);
		setValue(null);
	}
	
	public TrieNode<T> getParent()
	{
		return n_parent;
	}
	
	public char getKey()
	{
		return c_key;
	}
	
	public T getValue()
	{
		return t_value;
	}
	
	public void setParent(TrieNode<T> node)
	{
		n_parent = node;
	}
	
	public void setKey(char key)
	{
		c_key = key;
	}
	
	public T setValue(T value)
	{
		T tmp = t_value;
		t_value = value;
		return tmp;
	}
	
	public void setEndState(boolean isEndState)
	{
		b_endState = isEndState;
	}
	
	/** @return {@code true}} if this node is an end state; otherwise, {@code false}. */
	public boolean isEndState()
	{
		return b_endState;
	}
	
	public boolean hasValue()
	{
		return t_value != null;
	}
	
	public boolean hasChildren()
	{
		return !m_children.isEmpty();
	}
	
	/** @return the map whose keys and values are children's characters and nodes. */
	public Map<Character,TrieNode<T>> getChildrenMap()
	{
		return m_children;
	}
	
	public TrieNode<T> getChild(char key)
	{
		return m_children.get(key);
	}
	
	public TrieNode<T> addChild(char key)
	{
		TrieNode<T> child = getChild(key);
		
		if (child == null)
		{
			child = new TrieNode<T>(this, key);
			m_children.put(key, child);
		}
		
		return child;
	}
	
	public TrieNode<T> removeChild(char key)
	{
		return m_children.remove(key);
	}
}
