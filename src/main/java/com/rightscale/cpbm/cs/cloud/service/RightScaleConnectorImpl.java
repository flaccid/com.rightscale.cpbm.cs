package com.rightscale.cpbm.cs.cloud.service;

import com.rightscale.cpbm.cs.cloud.connector.RightScaleMetadataRegistry;
import com.rightscale.cpbm.cs.cloud.collectors.RightScaleEventCollector;
import com.rightscale.cpbm.cs.cloud.collectors.RightScaleUsageCollector;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleAccountLifeCycleHandler;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleSubscriptionLifecycleHandler;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleUserLifeCycleHandler;
import com.rightscale.cpbm.cs.cloud.views.RightScaleViewResolver;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.citrix.cpbm.platform.admin.service.utils.ServiceInstanceConfiguration;
import com.citrix.cpbm.platform.spi.APIHandler;
import com.citrix.cpbm.platform.spi.AccountLifecycleHandler;
import com.citrix.cpbm.platform.spi.CloudConnector;
import com.citrix.cpbm.platform.spi.EventCollector;
import com.citrix.cpbm.platform.spi.MetadataRegistry;
import com.citrix.cpbm.platform.spi.SsoHandler;
import com.citrix.cpbm.platform.spi.SubscriptionLifecycleHandler;
import com.citrix.cpbm.platform.spi.UsageCollector;
import com.citrix.cpbm.platform.spi.UserLifecycleHandler;
import com.citrix.cpbm.platform.spi.ViewResolver;

public class RightScaleConnectorImpl implements CloudConnector {

	private ServiceInstanceConfiguration serviceInstanceConfiguration;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private RightScaleMetadataRegistry metadataRegistry;
	@Autowired
	private RightScaleAccountLifeCycleHandler accountLifecycleHandler;
	@Autowired
	private RightScaleUserLifeCycleHandler userLifecycleHandler;
	@Autowired
	private RightScaleSubscriptionLifecycleHandler subscriptionLifecycleHandler;
	@Autowired
	private RightScaleUsageCollector usageCollector;
	@Autowired
	private RightScaleEventCollector eventCollector;
	@Autowired
	private RightScaleViewResolver viewResolver;

	public void setServiceInstanceConfiguration(
			ServiceInstanceConfiguration serviceInstanceConfiguration) {
		this.serviceInstanceConfiguration = serviceInstanceConfiguration;
		metadataRegistry.initialize(this);
		accountLifecycleHandler.initialize(this);
		userLifecycleHandler.initialize(this);
		subscriptionLifecycleHandler.initialize(this);
		eventCollector.initialize(this);
		usageCollector.initialize(this);
		viewResolver.initialize(this);
	}

	@Override
	public ServiceInstanceConfiguration getServiceInstanceConfiguration() {
		return serviceInstanceConfiguration;
	}

	@Override
	public MetadataRegistry getMetadataRegistry() {
		return metadataRegistry;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

	@Override
	public AccountLifecycleHandler getAccountLifeCycleHandler() {
		return accountLifecycleHandler;
	}

	@Override
	public UserLifecycleHandler getUserLifeCycleHandler() {
		return userLifecycleHandler;
	}

	@Override
	public SubscriptionLifecycleHandler getSubscriptionLifecycleHandler() {
		return subscriptionLifecycleHandler;
	}

	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public UsageCollector getUsageCollector() {
		return usageCollector;
	}

	@Override
	public EventCollector getEventCollector() {
		return eventCollector;
	}

	@Override
	public ViewResolver getViewResolver() {
		return viewResolver;
	}

	@Override
	public String getServiceInstanceUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServiceUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIHandler getAPIHandler(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getAPIHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SsoHandler getSSOHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
