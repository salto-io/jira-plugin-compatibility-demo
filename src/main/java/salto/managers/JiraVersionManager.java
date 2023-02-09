package salto.managers;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.plugin.PluginController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

/**
 * This component handle which module to enable.
 *
 * Modules are located in atlassian-plugin.xml
 */
@Controller
public class JiraVersionManager implements InitializingBean {
  private final PluginController pluginController;
  private final ApplicationProperties applicationProperties;

  public JiraVersionManager() {
    this.applicationProperties = ComponentAccessor.getApplicationProperties();
    this.pluginController = ComponentAccessor.getPluginController();
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    String jiraVersionString = applicationProperties.getString("jira.version");
    int jiraMajorVersion = 8; //default value
    try {
      jiraMajorVersion = Integer.parseInt(jiraVersionString.split("\\.")[0]);
    } catch (Exception e) {
      //do nothing
    }
    if (jiraMajorVersion < 9) {
      pluginController.disablePluginModule("io.salto.compatibility.demo:get.started.webwork_9");
      pluginController.enablePluginModule("io.salto.compatibility.demo:get.started.webwork");
    } else {
      pluginController.enablePluginModule("io.salto.compatibility.demo:get.started.webwork_9");
      pluginController.disablePluginModule("io.salto.compatibility.demo:get.started.webwork");
    }
  }
}