import hudson.plugins.git.*;

def scm = new GitSCM("https://github.com/Srk-771/test-project-1.git")
scm.branches = [new BranchSpec("master")];

def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile-build.groovy")

def parent = Jenkins.instance
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, "New Job")
job.definition = flowDefinition

parent.reload()
