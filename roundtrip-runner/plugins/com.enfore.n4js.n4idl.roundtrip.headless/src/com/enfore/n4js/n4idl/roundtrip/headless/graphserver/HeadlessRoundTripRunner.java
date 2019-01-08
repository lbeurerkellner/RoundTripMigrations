/**
 * Copyright (c) 2018 NumberFour AG, Luca Beurer-Kellner
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Luca Beurer-Kellner - Initial API and implementation
 */
package com.enfore.n4js.n4idl.roundtrip.headless.graphserver;

import java.util.Properties;

import org.eclipse.n4js.hlc.base.ExitCodeException;
import org.eclipse.n4js.hlc.base.HeadlessExtensionRegistrationHelper;
import org.eclipse.n4js.hlc.base.N4jscBase;
import org.eclipse.n4js.hlc.base.SuccessExitStatus;
import org.eclipse.n4js.runner.extension.RunnerRegistry;

import com.enfore.n4js.n4idl.roundtrip.RoundTripRunnerModule;
import com.enfore.n4js.n4idl.roundtrip.RoundTripRunner;
import com.enfore.n4js.n4idl.roundtrip.RoundTripRunner.RoundTripRunnerDescriptorProvider;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * A command line utility to run N4IDL RoundTrip Scenarios.
 *
 * This utility does not compile sources. Please use N4JSC to compile
 * the sources beforehand.
 *
 * @author luca.beurer-kellner
 *
 */
public class HeadlessRoundTripRunner extends N4jscBase {
	private static class RoundTripHeadlessExtensionRegistrationHelper extends HeadlessExtensionRegistrationHelper {
		@Inject
		RunnerRegistry runnerRegistry;
		@Inject
		RoundTripRunnerDescriptorProvider roundTripRunnerDescriptorProvider;

		@Override
		public void registerExtensions() {
			super.registerExtensions();

			runnerRegistry.register(roundTripRunnerDescriptorProvider.get());
		}
	}

	@Override
	protected Module createModule(Properties properties) {
		return Modules.combine(super.createModule(properties),
				new RoundTripRunnerModule(), new Module() {

					@Override
					public void configure(Binder binder) {
						binder.bind(HeadlessExtensionRegistrationHelper.class)
								.to(RoundTripHeadlessExtensionRegistrationHelper.class);
					}
				});
	}

	private static void printUsage() {
		System.out.println("USAGE: round-trip-runner.jar SCENARIO_PROJECT SCENARIO_MODULE_FILE");
	}

	public static void main(String[] args) {
		int exitCode;
		try {
			if (args.length < 2) {
				printUsage();
				System.exit(1);
			}

			final String scenarioProject = args[0];
			final String scenarioModule = args[1];

			String RT_PATH = System.getenv("ROUNDTRIP_RT_PATH");

			if (null == RT_PATH) {
				System.err.println("Error: RoundTrip Runner Runtime Path was not set (ROUNDTRIP_RT_PATH).");
				System.exit(1);;
			}

			SuccessExitStatus success = new HeadlessRoundTripRunner().doMain(
					"-t", "dontcompile",
					"-rw", RoundTripRunner.ID,
					scenarioProject,
					"-pl", RT_PATH,
					"-r", scenarioModule,
					"-tp", "platform.n4tp",
					"-tl", "modules/",
					"--targetPlatformSkipInstall");
			exitCode = success.code;
		} catch (ExitCodeException e) {
			exitCode = e.getExitCode();
			System.err
					.println(e.getMessage() + " exitcode: " + exitCode + e.explanationOfExitCode());
		}
		System.out.flush();
		System.err.flush();
		System.exit(exitCode);
	}
}
