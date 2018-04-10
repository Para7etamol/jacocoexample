JACOCO_RESULTS=/tmp/jacoco
CLASSES_FOLDER="${JACOCO_RESULTS}/classes"
SOURCES_FOLDER="${JACOCO_RESULTS}/sources"
EXEC_DATA_FOLDER="${JACOCO_RESULTS}/exec_data"
REPORT_FOLDER="${JACOCO_RESULTS}/site"

JACOCO_CLI_HOME=../lib
EXEC_FILES_SEPARATOR=" "

java -jar $JACOCO_CLI_HOME/jacococli.jar dump --address localhost --port 6301 --destfile $EXEC_DATA_FOLDER/jacoco_weblogic.exec
for entry in $EXEC_DATA_FOLDER/*.exec
do	
  echo $entry
  execFileList+=$entry$EXEC_FILES_SEPARATOR
done
rm -rf $REPORT_FOLDER
java -jar $JACOCO_CLI_HOME/jacococli.jar \
report $execFileList --classfiles $CLASSES_FOLDER \
--html $REPORT_FOLDER --sourcefiles $SOURCES_FOLDER
