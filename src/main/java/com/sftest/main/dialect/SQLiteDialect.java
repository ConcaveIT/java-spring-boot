package com.sftest.main.dialect;

import org.hibernate.dialect.Dialect;

//import org.hibernate.dialect.function.SQLFunctionTemplate;
//import org.hibernate.dialect.function.StandardSQLFunction;
//import org.hibernate.dialect.function.VarArgsSQLFunction;
//import org.hibernate.type.StringType;

import java.sql.Types;

public class SQLiteDialect extends Dialect{
	 	public SQLiteDialect() {
	    }

	    public boolean supportsIdentityColumns() {
	        return true;
	    }

	    public boolean hasDataTypeInIdentityColumn() {
	        return false;
	    }

	    public String getIdentityColumnString() {
	        return "integer";
	    }

	    public String getIdentitySelectString() {
	        return "select last_insert_rowid()";
	    }

	    public boolean supportsLimit() {
	        return true;
	    }

	    protected String getLimitString(String query, boolean hasOffset) {
	        return new StringBuffer(query.length() + 20).append(query).append(hasOffset ? " limit ? offset ?" : " limit ?")
	                .toString();
	    }

	    public boolean supportsTemporaryTables() {
	        return true;
	    }

	    public String getCreateTemporaryTableString() {
	        return "create temporary table if not exists";
	    }

	    public boolean dropTemporaryTableAfterUse() {
	        return false;
	    }

	    public boolean supportsCurrentTimestampSelection() {
	        return true;
	    }

	    public boolean isCurrentTimestampSelectStringCallable() {
	        return false;
	    }

	    public String getCurrentTimestampSelectString() {
	        return "select current_timestamp";
	    }

	    public boolean supportsUnionAll() {
	        return true;
	    }

	    public boolean hasAlterTable() {
	        return false;
	    }

	    public boolean dropConstraints() {
	        return false;
	    }

	    public String getAddColumnString() {
	        return "add column";
	    }

	    public String getForUpdateString() {
	        return "";
	    }

	    public boolean supportsOuterJoinForUpdate() {
	        return false;
	    }

	    public String getDropForeignKeyString() {
	        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
	    }

	    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
	                                                   String[] primaryKey, boolean referencesPrimaryKey) {
	        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
	    }

	    public String getAddPrimaryKeyConstraintString(String constraintName) {
	        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
	    }

	    public boolean supportsIfExistsBeforeTableName() {
	        return true;
	    }

	    public boolean supportsCascadeDelete() {
	        return false;
	    }
}
