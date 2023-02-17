package dto.post;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "login",
        "password",
        "screenName",
        "gender",
        "age",
        "role"
})
@Generated("jsonschema2pojo")
public class UserCreation {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private Object password;
    @JsonProperty("screenName")
    private Object screenName;
    @JsonProperty("gender")
    private Object gender;
    @JsonProperty("age")
    private Object age;
    @JsonProperty("role")
    private Object role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
    }

    @JsonProperty("screenName")
    public Object getScreenName() {
        return screenName;
    }

    @JsonProperty("screenName")
    public void setScreenName(Object screenName) {
        this.screenName = screenName;
    }

    @JsonProperty("gender")
    public Object getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Object gender) {
        this.gender = gender;
    }

    @JsonProperty("age")
    public Object getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Object age) {
        this.age = age;
    }

    @JsonProperty("role")
    public Object getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(Object role) {
        this.role = role;
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