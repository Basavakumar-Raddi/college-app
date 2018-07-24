## To update the database with new change log
mvn liquibase:update

## To rollback to a specific version tag
mvn liquibase:rollback -Dliquibase.rollbackTag=<<version tag>>

## To generate update script from the last db state. SQL will be generated at <path>\db\target\liquibase\migrate.sql
mvn liquibase:updateSQL

## To generate rollback script to a specific version tag. SQL will be generated at <path>\db\target\liquibase\migrate.sql
mvn liquibase:rollbackSQL -Dliquibase.rollbackTag=<<version tag>>

## update to run when deployed on unix
liquibase
    --driver=com.mysql.jdbc.Driver
    --classpath=<<mysql-location>>/mysql-connector-java-<<version>>.jar
    --changeLogFile=<<chnage-log-filelocation>>/databaseChangeLog.sql
    --url="jdbc:mysql://localhost/liquibase"
    --username=root
    --password=""
        update

## rollback to run when deployed on unix
liquibase
    --driver=com.mysql.jdbc.Driver
    --classpath=<<mysql-location>>/mysql-connector-java-<<version>>.jar
    --changeLogFile=<<chnage-log-filelocation>>/changelog.xml
    --url="jdbc:mysql://localhost/liquibase"
    --username=root
    --password=""
        rollback tag

