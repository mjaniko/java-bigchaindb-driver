package com.authenteq.api;

import java.io.IOException;

import com.authenteq.constants.BigchainDbApi;
import com.authenteq.model.Assets;
import com.authenteq.model.Globals;
import com.authenteq.model.Outputs;
import com.authenteq.util.JsonUtils;
import com.authenteq.util.NetworkUtils;

import okhttp3.Response;


/**
 * The Class OutputsApi.
 */
public class OutputsApi {

	/**
	 * Gets the outputs.
	 *
	 * @param publicKey the public key
	 * @return the outputs
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Outputs getOutputs(String publicKey) throws IOException { 
		Response response = NetworkUtils.sendGetRequest(Globals.getBaseUrl() + BigchainDbApi.OUTPUTS + "?public_key="+ publicKey);
		return JsonUtils.fromJson(response.body().string(), Outputs.class);
	}
	
	/**
	 * Gets the spent outputs.
	 *
	 * @param publicKey the public key
	 * @return the spent outputs
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Outputs getSpentOutputs(String publicKey) throws IOException { 
		Response response = NetworkUtils.sendGetRequest(Globals.getBaseUrl() + BigchainDbApi.OUTPUTS + "?public_key="+ publicKey+ "&spent=true");
		return JsonUtils.fromJson(response.body().string(), Outputs.class);
	}
	
}
