package edu.iti

def build(imgName, imgTag){
    sh "docker build -t ${imgName}:${imgTag} ."}

def login(userName, password){
    sh "docker login -u ${userName} -p ${password}"}

def push(imgName, imgTag){
    sh "docker push ${imgName}:${imgTag}"}

