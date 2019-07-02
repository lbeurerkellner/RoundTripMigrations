/*
 * Copyright (c) 2018 NumberFour AG, Luca Beurer-Kellner
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Luca Beurer-Kellner - Initial API and implementation
 */
package com.enfore.n4js.n4idl.roundtrip;

// TODO remove this class
///**
// * Custom implementation of the {@link NodeEngineCommandBuilder} that also includes
// * additional RoundTrip Runner specific execution data in the ELF code.
// */
//public class RoundTripEngineCommandBuilder extends NodeEngineCommandBuilder {
//	private static final String ROUND_TRIP_GLOBAL_KEY = "$roundTripRunnerData";
//	private static final String ROUND_TRIP_MODULE_KEY = "module";
//	private static final String ROUND_TRIP_CLASS_NAME = "className";
//	
//	@Override
//	protected String getELFCode(NodeRunOptions runOptions, File node_modules,
//			 Map<Path, String> path2name, String execModule, List<String> initModules) throws IOException {
//		StringBuilder builder = new StringBuilder();
//		final String superELF = super.getELFCode(runOptions, node_modules, path2name, execModule, initModules);
//
//		if (!(runOptions instanceof RoundTripRunConfiguration)) {
//			return superELF;
//		}
//
//		// prepend global declaration of roundTrip configuration data
//		builder.append(generateRoundTripExecutionData(((RoundTripRunConfiguration) runOptions)));
//
//		// append super ELF code
//		builder.append(superELF);
//
//		return builder.toString();
//	}
//
//	/**
//	 * This is contract between concrete round-trip execution environment and run environment.
//	 */
//	private String generateRoundTripExecutionData(RoundTripRunConfiguration options) {
//		return "global." + ROUND_TRIP_GLOBAL_KEY + " = " + createRoundTripModuleJSON(options) + ";";
//	}
//
//	/**
//	 * Returns a string that encodes all execution data for the round-trip data
//	 * in terms of a JSON string.
//	 */
//	private String createRoundTripModuleJSON(RoundTripRunConfiguration options) {
//		return JSON.toString(ImmutableMap.of(ROUND_TRIP_MODULE_KEY, options.getRoundTripModule(),
//				ROUND_TRIP_CLASS_NAME, options.getRoundTripClassName()));
//	}
//}
