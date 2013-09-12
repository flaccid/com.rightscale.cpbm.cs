package com.rightscale.cpbm.cs.cloud.collectors;

import java.util.Date;

import com.citrix.cpbm.platform.exception.UsageCollectionException;
import com.citrix.cpbm.platform.model.UsageResultSet;
import com.citrix.cpbm.platform.spi.Connector;
import com.citrix.cpbm.platform.spi.UsageCollector;

/**
 * The Cloud Service's Usage Collection Service.
 */
public class RightScaleUsageCollector implements UsageCollector {

	public void initialize(Connector service) {
    // TODO Auto-generated method stub
	}

	@Override
	public UsageResultSet collect(String startMarker, Date endDate)
			throws UsageCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

}
