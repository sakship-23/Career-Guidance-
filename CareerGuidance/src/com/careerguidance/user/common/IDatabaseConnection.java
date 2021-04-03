package com.careerguidance.user.common;

import java.sql.Connection;

@FunctionalInterface
public interface IDatabaseConnection {
	public Connection getConnection();
}
