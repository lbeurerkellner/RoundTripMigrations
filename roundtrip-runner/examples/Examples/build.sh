#!/bin/bash
#
# Script to run a headless build of the Examples project
#
if [ -d "deps/" ]; then
	n4jsc -t projects -pl /Users/luca.beurer-kellner/round-trip-runner/n4js/:n4js-node:n4js-es5:./ Examples -tp platform.n4tp -tl deps/ --targetPlatformSkipInstall
else
	n4jsc -t projects -pl /Users/luca.beurer-kellner/round-trip-runner/n4js/:n4js-node:n4js-es5:./ Examples -tp platform.n4tp -tl deps/ 
fi

