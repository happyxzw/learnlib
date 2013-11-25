/* Copyright (C) 2013 TU Dortmund
 * This file is part of LearnLib, http://www.learnlib.de/.
 * 
 * LearnLib is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 3.0 as published by the Free Software Foundation.
 * 
 * LearnLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with LearnLib; if not, see
 * <http://www.gnu.de/documents/lgpl.en.html>.
 */
package de.learnlib.filters.reuse.tree;

import java.util.Arrays;
import java.util.Collection;

/**
 * A {@link ReuseNode} is a vertex in the {@link ReuseTree} that contains (a
 * possible empty) set of outgoing {@link ReuseEdge}s. Each {@link ReuseNode}
 * may contain a {@link SystemState} holding relevant informations (e.g.
 * database identifiers) that belongs to the system state that 'represents' the
 * system state after executing a membership query.
 * 
 * @author Oliver Bauer <oliver.bauer@tu-dortmund.de>
 */
public class ReuseNode<S, I, O> {
	private final ReuseEdge<S,I,O>[] edges;
	private S systemstate;
	private int prefixLength = -1;
	
	@SuppressWarnings("unchecked")
	public ReuseNode(int alphabetSize) {
		edges = new ReuseEdge[alphabetSize];
	}

	/**
	 * Returns the prefix length for a membership query that leads to
	 * a node in the reuse tree that contains a system state.
	 * 
	 * @return
	 */
	public int getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(int prefixLength) {
		this.prefixLength = prefixLength;
	}

	/**
	 * The {@link SystemState}, maybe <code>null</code>.
	 * 
	 * @return
	 */
	public S getSystemState() {
		return systemstate;
	}

	public void setSystemState(S state) {
		this.systemstate = state;
	}
	/**
	 * Returns all outgoing {@link ReuseEdge}s from this {@link ReuseNode}. If
	 * there are none the returned {@link java.util.Collection} will be empty
	 * (but never <code>null</code>).
	 * 
	 * @return
	 */
	public Collection<ReuseEdge<S, I, O>> getEdges() {
		return Arrays.asList(edges);
	}

	/**
	 * Adds an outgoing {@link ReuseEdge} to this {@link ReuseNode}.
	 * 
	 * @param edge
	 */
	public void addEdge(int index, ReuseEdge<S, I, O> edge) {
		this.edges[index] = edge;
	}

	/**
	 * Maybe <code>null</code>.
	 * 
	 * @param input
	 * @return
	 */
	public ReuseEdge<S, I, O> getEdgeWithInput(int index) {
		return this.edges[index];
	}

	public ReuseNode<S, I, O> getTargetNodeForInput(int index) {
		ReuseEdge<S, I, O> edge = this.getEdgeWithInput(index);
		if (edge == null) {
			return null;
		}
		return edge.getTarget();
	}
}