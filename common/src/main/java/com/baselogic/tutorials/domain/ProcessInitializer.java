package com.baselogic.tutorials.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProcessInitializer /*implements Groups*/ {

//    @Autowired
//    private IdentityService identityService;
//    @Autowired
//    private RepositoryService repositoryService;
//    @Autowired
//    protected transient RuntimeService runtimeService;

    private static final Logger logger = LoggerFactory
            .getLogger(ProcessInitializer.class);

    @PostConstruct
    public void setUp() {
//        setUpGroups();
//        setUpUsers();
//        deployProcess();
//        //removeOldExecutionsAndDeployments();
    }

    /*public void setUpUsers() {
        logger.info("Creating users for Activiti");

        addUser("dev1", "Developer", "DOne", "dev1@cable.comcast.com", GROUP_DEVELOPER);
        addUser("dev2", "Developer", "DTwo", "dev2@cable.comcast.com", GROUP_DEVELOPER);

        addUser("test1", "Tester", "TOne", "test1@cable.comcast.com", GROUP_TESTER);
        addUser("test2", "Tester", "TTwo", "test2@cable.comcast.com", GROUP_TESTER);

        addUser("rm1", "Release Manager", "ROne", "rm1@cable.comcast.com", GROUP_RELEASE_MANAGER);
        addUser("rm2", "Release Manager", "RTwo", "trm2est1@cable.comcast.com", GROUP_RELEASE_MANAGER);

        addUser("op1", "Operator", "OOne", "op1@cable.comcast.com", GROUP_OPERATOR);
        addUser("op2", "Operator", "OTwo", "op2@cable.comcast.com", GROUP_OPERATOR);


        // This is the current master user.
        addUser("admin", "Admin", "AOne", "admin1@cable.comcast.com",
                GROUP_DEVELOPER,
                GROUP_TESTER,
                GROUP_RELEASE_MANAGER,
                GROUP_OPERATOR);


        addUser("traveler", "Tom", "Traveler", "tom@foobar.net", null);
        addUser("manager", "Mike", "Manager", "mike@foobar.net", GROUP_MANAGERS);
        addUser("secretary", "Steven", "Secretary", "steven@foobar.net", GROUP_SECRETARIES);
        addUser("payroll", "Patrick", "Payroll", "patrick@foobar.net", GROUP_PAYROLLADMINS);
    }*/

    /*private void addUser(String username, String firstName, String lastName, String email, String ... groups) {
        if (!userExists(username)) {
            logger.info("Adding user {} (firstName = {}, lastName = {}, email = {})", new String[]{username, firstName, lastName, email});
            User user = identityService.newUser(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword("p");
            identityService.saveUser(user);

            if (groups != null && groups.length > 0) {
                for(String group: groups){
                    logger.info("--> Create user ({}) membership to group {}. ", group, username);
                    identityService.createMembership(username, group);
                }
            }
            identityService.createMembership(username, GROUP_EMPLOYEES);
        }
    }*/

    /*private boolean userExists(String username) {
        return identityService.createUserQuery().userId(username).singleResult() != null;
    }*/

    /*private void setUpGroups() {
        logger.info("Creating user groups for Activiti");

        // ESP, COMMERCIAL, NPS

        addGroup(GROUP_DEVELOPER, GROUP_DEVELOPER);

        addGroup(GROUP_TESTER, GROUP_TESTER);
        addGroup(GROUP_RELEASE_MANAGER, GROUP_RELEASE_MANAGER);
        addGroup(GROUP_OPERATOR, GROUP_OPERATOR);




        addGroup(GROUP_MANAGERS, "Managers");
        addGroup(GROUP_EMPLOYEES, "Employees");
        addGroup(GROUP_SECRETARIES, "Secretaries");
        addGroup(GROUP_PAYROLLADMINS, "Payroll Administrators");
    }*/

    /*private void addGroup(String groupId, String name) {
        if (!groupExists(groupId)) {
            logger.info("Adding group {} (name = {})", new String[]{groupId, name});
            Group group = identityService.newGroup(groupId);
            group.setName(name);
            identityService.saveGroup(group);
        }
    }*/

    /*private boolean groupExists(String groupId) {
        return identityService.createGroupQuery().groupId(groupId).singleResult() != null;
    }*/

    /*private void removeOldExecutionsAndDeployments() {
        List<Deployment> deployments = repositoryService.createDeploymentQuery()
                .deploymentName(ActivitiConstants.ACTIVITI_CODEWASH_PROCESS_NAME).list();

        for (Deployment deployment : deployments) {
            logger.info("deployment to delete: {}", deployment);
            repositoryService.deleteDeployment(deployment.getId(), true);
        }

    }*/


//    private void deployProcess() {
////        if (!isDeployed()) {
////            logger.info("Deploying process");
////            Deployment deployment = repositoryService.createDeployment()
////                    .name("simple-travel")
////                    .addClasspathResource("process/simple-travel.bpmn20.xml").deploy();
////            logger.info("--> Deployed process {} with id: {}", deployment.getName(), deployment.getId());
////        }
//        if (!isSudDeployed()) {
//            logger.info("Deploying SUD process");
//            Deployment deployment = repositoryService.createDeployment()
//                    .name(ActivitiConstants.ACTIVITI_CODEWASH_PROCESS_NAME)
//                    .addClasspathResource(ActivitiConstants.ACTIVITI_CODEWASH_PROCESS).deploy();
//            logger.info("--> Deployed process {} with id: {}", deployment.getName(), deployment.getId());
//        }
//    }

    /*private boolean isDeployed() {
        return repositoryService.createProcessDefinitionQuery().processDefinitionKey("simple-travel").singleResult() != null;
    }*/

    /*private boolean isSudDeployed() {
        return
        repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(ActivitiConstants.ACTIVITI_CODEWASH_PROCESS_NAME)
                .singleResult() != null;
    }*/

    /**
     * Create some tasks for testing purposes.
     */
//    public void seedExecutionTasks() {
//        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        logger.info("seedExecutionTasks()");
//
//        /*
//        sudRequest.setName((String) textField_sud.getValue());
//        sudRequest.setProject((String) comboBox_project.getValue());
//        sudRequest.setVersion((String) comboBox_version.getValue());
//        sudRequest.setReleaseNotes((String) textArea_releaseNotes.getValue());
//        sudRequest.setInstallationInstructions((String) textArea_installationNotes.getValue());
//        //sudRequest.setRelated((String)relatedContent.getValue());
//        sudRequest.setEnvironment((String) comboBoxEnvironments.getValue());
//        sudRequest.setSubmitter(((LoggedInUser) getApplication().getUser()).getId());
//         */
//
//        SudValueObject sud1 = new SudValueObject();
//        sud1.setName("Sud name 1");
//        sud1.setProject("ESP");
//        sud1.setVersion("1.1-SNAPSHOT");
//        sud1.setSubmitter("dev2");
//
//        sud1.setReleaseNotes("setReleaseNotes");
//        sud1.setInstallationInstructions("setInstallationInstructions");
//        String result = sudService.submitSudRequest(sud1);
//        logger.info("result: {}", result);
//
//        String result2 = sudService.submitSudRequest(
//                new SudValueObject("Sud name 2", "xIVR", "2.1-SNAPSHOT", "dev2")
//        );
//        logger.info("result2: {}", result2);
//
//        String result3 = sudService.submitSudRequest(
//                new SudValueObject("Sud name 3", "ESP", "3.1-SNAPSHOT", "dev1")
//        );
//        logger.info("result3: {}", result3);
//
//        String result4 = sudService.submitSudRequest(
//                new SudValueObject("Sud name 4", "xIVR", "4.1-SNAPSHOT", "dev1")
//        );
//        logger.info("result4: {}", result4);
//
//    }

}
