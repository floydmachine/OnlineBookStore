package com.ars.pro1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
@Entity
@Table(name = "User")

public class User
{
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Size(min=4, max=20,message = "Please enter between 4 to 20 characters")
  @NotEmpty(message = "Please enter your firstname.")
  private String firstname;
  
  @Size(min=4, max=20,message = "Please enter between 4 to 20 characters")
  @NotEmpty(message = "Please enter your lastname.")
  private String lastname;
 
  @Email(message = "Please enter your email address.")
  @NotEmpty(message = "Please enter your email address.")
  private String email;
  
  @Size(min = 4, max = 20, message = "Your password must between 4 and 20 characters")
  private String password;
  
@Range(min = 15, max = 80, message = "Your age must be between 15 and 80 characters")
private int age;

@NotNull(message="Please choose your gender ")
  private String gender;
  
  @NotNull(message="Please enter your phone number ")
  private long phoneno;
 

  public int getId()
  {
    return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public String getFirstname()
  {
    return firstname;
  }
  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }
  public String getLastname()
  {
    return lastname;
  }
  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }
  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public int getAge()
  {
    return age;
  }
  public void setAge(int age)
  {
    this.age = age;
  }
  public String getGender()
  {
    return gender;
  }
  public void setGender(String gender)
  {
    this.gender = gender;
  }

  
  public long getPhoneno()
  {
    return phoneno;
  }
  public void setPhoneno(long phoneno)
  {
    this.phoneno = phoneno;
  }

  
}
