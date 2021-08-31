pipeline {
agent any
    stages {
        stage('CheckOut')
         {
            steps {
                echo 'Hello World'
            }
        }
        stage('Build')
           {
                steps
                {                   
		            //bat 'nuget restore SolutionName.sln'
		            bat "\"${tool 'MSBuild'}\" ConsoleApp1.sln /p:Configuration=Release /p:Platform=\"Any CPU\" /p:ProductVersion=1.0.0.${env.BUILD_NUMBER}"
                }
           }
        stage ('Archive')
        {
            steps
            {                   
		         bat archive 'ProjectName/bin/Release/**'
            }
        }

        }
    }


