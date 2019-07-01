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

import org.eclipse.n4js.runner.RunConfiguration;

/**
 * Run options that also hold information on the round trip module.
 */
public class RoundTripRunConfiguration extends RunConfiguration {
	private String roundTripModule;
	private String roundTripClassExportedName;
	/**
	 * @return the roundTripModule
	 */
	public String getRoundTripModule() {
		return roundTripModule;
	}

	/**
	 * @param roundTripModule the roundTripModule to set
	 */
	public void setRoundTripModule(String roundTripModule) {
		this.roundTripModule = roundTripModule;
	}

	/**
	 * @return the roundTripClassExportedName
	 */
	public String getRoundTripClassName() {
		return roundTripClassExportedName;
	}

	/**
	 * @param roundTripClassExportedName the roundTripClassExportedName to set
	 */
	public void setRoundTripClassName(String roundTripClassExportedName) {
		this.roundTripClassExportedName = roundTripClassExportedName;
	}


}
