/**
 * Copyright 2015, Emory University
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
package graph.match;

import graph.Edge;

import java.util.List;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public interface Tree
{
    /** Adds the edge to this tree. */
    void addEdge(Edge edge);
    
    /** @return the distance between the vertex to the root. */
    int distanceToRoot(int vertex);
    
    /** @return the root of this tree. */
    int getRoot();
    
    /** @return the path from the root to the vertex. */
    List<Edge> getPathFromRoot(int vertex);
    
    /** @return the path from the vertex to the root. */
    List<Edge> getPathToRoot(int vertex);

    /** @return the blossom consisting of the specific edge and the path between two vertices. */
    List<Edge> getBlossom(Edge edge, int vertex1, int vertex2);
}
