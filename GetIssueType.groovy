//
// Get issue issue type
// Using Script Runner Script fragments
// Jan 2018  mika.nokka1@gmail.com
//



import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.ComponentManager



	//**************** CONFIGURATIONS ****************************
	
String  KillIssueType="Epic"
	
	 // ***************** END OF CONFIGURATIONS ****************************
	
		def log = Logger.getLogger("GetissueType")
		log.setLevel(Level.DEBUG) // DEBUG INFO
	
		
		log.debug("---------- GetissueType started ---------------------------------------")
		log.debug("issue: ${issue}")

		//issue=underlyingIssue // from ScriptRunner example code
		//def versionManager = ComponentAccessor.getVersionManager()
		//def projectManager = ComponentAccessor.getProjectManager()
		//def project = projectManager.getProjectObjByKey(issueContext.projectObject.key)
		//def versions = versionManager.getVersions(project)
		//def issueManager = ComponentAccessor.getIssueManager()

			
		def type=issue.getIssueType().getName() // Jira7
			//def type=issue.getIssueTypeObject().getName() // Jira6
		log.debug("type: ${type}")
		
		if (type==KillIssueType) {
			log.debug("EPIC FOUND")
			return false
			}
		
			
		else {
			return true
		}
		log.debug("---------- GetissueType stopped ---------------------------------------")

