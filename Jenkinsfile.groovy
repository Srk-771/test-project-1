node(){
    stage('Job Name') {
        job: 'First-Maven-Project-Via-DSL'
        description: 'First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github'
    }
    stage('git clone') {
        git: 'https://github.com/Srk-771/test-project-1.git', 'master''
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean package', 'pom.xml')
    }
}

