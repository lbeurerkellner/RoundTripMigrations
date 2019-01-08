/**
 * Generates a random graph for the given seed and
 * node-factory function.
 * 
 * @param seed Numeric seed for the graph generation
 * @param numNodes The number of nodes in the generated graph.
 * @param maxOutgoingEdges The maximum number of outgoing edges per node
 * @param nodeFactory Factory function create new Node instances (~Object with {id: int, successors: [Node]})
 */
function randomGraph(seed, numNodes, maxOutgoingEdges, nodeFactory) {
	const prng = new PseudoRandomNumberGenerator(seed);
	const nodes = [];
	
	// initialize all node instances
	while (nodes.length < numNodes) {
		nodes.push(nodeFactory());
	}
	
	// initialize edges
	for (let i=0; i<nodes.length; i++) {
		const n = nodes[i]
		// choose a random number of edges
		const numberOfOutgoingEdges = prng.randomInt(Math.min(maxOutgoingEdges + 1, numNodes));
		for (let o=0; o<numberOfOutgoingEdges; o++) {
			// choose a random edge target (multiple links from one
			// node to another are possible)
			const randomNode = prng.choose(nodes);
			n.successors.push(randomNode);
		}
	}
	
	return prng.choose(nodes);
}

/**
 * A pseudo-random number generator.
 */
class PseudoRandomNumberGenerator {
	/**
	 * Instantiates a new PRNG with the given seed.
	 * 
	 * If no seed is specified a random seed is chosen using {@code Math.random()}.
	 */
	constructor(seed = Math.random()) {
		this.seed = seed;
	}
	
	/** 
	 * Generates a pseudo-random number with the fixed seed 
	 * of this PRNG instance.
	 */
	createRandom() {
		const r = Math.sin(this.seed++) * 10000;
		const result = r - Math.floor(r);
		return result;
	}
	/**
	 * Generates a random number between the given upper and
	 * lower bounds.
	 * 
	 * @param upper Excluded upper bound.
	 * @param lower Included lower bound.
	 */
	random(upper = 1, lower = 0) {
		return Math.abs(lower + (upper - 1 - lower) * this.createRandom());
	}
	
	/**
	 * Generates a random integer between the given upper and
	 * lower bounds.
	 */
	randomInt(upper = 1, lower = 0) {
		const i = this.random(upper, lower);
		return Math.floor(i);
	}
	
	/**
	 * Chooses a random element from the given array.
	 */
	choose(array) {
		const index = this.randomInt(0, array.length);
		if (index < 0 || index >= array.length) {
			throw "Invalid random index " + index + " wrt array of size " + array.length
		}
		return array[index];
	}
}

if (typeof module !== "undefined") {
	module.exports = {
		PseudoRandomNumberGenerator: PseudoRandomNumberGenerator,
		randomGraph: randomGraph
	};
}