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
package com.enfore.n4js.n4idl.roundtrip.ui.launch

import com.enfore.n4js.n4idl.roundtrip.ui.launch.RoundTripLaunchConfigurationTab
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.n4js.runner.ui.RunnerLaunchConfigurationMainTab

/**
 * Node.js launch configuration tab group. Creates the main tab and one for the Node.js specific
 * settings.
 */
public class RoundTripRunnerLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Inject
	private Provider<RunnerLaunchConfigurationMainTab> mainTabProvider;

	@Inject
	private Provider<RoundTripLaunchConfigurationTab> roundTripTabProvider;

	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		tabs = #[mainTabProvider.get, roundTripTabProvider.get];
	}

}
