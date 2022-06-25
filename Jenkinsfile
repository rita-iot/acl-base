pipeline {
  agent any
  stages {
    stage('检出') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: env.GIT_BUILD_REF]],
            userRemoteConfigs: [[url: env.GIT_REPO_URL, credentialsId: env.CREDENTIALS_ID]]])
      }
    }
    stage('发布到 maven 制品库') {
      steps {
        withCredentials([
          usernamePassword(
              // CODING 持续集成的环境变量中内置了一个用于上传到当前项目制品库的凭证
              credentialsId: env.CODING_ARTIFACTS_CREDENTIALS_ID,
              usernameVariable: 'CODING_ARTIFACTS_USERNAME',
              passwordVariable: 'CODING_ARTIFACTS_PASSWORD'
          )]) {
              withEnv([
                "CODING_ARTIFACTS_USERNAME=${CODING_ARTIFACTS_USERNAME}",
                "CODING_ARTIFACTS_PASSWORD=${CODING_ARTIFACTS_PASSWORD}"
              ]) {
                  sh 'mvn clean install'
                  sh 'mvn deploy -s ./settings.xml'
              }
          }
      }
    }
  }
}
