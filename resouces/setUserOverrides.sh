# @Sarath: maybe you have to drop -Djava.security.egd=file:/dev/./urandom
export EXTRA_JAVA_PROPERTIES="-Djava.security.egd=file:/dev/./urandom -javaagent:lib/jacocoagent.jar=output=tcpserver,address=*,port=6301,includes=com.example.jacoco.*,jmx=true"
export debugFlag="true"
export CLASS_CACHE="true"
