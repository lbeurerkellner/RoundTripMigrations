/*
 * Copyright (c) 2018 Luca Beurer-Kellner
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Luca Beurer-Kellner - Initial API and implementation
 */

/**
 * Main entry-point for running RoundTrip executions.
 * 
 * Reads the roundTripModule from the global variable that is set in the
 * RoundTrip Runner logic and imports the RoundTripRunner class.
 * 
 * Delegates to RoundTripRunner.main(constructor{AbstractRoundTripTest}) for further
 * round trip test execution.
 */
System.import($roundTripRunnerData.module).then((roundTripModule) => {
	let roundTripData = $roundTripRunnerData
	delete $roundTripRunnerData;
	
	System.import("com.enfore.n4js.n4idl.roundtrip/src-gen/com/enfore/n4js/n4idl/roundtrip/RoundTripRunner").then((runner) => {
		runner.default.main(roundTripModule[roundTripData.className], roundTripData);
	})
});