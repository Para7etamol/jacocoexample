SEARCH_LOCATION=/drives/c/Users/sarath.kumar/jacoco_report
JACOCO_CLI_HOME=/drives/c/Users/sarath.kumar/java/lib/jacoco-0.8.1-20180212.125243-11/lib
CLASSES_FOLDER=classes
SOURCES_FOLDER=sources
EXEC_DATA_FOLDER=exec_data
REPORT_FOLDER=site
EXEC_FILES_SEPARATOR=" "
java -jar $(cygpath -aw $JACOCO_CLI_HOME/jacococli.jar) dump --address localhost --port 6301 --destfile $(cygpath -aw $SEARCH_LOCATION/$EXEC_DATA_FOLDER/jacoco_weblogic.exec)
for entry in $SEARCH_LOCATION/$EXEC_DATA_FOLDER/*.exec
do	
  echo $entry
  execFileList+=$(cygpath -aw $entry)$EXEC_FILES_SEPARATOR
done
rm -rf $SEARCH_LOCATION/$REPORT_FOLDER
java -jar $(cygpath -aw $JACOCO_CLI_HOME/jacococli.jar) \
report $execFileList --classfiles $(cygpath -aw $SEARCH_LOCATION/$CLASSES_FOLDER) \
--html $(cygpath -aw $SEARCH_LOCATION/$REPORT_FOLDER) --sourcefiles $(cygpath -aw $SEARCH_LOCATION/SOURCES_FOLDER)
