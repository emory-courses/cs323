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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MaxFlow
{
	private Map<Edge,Double> m_residuals;
	private double d_flow;
	
	public MaxFlow(Graph graph)
	{
		init(graph);
	}
	
	public void init(Graph graph)
	{	
		m_residuals = new HashMap<>();
		d_flow = 0;
		
		for (Edge edge : graph.getAllEdges())
			m_residuals.put(edge, 0d);
	}

	public void updateResidual(List<Edge> path, double flow)
	{
		for (Edge edge : path) updateResidual(edge, flow);
		d_flow += flow;
	}
	
	public void updateResidual(Edge edge, double flow)
	{
		m_residuals.put(edge, m_residuals.get(edge)+flow);
	}
	
	public double getResidual(Edge edge)
	{
		return edge.getWeight() - m_residuals.get(edge);
	}
	
	public double getFlow()
	{
		return d_flow;
	}
	
	public List<Edge> getEdges()
	{
		List<Edge> edges = new ArrayList<>();
		double r;
		Edge e;
		
		for (Edge edge : m_residuals.keySet())
		{
			r = m_residuals.get(edge);
			if (r > 0)
			{
				e = new Edge(edge);
				e.setWeight(r);
				edges.add(e);
			}
		}
		
		return edges;
	}
}
