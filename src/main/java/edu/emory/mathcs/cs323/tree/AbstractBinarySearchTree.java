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
public abstract class AbstractBinarySearchTree<T extends Comparable<T>, N extends AbstractBinaryNode<T,N>>
{
	protected N n_root;
	
	public AbstractBinarySearchTree()
	{
		setRoot(null);
	}
	
	/** @return a new node with the specific key. */
	abstract public N createNode(T key);
	
	/** @return the root of this tree. */
	public N getRoot()
	{
		return n_root;
	}
	
	/** Sets the root of this tree to the specific node. */
	public void setRoot(N node)
	{
		if (node != null) node.setParent(null);
		n_root = node;
	}
	
	/** @return {@code true} if the specific node is the root of this tree. */
	public boolean isRoot(N node)
	{
		return n_root == node;
	}
	
	/** @return the node with the specific key if exists; otherwise, {@code null}. */
	public N get(T key)
	{
		return findNode(n_root, key);
	}
	
	/** @return {@code true} if the specific key exists; otherwise, {@code false}. */
	public boolean contains(T key)
	{
		return findNode(n_root, key) != null;
	}
	
//	============================== Add ==============================
	
	/**
	 * @return the new node that is added to this tree.
	 * If this tree already contains the key, nothing is added.
	 */
	public N add(T key)
	{
		N node = null;
		
		if (n_root == null)
			setRoot(node = createNode(key));
		else
			node = addAux(n_root, key);
		
		return node;
	}
	
	private N addAux(N node, T key)
	{
		int diff = key.compareTo(node.getKey());
		N child, newNode = null;
		
		if (diff < 0)
		{
			if ((child = node.getLeftChild()) == null)
				node.setLeftChild(newNode = createNode(key));
			else
				newNode = addAux(child, key);
		}
		else if (diff > 0)
		{
			if ((child = node.getRightChild()) == null)
				node.setRightChild(newNode = createNode(key));
			else
				newNode = addAux(child, key);
		}
		
		return newNode;
	}
	
//	============================== Remove ==============================
	
	/** @return the removed node with the specific key if exists; otherwise, {@code null}. */
	public N remove(T key)
	{
		N node = findNode(n_root, key);
		
		if (node != null)
		{
			if (node.hasBothChildren()) removeHibbard(node);
			else						removeSelf(node);
		}
		
		return node;
	}
	
	/** @return the node with the specific key if exists; otherwise, {@code null}. */
	protected N findNode(N node, T key)
	{
		if (node == null) return null;
		int diff = key.compareTo(node.getKey());
		
		if (diff < 0)
			return findNode(node.getLeftChild(), key);
		else if (diff > 0)
			return findNode(node.getRightChild(), key);
		else
			return node;		
	}
	
	/** @return the lowest node whose subtree has been updatede. */
	protected N removeHibbard(N node)
	{
		N successor = node.getRightChild();
		N min = findMinNode(successor);
		N parent = min.getParent();
		
		min.setLeftChild(node.getLeftChild());
		
		if (min != successor)
		{
			parent.setLeftChild(min.getRightChild());
			min.setRightChild(successor);
		}
		
		replaceChild(node, min);
		return parent;
	}
	
	/** @return the lowest node whose subtree has been updatede. */
	protected N removeSelf(N node)
	{
		N parent = node.getParent();
		N child  = null;
		
		if      (node.hasLeftChild())	child = node.getLeftChild();
		else if (node.hasRightChild())	child = node.getRightChild();
		replaceChild(node, child);
		
		return parent;
	}
	
	private void replaceChild(N oldNode, N newNode)
	{
		if (isRoot(oldNode))
			setRoot(newNode);
		else
			oldNode.getParent().replaceChild(oldNode, newNode);
	}
	
//	============================== Min/Max ==============================
	
	/** @return the minimum key in this tree if exists; otherwise, {@code null}. */
	public T min()
	{
		return (n_root != null) ? findMinNode(n_root).getKey() : null;
	}
	
	/** @return the node with the minimum key under the subtree of {@code node}. */
	protected N findMinNode(N node)
	{
		return node.hasLeftChild() ? findMinNode(node.getLeftChild()) : node; 
	}
	
	/** @return the maximum key in this tree if exists; otherwise, {@code null}. */
	public T max()
	{
		return (n_root != null) ? findMaxNode(n_root).getKey() : null;
	}
	
	/** @return the node with the maximum key under the subtree of {@code node}. */
	protected N findMaxNode(N node)
	{
		return node.hasRightChild() ? findMaxNode(node.getRightChild()) : node; 
	}
	
	public String toString()
	{
		return (n_root != null) ? n_root.toString() : "null";
	}
}
