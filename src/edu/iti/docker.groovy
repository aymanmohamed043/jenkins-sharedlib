package edu.iti

def build(imgName, imgTag){
    sh "docker build -t ${imgName}:${imgTag} ."}

def login(userName, password){
    sh "docker login -u ${userName} -p ${password}"}

def push(imgName, imgTag){
    sh "docker push ${imgName}:${imgTag}"}

def deploy(imageName,  imgTag) {
    sh "docker run -d --name ${imageName}-container -p 8080:8080 ${imageName}:${imgTag}"
    }

def deploy(String imageName, String imgTag) {
    script.echo "Deploying container ${imageName}:${imgTag}..."

    def safeName = imageName.replaceAll('/', '-')

    script.sh """
        docker stop ${safeName}-container || true
        docker rm ${safeName}-container || true
        docker run -d --name ${safeName}-container -p 8080:8080 ${imageName}:${tag}
    """

    script.echo "Deployment completed!"
}
