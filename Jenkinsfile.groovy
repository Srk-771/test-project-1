def jobs = ["JobA", "JobB", "JobC"]
 
def parallelStagesMap = jobs.collectEntries {
    ["${it}" : generateStage(it)]
}
 
def generateStage(job) {
    return {
        stage("stage: ${job}") {
                echo "This is ${job}."
        }
    }
}
pipeline {
    stage('Job Name') {
        job: 'First-Maven-Project-Via-DSL_1'
        description: 'First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github'
    }
    stage('git clone') {
        git url: 'https://github.com/Srk-771/test-project-1.git'
    }
    stage('pollscm') {
        poll: '* * * * *'
    }
    stage('maven build') {
        sh 'mvn clean install'
    }
}

