package com.baselogic.tutorials.domain;

import java.util.*;

/**
 * SudRequestFixture
 */
public final class IncidentFixture {

    public static Incident incident() {
        Incident request = new Incident();
//        request.setName("Initial ESP SUD");
//        request.setProject("ESP");
//        request.setProjectVersion("1.0-SNAPSHOT");
//        request.setInstallationInstructions("Some installation instructions");
//        request.setReleaseNotes("Some release notes");
//        request.setEnvironment("INT");
//        request.setSubmitterUserId("dev2");
//        request.setSubmitterUserName("Developer Two");

        return request;
    }

    //-----------------------------------------------------------------------//

    public static List<Comment> comments() {
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(new Comment("dev1", "random dev comment", Calendar.getInstance()));
        comments.add(new Comment("dev2", "random dev comment 2", Calendar.getInstance()));
        comments.add(new Comment("test1", "random test comment", Calendar.getInstance()));
        return comments;
    }
    //-----------------------------------------------------------------------//

    public static List<String> projects(){
        return new ArrayList<String>(){{
            add("ESP");
            add("Commercial");
            add("Turnpike");
            add("DAS");
            add("DTA");
            add("SIK");
            add("xIVR");
        }};
    }

    //-----------------------------------------------------------------------//
    public static List<String> projectVersions(String project){
        List<String> results = new ArrayList<String>();

        if ("ESP".equalsIgnoreCase(project)) {
            results.add("1.0-SNAPSHOT");
            results.add("1.0-SNAPSHOT");
        } else if ("Commercial".equalsIgnoreCase(project)) {
            results.add("1.0-SNAPSHOT");
            results.add("1.0-SNAPSHOT");
        } else if ("Turnpike".equalsIgnoreCase(project)) {
            results.add("1.0-SNAPSHOT");
            results.add("1.0-SNAPSHOT");
        }
        return results;
    }

    //-----------------------------------------------------------------------//
    public static List<Malfunction> artifacts(String project, String version){
        List<Malfunction> results = new ArrayList<Malfunction>(){{
//            add(new Malfunction("EspWebServiceOne", "com.comcast.oxygen.foo", "10.1", "WAR"));
//            add(new Malfunction("EspWebServiceTwo", "com.comcast.oxygen.foo", "12.1", "WAR"));
        }};

//        if ("ESP".equalsIgnoreCase(project)) {
//            //
//        } else if ("Commercial".equalsIgnoreCase(project)) {
//            //
//        } else if ("Turnpike".equalsIgnoreCase(project)) {
//            //
//        }

        return results;
    }

    //-----------------------------------------------------------------------//
    /*public static List<Environment> environments(String project,
                                                    String version) {

        List<Environment> results = new ArrayList<Environment>(){{
            add(new Environment("ESPProdFarmA", "prod", "Prod Farm A For ESP"));
            add(new Environment("ESPProdFarmB", "prod", "Prod Farm A For ESP"));
        }};

        if ("ESP".equalsIgnoreCase(project)) {
            //
        } else if ("Commercial".equalsIgnoreCase(project)) {
            //
        } else if ("Turnpike".equalsIgnoreCase(project)) {
            //
        }

        return results;
    }*/

    /*public static List<Environment> environments(String project,
                                                    String version,
                                                    String environmentClass) {

        List<Environment> results = new ArrayList<Environment>(){{
            add(new Environment("ESPProdFarmA", "prod", "Prod Farm A For ESP"));
            add(new Environment("ESPProdFarmB", "prod", "Prod Farm A For ESP"));
        }};

        if ("ESP".equalsIgnoreCase(project)) {
            //
        } else if ("Commercial".equalsIgnoreCase(project)) {
            //
        } else if ("Turnpike".equalsIgnoreCase(project)) {
            //
        }

        return results;
    }*/


    //-----------------------------------------------------------------------//
    public static List<String> availableAutoTest(String project,
                                                 String environment_class,
                                                 String environment) {

        throw new UnsupportedOperationException();
//        List<String> results = new ArrayList<String>(){{
//            add("Simple Validation Test 1");
//            add("Simple Validation Test 2");
//        }};
//
//        return results;
    }

    public static Set<String> selectedTests() {
        return new HashSet<String>(){{
            add("Sample-ESP-QA");
            add("DevicePulseCheckJenkinsJob");
        }};
    }

    /*public static Set<Equipment> testJobResultsAllPass(Set<String> selectedTests) {
        return new HashSet<Equipment>(){{
            add(new Equipment("TestName1", "jobId1", ActivitiConstants.SUCCESS));
        }};
    }*/

    /*public static List<Equipment> testJobResults(Set<String> selectedTests) {
        boolean shouldBeSuccessful = true;

        List<Equipment> results = new ArrayList<Equipment>();
        for(String testName: selectedTests){
            if(shouldBeSuccessful){
                results.add(new Equipment(testName, "jobId1-"+testName, ActivitiConstants.SUCCESS));
                shouldBeSuccessful = false;
            } else {
                results.add(new Equipment(testName, "jobId1-"+testName, ActivitiConstants.FAILED));
                shouldBeSuccessful = true;
            }
        }
        return results;
    }*/


    //-----------------------------------------------------------------------//

    //-----------------------------------------------------------------------//

}
