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
package edu.emory.mathcs.cs323.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.emory.mathcs.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Graph
{
	private List<Edge>[] e_incoming;
	
	@SuppressWarnings("unchecked")
	public Graph(int size)
	{
		e_incoming = (List<Edge>[])DSUtils.createEmptyListArray(size);
	}
	
	public List<Edge> getIncomingEdges(int target)
	{
		return e_incoming[target];
	}
	
	public List<Edge> getAllEdges()
	{
		List<Edge> edges = new ArrayList<>();
		
		for (int i=0; i<size(); i++)
			edges.addAll(e_incoming[i]);
		
		return edges;
	}
	
	public Edge setDirectedEdge(int source, int target, double weight)
	{
		List<Edge> edges = getIncomingEdges(target);
		Edge edge = new Edge(source, target, weight);
		edges.add(edge);
		return edge;
	}
	
	public void setUndirectedEdge(int source, int target, double weight)
	{
		setDirectedEdge(source, target, weight);
		setDirectedEdge(target, source, weight);
	}
	
	public int size()
	{
		return e_incoming.length;
	}
	
	public boolean containsCycle()
	{
		Deque<Integer> notVisited = new ArrayDeque<>();
		for (int i=0; i<size(); i++) notVisited.add(i);
		
		while (!notVisited.isEmpty())
		{
			if (containsCycleAux(notVisited.poll(), notVisited, new HashSet<>()))
				return true;
		}
		
		return false;
	}	
	
	private boolean containsCycleAux(int target, Deque<Integer> notVisited, Set<Integer> visited)
	{
		notVisited.remove(target);
		visited.add(target);
		
		for (Edge edge : getIncomingEdges(target))
		{
			if (visited.contains(edge.getSource()))
				return true;
			
			if (containsCycleAux(edge.getSource(), notVisited, new HashSet<>(visited)))
				return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Deque<Edge>[] getOutgoingEdges()
	{
		Deque<Edge>[] edges = (Deque<Edge>[])DSUtils.createEmptyDequeArray(size());
		
		for (int target=0; target<size(); target++)
		{
			for (Edge edge : getIncomingEdges(target))
				edges[edge.getSource()].add(edge);
		}
		
		return edges;
	}
	
	public Deque<Integer> getVerticesWithNoIncomingEdges()
	{
		Deque<Integer> deque = new ArrayDeque<>();
		int i, size = size();
		
		for (i=0; i<size; i++)
		{
			if (getIncomingEdges(i).isEmpty())
				deque.add(i);
		}
		
		return deque;
	}
	
	public boolean isEmpty()
	{
		for (int i=0; i<size(); i++)
		{
			if (!getIncomingEdges(i).isEmpty())
				return false;
		}
		
		return true;
	}
	
	public String toString()
	{
		StringBuilder build = new StringBuilder();
		
		for (int i=0; i<e_incoming.length; i++)
		{
			build.append(i);
			build.append(" <- ");
			build.append(e_incoming[i].toString());
			build.append("\n");
		}
		
		return build.toString();
	}
}
