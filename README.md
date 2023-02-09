This demo can help you write a Jira plugin with UI elements that will be available in both Jira 8 and Jira 9.
It is based on the knowledge shared here: https://community.developer.atlassian.com/t/how-to-work-around-the-supportedmethod-problem/57747

A few notes:
* In this demo the UI is displayed only for admins as part of the configuration. It also adds a shortcut to the top navigation bar.
* This demo uses a 3rd party component by Sevidev that mocks the atlassian's com.atlassian.jira.security.request relevant classes so the project will compile on Jira 8.
  You can write your own mock instead.
