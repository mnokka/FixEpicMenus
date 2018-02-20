//
// Get issue issue type and if EPIC do not show Create Subtask menu entry
// Using Script Runner Script fragments
// Jan 2018  mika.nokka1@gmail.com
//
//
// Hide system or plugin UI element
// hide element: com.atlassian.jira.plugin.system.issueoperations:create-subtask
// condition: This file in Jira's .../scripts directory
//
// TODO: Multiple target projects handling

import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.atlassian.jira.issue.Issue


	//**************** CONFIGURATIONS ****************************
	
String  KillIssueType="Epic"
//String  TargetProject="CreateCorrectSubtask" //ALM DEMO
String TargetProject="COPY_OF_GAAS_ONLY_TESTING" // if more projects use array
String TargetProject2="GaaS"
String TargetProject3="GaaS Training - Not for production use"
String TargetProject4="Impala Production"
//String TargetProject="FindNextVersion"
//String TargetProject="abc_Testing"

	 // ***************** END OF CONFIGURATIONS ****************************
	
		def log = Logger.getLogger("FixEpicMenus")
		log.setLevel(Level.INFO) // DEBUG INFO
	
		
		//log.debug("---------- GetissueType started ---------------------------------------")
		//log.debug("issue: ${issue}")

			
		def type=issue.getIssueType().getName() // Jira7
		def project=issue.getProjectObject().getName()
			//def type=issue.getIssueTypeObject().getName() // Jira6
		//log.debug("type: ${type}")
		//log.debug("project: ${project}")
		
		if(project==TargetProject || project==TargetProject2 ||  project==TargetProject3) {
			//log.debug("Target Project found: ${project}")
			
			if (type==KillIssueType) {
				log.info("Project: ${project} issue ${issue} is EPIC --> Preventing Create Subtask menu entry  ")
				return false
				}
	
			else { // not EPIC
				//log.debug("Not Epic, no actions")
				return true
			}
		}
		else { // wrong project
			return true
		}
			
		
