package com.axway.apim.api.export.lib;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

public class APIUnpublishCLIOptions extends APIExportCLIOptions {

	CommandLine cmd;

	public APIUnpublishCLIOptions(String[] args) throws ParseException {
		super(args);
	}

	@Override
	public void printUsage(String message, String[] args) {
		super.printUsage(message, args);		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("How to unpublish APIs using different filter options:");
		System.out.println(getBinaryName()+" api unpublish -s api-env");
		System.out.println(getBinaryName()+" api unpublish -s api-env -n \"*API*\"");
		System.out.println(getBinaryName()+" api unpublish -s api-env -id f6106454-1651-430e-8a2f-e3514afad8ee");
		System.out.println(getBinaryName()+" api unpublish -s api-env -policy \"*Policy ABC*\"");
		System.out.println(getBinaryName()+" api unpublish -s api-env -name \"*API*\" -policy \"*Policy ABC*\"");
		System.out.println();
		System.out.println();
		System.out.println("For more information and advanced examples please visit:");
		System.out.println("https://github.com/Axway-API-Management-Plus/apim-cli/wiki");
	}

	@Override
	protected String getAppName() {
		return "API-Export";
	}


}
