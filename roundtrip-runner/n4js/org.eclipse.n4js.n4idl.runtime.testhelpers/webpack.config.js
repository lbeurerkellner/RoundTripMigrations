const path = require('path');

module.exports = {
	entry: './src/graph/visualisation/visualise.js',
	output: {
		filename: 'bundle.js',
		path: path.resolve(__dirname, 'dist')
	},
	mode: "production"
};
