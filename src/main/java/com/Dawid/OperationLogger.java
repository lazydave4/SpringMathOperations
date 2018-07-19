package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class OperationLogger {

    @Autowired
    JdbcTemplate jdbcTemplate;


  public void log(OperationData operationData){
      jdbcTemplate.execute("INSERT INTO Operation_Data(operation,first,second) VALUES ('"+operationData.getOperation()+"','"+operationData.getFirst()+"','"+operationData.getSecond()+"')");

 }

 @PostConstruct
  private void createTable(){
   jdbcTemplate.execute("CREATE TABLE Operation_Data(operation VARCHAR(255),first Int,second Int)");

}
}
