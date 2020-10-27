<h2>Quick Start Guid:</h2>

<h4>Components:</h4>

    1. Conductor server binary and configuration file. (Server folder)
    2. Worker microservice with workflows definations and following task workers.
    
    Workflows:
         a. CE_Event
         b. Discovery
         c. DLS_Event
         d. DMS_Event
         
    Task workers:
    
         a. ClassificationOffline
         b. Classification
         c. DLSOffline
         d. DLS
         e. DMSUpdate
         f. Synchronization
         
    3. Worker and Client wrapper libraries (workerservice/src/main/resources/lib/)

<h4>Start the conductor Server:</h4>
  
     1. Create a empty db in postgres with desired name like conductor.
     2. Give the same database name in the server/config.properties file under db configuration.
     3. run the following command in the command prompt from server folder.
       
        java -jar .\conductor-server-2.29.0-SNAPSHOT-all.jar .\config.properties 
        
     4. server is up with the port configured in the config file.
     5. you can check by accessing the localhost:<port> in the browser, it should load the swagger ui.
     
    
<h4>Install the libraries in local repository:</h4>

    1. Open the command prompt and navigate to /workerservice/src/main/resources/lib path
    2. run the following commands to install the libraties in to the local maven repository.
    
      > mvn install:install-file -Dfile=nconductor-client-wrapper-0.0.5.jar -DgroupId=com.tuplescale.conductor -DartifactId=nconductor-client-wrapper -Dversion=0.0.5 -Dpackaging=jar
      
      > mvn install:install-file -Dfile=nconductor-worker-library-0.0.5.jar -DgroupId=com.tuplescale.conductor  -DartifactId=nconductor-worker-library -Dversion=0.0.5 -Dpackaging=jar


Start the microservice :

  This is a maven project, we can import in any editor like eclipse or inteliji and run the service.
  once we start the service all the workflows under resources folder are created in the conductor server.
  
  End points: to trigger the workflow.
  
    URI: /workflow/{name}/{version}
    Method: GET
    returns : workflow id
    
    
    
   
