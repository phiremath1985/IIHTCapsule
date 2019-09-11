Please follow the below steps to setup and run the Application developed for Capsule IIHT

Steps as followes :


1> Install MySQL Server ans Run the Applocation
2> Create Capsule Database using the scripts fron Import database-script-capsule.sql  (Present in capsuleIIHT\src\main\resources)


4> Build Application Using maven clean install
   

      

Note: UI & Service Applications are integrated in same project. 
            npm goal is added as execution step and UI build files will be compied in to static folder, Which will be included in the Build Jar


Application will be running in Port 8080. 
5> Access Application from http://localhost:8080