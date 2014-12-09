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
package edu.emory.mathcs.cs323.tree.balanced;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class AVLTree<T extends Comparable<T>> extends AbstractBalancedBinarySearchTree<T,AVLNode<T>>
{
	@Override
	public AVLNode<T> createNode(T key)
	{
		return new AVLNode<T>(key);
	}
	
	@Override
	protected void rotateLeft(AVLNode<T> node)
	{
		super.rotateLeft(node);
		node.resetHeights();
	}
	
	@Override
	protected void rotateRight(AVLNode<T> node)
	{
		super.rotateRight(node);
		node.resetHeights();
	}
	
	@Override
	protected void balance(AVLNode<T> node)
	{
		if (node == null) return;
		int bf = node.getBalanceFactor();
		
		if (bf == 2)
		{
			AVLNode<T> child = node.getLeftChild();
			
			if (child.getBalanceFactor() == -1)
				rotateLeft(child);
			
			rotateRight(node);
		}
		else if (bf == -2)
		{
			AVLNode<T> child = node.getRightChild();
			
			if (child.getBalanceFactor() == 1)
				rotateRight(child);
			
			rotateLeft(node);
		}
		else
			balance(node.getParent());
	}
}
