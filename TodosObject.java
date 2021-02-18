package com.example.mockito;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TodosObject {

@JsonProperty("userId")
private Integer userId;
@JsonProperty("id")
private Integer id;
@JsonProperty("title")
private String title;
@JsonProperty("completed")
private Boolean completed;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("userId")
public Integer getUserId() {
return userId;
}

@JsonProperty("userId")
public void setUserId(Integer userId) {
this.userId = userId;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("completed")
public Boolean getCompleted() {
return completed;
}

@JsonProperty("completed")
public void setCompleted(Boolean completed) {
this.completed = completed;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}