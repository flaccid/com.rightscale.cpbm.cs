package com.rightscale.cpbm.cs.cloud.connector;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.citrix.cpbm.platform.admin.service.utils.ServiceInstanceConfiguration;
import com.citrix.cpbm.platform.spi.APIHandler;
import com.citrix.cpbm.platform.spi.AccountLifecycleHandler;
import com.citrix.cpbm.platform.spi.CloudConnector;
import com.citrix.cpbm.platform.spi.CloudConnectorFactory;
import com.citrix.cpbm.platform.spi.EventCollector;
import com.citrix.cpbm.platform.spi.MetadataRegistry;
import com.citrix.cpbm.platform.spi.SsoHandler;
import com.citrix.cpbm.platform.spi.SubscriptionLifecycleHandler;
import com.citrix.cpbm.platform.spi.UsageCollector;
import com.citrix.cpbm.platform.spi.UserLifecycleHandler;
import com.citrix.cpbm.platform.spi.ViewResolver;
import com.rightscale.cpbm.cs.cloud.collectors.RightScaleUsageCollector;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleAccountLifeCycleHandler;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleSubscriptionLifecycleHandler;
import com.rightscale.cpbm.cs.cloud.lifecycle.handlers.RightScaleUserLifeCycleHandler;
import com.vmops.model.Tenant;
import com.vmops.model.User;
import com.vmops.model.UserHandle;
import com.vmops.service.UserService;
import com.vmops.service.UserService.Handle;
import com.vmops.service.exceptions.CloudServiceException;

/**
 * @see CloudConnector
 */
public class RightScaleConnector implements CloudConnector {

  private ServiceInstanceConfiguration serviceInstanceConfiguration;

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private AccountLifecycleHandler accountLifecycleHandler;

  @Autowired
  private UserLifecycleHandler userLifecycleHandler;

  @Autowired
  private SubscriptionLifecycleHandler subscriptionLifecycleHandler;

  @Autowired
  private UsageCollector usageCollector;

  @Autowired
  private EventCollector eventCollector;

  @Autowired
  private ViewResolver viewResolver;

  @Autowired
  private MetadataRegistry metadataRegistry;

  private static final Logger LOGGER = Logger.getLogger(RightScaleConnector.class);

  public RightScaleConnector() {
    // we do not do anything in the constructor because all that we need in this class
    // is autowired and provided by Spring to us
  }

  /**
   * {@inheritDoc} The {@link CloudConnectorFactory} which we implemented in {@link RightScaleConnectorFactory} must invoke
   * this method. This method should configure the service and initialize the MetadataRegistry, and various lifecycle
   * handlers.
   */
  public void setServiceInstanceConfiguration(ServiceInstanceConfiguration serviceInstanceConfiguration) {
    LOGGER.debug("EN setServiceInstanceConfiguration");
    this.serviceInstanceConfiguration = serviceInstanceConfiguration;
  }

  public ServiceInstanceConfiguration getServiceInstanceConfiguration() {
    return serviceInstanceConfiguration;
  }

  public AccountLifecycleHandler getAccountLifeCycleHandler() {
    return accountLifecycleHandler;
  }

  public UserLifecycleHandler getUserLifeCycleHandler() {
    return userLifecycleHandler;
  }

  public boolean getStatus() {
    // In a real scenario we would actually invoke an API to verify the status of the service, however here we always
    // return true.
    return true;
  }

  public String getServiceUUID() {
    return serviceInstanceConfiguration.getServiceUUID();
  }

  public String getServiceInstanceUUID() {
    return serviceInstanceConfiguration.getInstanceUUID();
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public EventCollector getEventCollector() {
    return eventCollector;
  }

  public MetadataRegistry getMetadataRegistry() {
    return metadataRegistry;
  }

  public SubscriptionLifecycleHandler getSubscriptionLifecycleHandler() {
    return subscriptionLifecycleHandler;
  }

  public UsageCollector getUsageCollector() {
    return usageCollector;
  }

  public Map<String, String> getAPIHandles() {
    return null;
  }

  public APIHandler getAPIHandler(String apiGroupName) {
    // Since we do not proxy any API's in this service
    return null;
  }

  public ViewResolver getViewResolver() {
    return viewResolver;
  }

  public SsoHandler getSSOHandler() {
    // We do not have an SSO Handler in this connector till now
    return null;
  }

}
