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
package edu.emory.mathcs.cs323.graph.flow;

import org.junit.Ignore;
import org.junit.Test;

import edu.emory.mathcs.cs323.graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class FordFulkersonTest
{
	@Test
	@Ignore
	public void test()
	{
		Graph graph = new Graph(6);
		
		graph.setDirectedEdge(0, 1, 4);
		graph.setDirectedEdge(0, 2, 2);
		graph.setDirectedEdge(1, 3, 3);
		graph.setDirectedEdge(2, 3, 2);
		graph.setDirectedEdge(2, 4, 3);
		graph.setDirectedEdge(3, 2, 1);
		graph.setDirectedEdge(3, 5, 2);
		graph.setDirectedEdge(4, 5, 4);
		
		FordFulkerson n = new FordFulkerson();
		MaxFlow mf = n.getMaximumFlow(graph, 0, 5);
		System.out.println(mf.getFlow());
		System.out.println(mf.getEdges().toString());
		
		graph = new Graph(5);
		graph.setDirectedEdge(0, 1, 3);
		graph.setDirectedEdge(0, 2, 3);
		graph.setDirectedEdge(2, 3, 3);
		graph.setDirectedEdge(1, 3, 3);
		graph.setDirectedEdge(3, 4, 4);
		
		mf = n.getMaximumFlow(graph, 0, 4);
		System.out.println(mf.getFlow());
		System.out.println(mf.getEdges().toString());		
	}
	
	@Test
	public void test2()
	{
		Graph graph = new Graph(6);
		
		graph.setUndirectedEdge(0, 1, 1);
		graph.setUndirectedEdge(0, 2, 2);
		graph.setUndirectedEdge(1, 3, 2);
		graph.setUndirectedEdge(1, 4, 2);
		graph.setUndirectedEdge(2, 3, 2);
		graph.setUndirectedEdge(3, 5, 1);
		graph.setUndirectedEdge(4, 5, 2);
		
		FordFulkerson n = new FordFulkerson();
		MaxFlow mf = n.getMaximumFlow(graph, 0, 5);
		System.out.println(mf.getFlow());
		System.out.println(mf.getEdges().toString());
	}
	
	@Test
	public void test3()
	{
		Graph graph = new Graph(9);
		
		graph.setUndirectedEdge(1, 2, 12);
		graph.setUndirectedEdge(1, 3, 5);
		graph.setUndirectedEdge(1, 4, 8);
		graph.setUndirectedEdge(2, 4, 9);
		graph.setUndirectedEdge(2, 5, 3);
		graph.setUndirectedEdge(2, 6, 9);
		graph.setUndirectedEdge(3, 6, 18);
		graph.setUndirectedEdge(4, 5, 4);
		graph.setUndirectedEdge(4, 7, 47);
		graph.setUndirectedEdge(5, 8, 13);
		graph.setUndirectedEdge(6, 8, 26);
		graph.setUndirectedEdge(7, 8, 34);
		
		FordFulkerson n = new FordFulkerson();
		MaxFlow mf = n.getMaximumFlow(graph, 1, 8);
		System.out.println(mf.getFlow());
		System.out.println(mf.getEdges().toString());
	}
}
