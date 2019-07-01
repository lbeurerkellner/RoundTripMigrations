## N4IDL Test Helpers
This project contains test-helpers with regard to N4IDL Migration Runtime tests `com.enfore.n4js.n4idl.roundtrip.tests`.

On the one hand, this project may be included as a dependency from test projects. On the other hand it may also be handled as a standalone webpack project, which provides a mini-tool for inspecting test data. 

## migrations/*

These modules contain test helpers with regard to the ECMAScript runtime representation of N4IDL migrations.

## graph/visualisation/*

These modules, are test helpers for the random generation of instance dependency graphs.

The `graph/RandomGraphGenerator.js` contains a seedable generator for instance graphs which can be used to generate test data. The generator is implemented independently from a concrete node model and can be supplied with a factory-function (`nodeFactory`) for generating node instance of a concrete data model.

To facilitate the implementation of tests with regard to instance graph dependencies, these test helpers provide a mini-tool to visualise the graphs that are being generated for a given seed and basis parameters (see `RandomGraphGenerator.n4jsd` for a typed API documentation).

### Bundling the Mini-Tool for Graph Visualisation

The graph visualisation is implemented in terms of a locally accessible mini-webapp which is bundled using webpack. To use it, you must first install its dependencies using [yarn](https://yarnpkg.com/en/). Run the following command in the root folder of this project:

	yarn

To bundle the current version of the mini-tool, execute the following command in the root directory of the test helpers project:

	npx webpack
	
This will bundle the corresponding sources and dependencies. You can than access the mini-tool by opening [`dist/visualise-graph.html`](dist/visualise-graph.html) in a browser.
