package com.sigma.big.tools;

import com.esri.core.geometry.*;
import com.sigma.big.utils.WktWkbUtil;
import oracle.sql.CLOB;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.postgresql.util.PGobject;

import java.sql.*;

/**
 * User: schullto
 * Date: 24/12/2014
 * Time: 7:14 PM
 */
public class WktStGeometryType extends AbstractSingleColumnStandardBasicType<Geometry> {

    public WktStGeometryType() {
        super(WktTypeSqlTypeDescriptor.INSTANCE, WktTypeJavaTypeDescriptior.INSTANCE);
    }

    @Override
    public String getName() {
        return "st_geometry.WKT";
    }

    public static class WktTypeJavaTypeDescriptior extends AbstractTypeDescriptor<Geometry> {
        public static final WktTypeJavaTypeDescriptior INSTANCE = new WktTypeJavaTypeDescriptior(Geometry.class);

        protected WktTypeJavaTypeDescriptior(Class<Geometry> type) {
            super(type);
        }

        @Override
        public String toString(Geometry geometry) {
            return WktWkbUtil.toWkt(geometry);
        }

        @Override
        public Geometry fromString(String string) {
            return WktWkbUtil.fromWkt(string);
        }

        @Override
        public <X> X unwrap(Geometry value, Class<X> type, WrapperOptions options) {
            if (value == null) {
                return null;
            }

            if (Geometry.class.isAssignableFrom(type)) {
                return (X) value;
            }

            if (String.class.isAssignableFrom(type)) {
                return (X) toString(value);
            }
            throw unknownUnwrap(type);
        }

        @Override
        public <X> Geometry wrap(X value, WrapperOptions options) {
            if (value == null) {
                return null;
            }
            if (Geometry.class.isInstance(value)) {
                return (Geometry) value;
            }
            if (String.class.isInstance(value)) {
                return fromString((String) value);
            }
            throw unknownWrap(value.getClass());
        }
    }

    public static class WktTypeSqlTypeDescriptor implements SqlTypeDescriptor {
        public static final WktTypeSqlTypeDescriptor INSTANCE = new WktTypeSqlTypeDescriptor();

        @Override
        public int getSqlType() {
            return Types.OTHER;
        }

        @Override
        public boolean canBeRemapped() {
            return true;
        }

        @Override
        public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
            return new ValueBinder<X>() {
                @Override
                public void bind(PreparedStatement st, X value, int index, WrapperOptions options) throws SQLException {
                    if (value == null) {
                        //postgres st.setNull(index, Types.STRUCT);
                        st.setNull(index, Types.CLOB);
                    } else {
                        if (value instanceof Geometry) {
                            Geometry geom = (Geometry) value;
                            st.setObject(index, WktWkbUtil.toWkt(geom));
                        }
                    }
                }

                @Override
                public void bind(CallableStatement cs, X x, String string, WrapperOptions wo) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }

        @Override
        public <X> ValueExtractor<X> getExtractor(final JavaTypeDescriptor<X> javaTypeDescriptor) {
            return new BasicExtractor<X>(javaTypeDescriptor, this) {
                @Override
                protected X doExtract(ResultSet rs, String name, WrapperOptions options) throws SQLException {
                    return getJavaDescriptor().wrap(toJTS(rs.getObject(name)), options);
                }

                @Override
                protected X doExtract(CallableStatement statement, int index, WrapperOptions options) throws SQLException {
                    return getJavaDescriptor().wrap(toJTS(statement.getObject(index)), options);
                }

                @Override
                protected X doExtract(CallableStatement statement, String name, WrapperOptions options) throws SQLException {
                    return getJavaDescriptor().wrap(toJTS(statement.getObject(name)), options);
                }

                public Geometry toJTS(Object object) {
                    if (object == null) {
                        return null;
                    }
                    if (object instanceof byte[]) {
                        return WktWkbUtil.fromWkb((byte[]) object);
                    }
                    if (object instanceof PGobject) {
                        PGobject pGobject = (PGobject) object;
                        String wkt = pGobject.getValue();
                        return WktWkbUtil.fromWkt(wkt);
                    } else  if (object instanceof CLOB) {
                        CLOB clob = (CLOB) object;
                        String wkt = null;
                        try {
                            wkt = clob.getSubString(1, (int) clob.length());
                            return WktWkbUtil.fromWkt(wkt);
                        } catch (SQLException e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("Can't convert object of type " + object.getClass().getCanonicalName());
                        }
                    } else {
                        throw new IllegalArgumentException("Can't convert object of type " + object.getClass().getCanonicalName());
                    }
                }
            };
        }
    }

}