package practice.orm.hib.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="EMPLOYEE", uniqueConstraints= {@UniqueConstraint(columnNames= {"ID"})} )
public class Employee {
	@javax.persistence.Id
	
	@SequenceGenerator(name="EMPLOYEE_SEQ_GEN", sequenceName="EMPLOYEE_SEQ",initialValue=2, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ_GEN")
	@Column(name="ID")
	private Integer Id;
	
	@Column
	private String name;
	
	@Column
	private String role;
	
	@Column(name="INSERT_TIME")
	private Date insertTime;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
}
