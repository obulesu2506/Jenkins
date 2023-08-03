def gitDownload(repo)
{
  git "https://github.com/intelliqittrainings/${repo}.git"
}
def mavenBuild()
{
  sh 'mvn package'
}
def tomcatDeploy(jobname,ipaddress,contextpath)
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat9/webapps/${contextpath}.war"
}  
def runSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
