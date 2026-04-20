package com.kh.delivery.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		String resource = "mybatis-config.xml";
		InputStream stream = null;
		try {
			stream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(stream).openSession();
	}

}
