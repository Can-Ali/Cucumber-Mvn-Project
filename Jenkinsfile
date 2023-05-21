pipeline {
    agent any
    tools {
        maven 'MAVEN'
        jdk 'JDK'
    }
    options {
        timestamps ()
        ansiColor('xterm')
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -f pom.xml -B -DskipTests clean package'
            }
            post {
                success {
//                     echo "Now Archiving the Artifacts....."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f pom.xml test'
                sh 'mvn clean verify -DfailIfNoTests=false'
            }
//             post {
//                 always {
//                     junit 'Cucumber-Mvn-Project/target/surefire-reports/*.xml'
//                     html 'target/cucumber-report.html'
//                 }
//             }
        }
        stage('Cucumber Report') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: "target"
            }
        }
    }
}
