//CHECKSTYLE:OFF
package hudson.plugins.tfs.model;


import java.io.Serializable;
import java.util.Collection;

import hudson.model.InvisibleAction;

/**
 * An action for storing TFS configuration data in a build 
 * 
 * @author Erik Ramfelt, redsolo
 */
public class WorkspaceConfiguration extends InvisibleAction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final String workspaceName;
    private final String workfolder;
    private final String projectPath;
    private final String serverUrl;
    private boolean workspaceExists;
    private Collection<String> cloakedPaths;
    private final boolean isLocalWorkspace;

    public WorkspaceConfiguration(String serverUrl, String workspaceName, String projectPath, Collection<String> cloakedPaths, String workfolder, boolean isLocalWorkspace) {
        this.workspaceName = workspaceName;
        this.workfolder = workfolder;
        this.projectPath = projectPath;
        this.serverUrl = serverUrl;
        this.workspaceExists = true;
        this.cloakedPaths = cloakedPaths;
        this.isLocalWorkspace = isLocalWorkspace;
    }

    public WorkspaceConfiguration(WorkspaceConfiguration configuration) {
        this.workspaceName = configuration.workspaceName;
        this.workfolder = configuration.workfolder;
        this.projectPath = configuration.projectPath;
        this.serverUrl = configuration.serverUrl;
        this.workspaceExists = configuration.workspaceExists;
        this.cloakedPaths = configuration.cloakedPaths;
        this.isLocalWorkspace = configuration.isLocalWorkspace;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public String getWorkfolder() {
        return workfolder;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getServerUrl() {
        return serverUrl;
    }
    
    public boolean workspaceExists() {
        return workspaceExists;
    }
    
    public void setWorkspaceWasRemoved() {
        this.workspaceExists = false;
    }

    public Collection<String> getCloakedPaths() {
        return cloakedPaths;
    }

    public boolean isLocalWorkspace() {
        return isLocalWorkspace;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((projectPath == null) ? 0 : projectPath.hashCode());
        result = prime * result + ((serverUrl == null) ? 0 : serverUrl.hashCode());
        result = prime * result + ((workfolder == null) ? 0 : workfolder.hashCode());
        result = prime * result + (workspaceExists ? 1231 : 1237);
        result = prime * result + ((workspaceName == null) ? 0 : workspaceName.hashCode());
        result = prime * result + ((cloakedPaths == null) ? 0 : cloakedPaths.hashCode());
        result = prime * result + (isLocalWorkspace ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof WorkspaceConfiguration))
            return false;
        WorkspaceConfiguration other = (WorkspaceConfiguration) obj;
        if (projectPath == null) {
            if (other.projectPath != null)
                return false;
        } else if (!projectPath.equals(other.projectPath))
            return false;
        if (serverUrl == null) {
            if (other.serverUrl != null)
                return false;
        } else if (!serverUrl.equals(other.serverUrl))
            return false;
        if (workfolder == null) {
            if (other.workfolder != null)
                return false;
        } else if (!workfolder.equals(other.workfolder))
            return false;
        if (workspaceExists != other.workspaceExists)
            return false;
        if (workspaceName == null) {
            if (other.workspaceName != null)
                return false;
        } else if (!workspaceName.equals(other.workspaceName))
            return false;
        if (cloakedPaths == null) {
            if (other.cloakedPaths != null)
                return false;
        } else if (other.cloakedPaths == null)
            return false;
        else if (cloakedPaths.size() != other.cloakedPaths.size())
            return false;
        else if (!cloakedPaths.containsAll(other.cloakedPaths))
            return false;
        if (isLocalWorkspace != other.isLocalWorkspace)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("WorkspaceConfiguration [projectPath=%s, serverUrl=%s, workfolder=%s, workspaceExists=%s, workspaceName=%s, workspaceLocation=%s]", 
                projectPath, serverUrl, workfolder, workspaceExists, workspaceName, isLocalWorkspace);
    }
}
