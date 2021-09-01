pipeline {
agent any
    stages {
        stage('CheckOut')
         {
            steps {
                echo 'Hello World'
                git branch: '${branch}', url:'https://github.com/repo1/winapp.git'
            }
        }
        stage('Build')
           {
                steps {   
                    echo 'Building ....'  
                    echo  'Product Version ${env.BUILD_NUMBER}'            
                    bat 'dotnet --version'
		            //bat 'd:/Tools/nuget.exe restore ConsoleApp1/ConsoleApp1.sln'
		            bat 'dotnet restore ConsoleApp1/ConsoleApp1.sln'
                    //bat "\"${tool 'MSBuild'}\" ConsoleApp1\ConsoleApp1.sln /p:Configuration=Release /p:Platform=\"Any CPU\" /p:ProductVersion=1.0.0.${env.BUILD_NUMBER}"
                    bat 'dotnet msbuild ConsoleApp1/ConsoleApp1.sln /p:Configuration=Release /p:Platform="Any CPU" /p:ProductVersion=1.0.0.${env.BUILD_NUMBER}'
                }
           }
         stage('Test')
         {
             steps {
             echo 'Testing ...'
             }
         }
        stage ('Archive')
        {
            steps
            {                   
		         //archiveArtifacts './ConsoleApp1/ConsoleApp1/bin/Release/**';
                 archiveArtifacts '/ConsoleApp1/ConsoleApp1/bin/Release/**';
            }
        }
        stage('Deploy')
        {
            steps {
            echo 'Deploying ....'
            }
        }

        }
    }


