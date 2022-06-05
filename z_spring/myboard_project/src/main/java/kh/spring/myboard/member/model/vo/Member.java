package kh.spring.myboard.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Member {
	
//	ID VARCHAR2(15 BYTE),
//	PASSWD VARCHAR2(15 BYTE) NOT NULL,
//	NAME VARCHAR2(20 BYTE) NOT NULL,
//	EMAIL VARCHAR2(30 BYTE),
//	GENDER CHAR(1 BYTE) CHECK (GENDER IN ('M', 'F')),
//	AGE NUMBER,
//	PHONE CHAR(13 BYTE),
//	ADDRESS VARCHAR2(50 BYTE),
//	ENROLL_DATE DATE DEFAULT SYSDATE,
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String gender; // char형이지만 강사님께서 String형으로 하라고 함(charAt(0)이런식으로 넣어야 해서)
	private String age; // int형이지만 강사님께서 String형으로 한다고 함
	private String phone; // char형이지만 강사님께서 String형으로 하라고 함(charAt(0)이런식으로 넣어야 해서)
	private String address;
	private Date enroll_date;
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + ", phone=" + phone + ", address=" + address + ", enroll_date=" + enroll_date + "]";
	}
	
	// lombok사용해서 getter,setter 안써도 됨. toString도 안써도 되지만 씀
	
}
