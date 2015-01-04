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
package edu.emory.mathcs.cs323.tree;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractBinaryNode<T extends Comparable<T>,N extends AbstractBinaryNode<T,N>>
{
	protected T t_key;
	protected N n_parent;
	protected N n_leftChild;
	protected N n_rightChild;
	
	public AbstractBinaryNode(T key)
	{
		setKey(key);
	}
	
//	============================== Getters ==============================
	public T getKey()
	{
		return t_key;
	}
	
	public N getParent()
	{
		return n_parent;
	}
	
	public N getLeftChild()
	{
		return n_leftChild;
	}
	
	public N getRightChild()
	{
		return n_rightChild;
	}
	
	public N getGrandParent()
	{
		return hasParent() ? n_parent.getParent() : null;
	}
	
	@SuppressWarnings("unchecked")
	public N getSibling()
	{
		if (hasParent())
		{
			N parent = getParent();
			return parent.isLeftChild((N)this) ? parent.getRightChild() : parent.getLeftChild();
		}
		
		return null;
	}
	
	public N getUncle()
	{
		return hasParent() ? n_parent.getSibling() : null;
	}

//	============================== Setters ==============================
	public void setKey(T key)
	{
		t_key = key;
	}
	
	public void setParent(N node)
	{
		n_parent = node;
	}
	
	public void setLeftChild(N node)
	{
		replaceParent(node);
		n_leftChild = node;
	}
	
	public void setRightChild(N node)
	{
		replaceParent(node);
		n_rightChild = node;
	}
	
	@SuppressWarnings("unchecked")
	protected void replaceParent(N node)
	{
		if (node != null)
		{
			if (node.hasParent()) node.getParent().replaceChild(node, null);
			node.setParent((N)this);
		}
	}
	
	/** Replaces the old child with the new child if exists. */
	public void replaceChild(N oldChild, N newChild)
	{
		if      (isLeftChild (oldChild)) 	setLeftChild (newChild);
		else if (isRightChild(oldChild))	setRightChild(newChild);
	}

//	============================== Checks ==============================
	public boolean hasParent()
	{
		return n_parent != null;
	}
	
	public boolean hasLeftChild()
	{
		return n_leftChild != null;
	}
	
	public boolean hasRightChild()
	{
		return n_rightChild != null;
	}
	
	public boolean hasBothChildren()
	{
		return hasLeftChild() && hasRightChild();
	}
	
	/** @return {@code true} if the specific node is the left child of this node. */
	public boolean isLeftChild(N node)
	{
		return n_leftChild == node;
	}
	
	/** @return {@code true} if the specific node is the right child of this node. */
	public boolean isRightChild(N node)
	{
		return n_rightChild == node;
	}

//	=================================================================
	@Override
	public String toString()
	{
		return t_key + " -> (" + n_leftChild +", " + n_rightChild +")";
	}
}
