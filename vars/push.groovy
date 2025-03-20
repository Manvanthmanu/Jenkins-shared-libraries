def call(String ID, String imageName, String ImageVersion ){
  withCredentials([usernamePassword('credentialsId':"${ID}", passwordVariable:"dockerhubPass", usernameVariable:"dockerhubUser")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerhubPass}"
                    sh "docker image tag ${ImageName}:${ImageVersion} ${env.dockerHubUser}/${ImageName}:${ImageVersion}"
                    sh "docker push ${env.dockerHubUser}/${ImageName}:${ImageVersion}"
}
