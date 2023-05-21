pipeline {
    agent any
    tools {
       maven 'MAVEN3.6.3'       
    }    
    stages {
        stage('Build') {
            steps {
                sh 'mvn -f Cucumber/pom.xml -B -DskipTests clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts....."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f Cucumber/pom.xml test'
                sh 'mvn clean verify -DfailIfNoTests=false'
            }
            post {
                always {
                    junit 'Cucumber/target/surefire-reports/*.xml'
                    html 'target/cucumber-report.html'
                }
            }
        }
    }
}
