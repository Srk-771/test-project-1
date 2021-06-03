node(){
    stage('git clone'){
        git branch: 'master'
        git url: 'https://github.com/Srk-771/test-project-1.git'
        pollSCM: '* * * * *' 
    }
    stage('mvn'){
        sh 'M2_HOME pom.xml clean package'
    }
    stage('Send build artifacts over SSH'){
        publishers: configName: 'Testing-Host', sourceFiles: 'webapp/target/*.war', removePrefix: 'webapp/target', remoteDirectory: '.'
    }
}