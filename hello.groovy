import jenkins.model.*
import hudson.util.Secret
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import org.jenkinsci.plugins.plaincredentials.impl.*

import com.cloudbees.hudson.plugins.folder.*
domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
jenkins = Jenkins.instance

for (folder in jenkins.getAllItems(Folder.class)) {
    if(folder.name.equals("ESB")) {
        AbstractFolder<?> folderAbs = AbstractFolder.class.cast(folder)
        com.cloudbees.hudson.plugins.folder.properties.FolderCredentialsProvider.FolderCredentialsProperty property = folderAbs.getProperties().get(com.cloudbees.hudson.plugins.folder.properties.FolderCredentialsProvider.FolderCredentialsProperty.class)
        
    secretText = new StringCredentialsImpl(
    CredentialsScope.GLOBAL,
    "secret-text",
    "Secret Text Description",
    Secret.fromString("some secret text goes here"))
    Domain dm = new Domain("trying","hsdkhfdhfs",null)
    
   property.getStore().addDomain(dm ,secretText)
     property.getStore().addCredentials(dm, secretText)
    }
}


