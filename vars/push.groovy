def call(String ID, String imageName, String imageVersion ){
  withCredentials([usernamePassword('credentialsId':"${ID}", passwordVariable:"dockerhubPass", usernameVariable:"dockerhubUser")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerhubPass}"
                    sh "docker image tag ${imageName}:${imageVersion} ${env.dockerHubUser}/${imageName}:${imageVersion}"
                    sh "docker push ${env.dockerHubUser}/${imageName}:${imageVersion}"
  }
}
