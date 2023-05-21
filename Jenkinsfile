pipeline {
    agent any
    tools {
        maven 'MAVEN3.9.2'
        jdk 'AdoptOpenJDK_8u222'
    }
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    'mvn pmd:pmd -s usersettings.xml'
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
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
