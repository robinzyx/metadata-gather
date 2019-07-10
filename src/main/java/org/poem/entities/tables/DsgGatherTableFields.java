/*
 * This file is generated by jOOQ.
 */
package org.poem.entities.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.poem.entities.Indexes;
import org.poem.entities.Keys;
import org.poem.entities.Kylo;
import org.poem.entities.tables.records.DsgGatherTableFieldsRecord;


/**
 * 采集表字端信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DsgGatherTableFields extends TableImpl<DsgGatherTableFieldsRecord> {

    private static final long serialVersionUID = -1597933465;

    /**
     * The reference instance of <code>kylo.dsg_gather_table_fields</code>
     */
    public static final DsgGatherTableFields DSG_GATHER_TABLE_FIELDS = new DsgGatherTableFields();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DsgGatherTableFieldsRecord> getRecordType() {
        return DsgGatherTableFieldsRecord.class;
    }

    /**
     * The column <code>kylo.dsg_gather_table_fields.id</code>. id
     */
    public final TableField<DsgGatherTableFieldsRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "id");

    /**
     * The column <code>kylo.dsg_gather_table_fields.gather_table_id</code>. 表
     */
    public final TableField<DsgGatherTableFieldsRecord, String> GATHER_TABLE_ID = createField("gather_table_id", org.jooq.impl.SQLDataType.VARCHAR(500), this, "表");

    /**
     * The column <code>kylo.dsg_gather_table_fields.field_name</code>. 字段
     */
    public final TableField<DsgGatherTableFieldsRecord, String> FIELD_NAME = createField("field_name", org.jooq.impl.SQLDataType.VARCHAR(225), this, "字段");

    /**
     * The column <code>kylo.dsg_gather_table_fields.data_type</code>. 数据类型
     */
    public final TableField<DsgGatherTableFieldsRecord, String> DATA_TYPE = createField("data_type", org.jooq.impl.SQLDataType.VARCHAR(225), this, "数据类型");

    /**
     * The column <code>kylo.dsg_gather_table_fields.column_name</code>. 描述
     */
    public final TableField<DsgGatherTableFieldsRecord, String> COLUMN_NAME = createField("column_name", org.jooq.impl.SQLDataType.VARCHAR(225), this, "描述");

    /**
     * The column <code>kylo.dsg_gather_table_fields.default_value</code>. 默认值
     */
    public final TableField<DsgGatherTableFieldsRecord, String> DEFAULT_VALUE = createField("default_value", org.jooq.impl.SQLDataType.VARCHAR(225), this, "默认值");

    /**
     * The column <code>kylo.dsg_gather_table_fields.data_type_length</code>. 数据长度
     */
    public final TableField<DsgGatherTableFieldsRecord, String> DATA_TYPE_LENGTH = createField("data_type_length", org.jooq.impl.SQLDataType.VARCHAR(225), this, "数据长度");

    /**
     * The column <code>kylo.dsg_gather_table_fields.create_time</code>.
     */
    public final TableField<DsgGatherTableFieldsRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>kylo.dsg_gather_table_fields.update_time</code>.
     */
    public final TableField<DsgGatherTableFieldsRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>kylo.dsg_gather_table_fields</code> table reference
     */
    public DsgGatherTableFields() {
        this(DSL.name("dsg_gather_table_fields"), null);
    }

    /**
     * Create an aliased <code>kylo.dsg_gather_table_fields</code> table reference
     */
    public DsgGatherTableFields(String alias) {
        this(DSL.name(alias), DSG_GATHER_TABLE_FIELDS);
    }

    /**
     * Create an aliased <code>kylo.dsg_gather_table_fields</code> table reference
     */
    public DsgGatherTableFields(Name alias) {
        this(alias, DSG_GATHER_TABLE_FIELDS);
    }

    private DsgGatherTableFields(Name alias, Table<DsgGatherTableFieldsRecord> aliased) {
        this(alias, aliased, null);
    }

    private DsgGatherTableFields(Name alias, Table<DsgGatherTableFieldsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("采集表字端信息"));
    }

    public <O extends Record> DsgGatherTableFields(Table<O> child, ForeignKey<O, DsgGatherTableFieldsRecord> key) {
        super(child, key, DSG_GATHER_TABLE_FIELDS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Kylo.KYLO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DSG_GATHER_TABLE_FIELDS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DsgGatherTableFieldsRecord> getPrimaryKey() {
        return Keys.KEY_DSG_GATHER_TABLE_FIELDS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DsgGatherTableFieldsRecord>> getKeys() {
        return Arrays.<UniqueKey<DsgGatherTableFieldsRecord>>asList(Keys.KEY_DSG_GATHER_TABLE_FIELDS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherTableFields as(String alias) {
        return new DsgGatherTableFields(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherTableFields as(Name alias) {
        return new DsgGatherTableFields(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DsgGatherTableFields rename(String name) {
        return new DsgGatherTableFields(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DsgGatherTableFields rename(Name name) {
        return new DsgGatherTableFields(name, null);
    }
}
