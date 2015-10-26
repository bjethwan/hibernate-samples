package com.bjethwan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Map;

import org.dom4j.Node;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.metamodel.relational.Size;
import org.hibernate.type.BasicType;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.CurrencyType;
import org.hibernate.type.ForeignKeyDirection;
import org.hibernate.type.Type;

public class MoneyType implements BasicType {
    public String[] getRegistrationKeys() {
        return new String[] { Money.class.getName() };
    }

	public int[] sqlTypes(Mapping mapping) {
	    // We will simply use delegation to the standard basic types for BigDecimal and Currency for many of the
	    // Type methods...
	    return new int[] {
	             BigDecimalType.INSTANCE.sqlType(),
	             CurrencyType.INSTANCE.sqlType(),
	    };
	    // we could also have honored any registry overrides via...
	    //return new int[] {
	    //         mappings.getTypeResolver().basic( BigDecimal.class.getName() ).sqlTypes( mappings )[0],
	    //         mappings.getTypeResolver().basic( Currency.class.getName() ).sqlTypes( mappings )[0]
	    //};
	}

    public Class getReturnedClass() {
        return Money.class;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws SQLException {
        assert names.length == 2;
        BigDecimal amount = BigDecimalType.INSTANCE.get( names[0] ); // already handles null check
        Currency currency = CurrencyType.INSTANCE.get( names[1] ); // already handles null check
        return amount == null && currency == null
                ? null
                : new Money( amount, currency );
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, boolean[] settable, SessionImplementor session)
            throws SQLException {
        if ( value == null ) {
            BigDecimalType.INSTANCE.set( st, null, index );
            CurrencyType.INSTANCE.set( st, null, index+1 );
        }
        else {
            final Money money = (Money) value;
            BigDecimalType.INSTANCE.set( st, money.getAmount(), index );
            CurrencyType.INSTANCE.set( st, money.getCurrency(), index+1 );
        }
    }

	@Override
	public Object assemble(Serializable arg0, SessionImplementor arg1,
			Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beforeAssemble(Serializable arg0, SessionImplementor arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object deepCopy(Object arg0, SessionFactoryImplementor arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size[] defaultSizes(Mapping arg0) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size[] dictatedSizes(Mapping arg0) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable disassemble(Object arg0, SessionImplementor arg1,
			Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object fromXMLNode(Node arg0, Mapping arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnSpan(Mapping arg0) throws MappingException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHashCode(Object arg0, SessionFactoryImplementor arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getSemiResolvedType(SessionFactoryImplementor arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object hydrate(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnyType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAssociationType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCollectionType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComponentType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirty(Object arg0, Object arg1, SessionImplementor arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirty(Object arg0, Object arg1, boolean[] arg2,
			SessionImplementor arg3) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEntityType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(Object arg0, Object arg1,
			SessionFactoryImplementor arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified(Object arg0, Object arg1, boolean[] arg2,
			SessionImplementor arg3) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSame(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isXMLElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object replace(Object arg0, Object arg1, SessionImplementor arg2,
			Object arg3, Map arg4) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object arg0, Object arg1, SessionImplementor arg2,
			Object arg3, Map arg4, ForeignKeyDirection arg5)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object resolve(Object arg0, SessionImplementor arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object semiResolve(Object arg0, SessionImplementor arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setToXMLNode(Node arg0, Object arg1,
			SessionFactoryImplementor arg2) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean[] toColumnNullness(Object arg0, Mapping arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toLoggableString(Object arg0, SessionFactoryImplementor arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

    ...
}