/*
 * This file is generated by jOOQ.
 */
package org.poem.code.entities.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.poem.code.entities.tables.DsgGatherDb;


/**
 * 采集到库信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DsgGatherDbRecord extends UpdatableRecordImpl<DsgGatherDbRecord> implements Record6<String, String, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = 1189173100;

    /**
     * Setter for <code>kylo.dsg_gather_db.id</code>. id
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.id</code>. id
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>kylo.dsg_gather_db.gather_id</code>. 元数据采集信息
     */
    public void setGatherId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.gather_id</code>. 元数据采集信息
     */
    public String getGatherId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>kylo.dsg_gather_db.schema</code>. schema
     */
    public void setSchema(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.schema</code>. schema
     */
    public String getSchema() {
        return (String) get(2);
    }

    /**
     * Setter for <code>kylo.dsg_gather_db.description</code>. 描述
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.description</code>. 描述
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>kylo.dsg_gather_db.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>kylo.dsg_gather_db.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>kylo.dsg_gather_db.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return DsgGatherDb.DSG_GATHER_DB.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return DsgGatherDb.DSG_GATHER_DB.GATHER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return DsgGatherDb.DSG_GATHER_DB.SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return DsgGatherDb.DSG_GATHER_DB.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return DsgGatherDb.DSG_GATHER_DB.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return DsgGatherDb.DSG_GATHER_DB.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getGatherId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getGatherId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value2(String value) {
        setGatherId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value3(String value) {
        setSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value5(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord value6(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DsgGatherDbRecord values(String value1, String value2, String value3, String value4, Timestamp value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DsgGatherDbRecord
     */
    public DsgGatherDbRecord() {
        super(DsgGatherDb.DSG_GATHER_DB);
    }

    /**
     * Create a detached, initialised DsgGatherDbRecord
     */
    public DsgGatherDbRecord(String id, String gatherId, String schema, String description, Timestamp createTime, Timestamp updateTime) {
        super(DsgGatherDb.DSG_GATHER_DB);

        set(0, id);
        set(1, gatherId);
        set(2, schema);
        set(3, description);
        set(4, createTime);
        set(5, updateTime);
    }
}