package org.poem.service;

import com.google.common.collect.Lists;
import org.jooq.Condition;
import org.jooq.SortField;
import org.poem.api.MetadataService;
import org.poem.api.vo.*;
import org.poem.dao.gather.GatherInfoDao;
import org.poem.dao.info.DsgGatherDBDao;
import org.poem.dao.info.DsgGatherTableDao;
import org.poem.dao.info.DsgGatherTableFieldsDao;
import org.poem.entities.tables.DsgGatherDb;
import org.poem.entities.tables.DsgGatherInfo;
import org.poem.entities.tables.DsgGatherTable;
import org.poem.entities.tables.DsgGatherTableFields;
import org.poem.entities.tables.records.DsgGatherDbRecord;
import org.poem.entities.tables.records.DsgGatherInfoRecord;
import org.poem.entities.tables.records.DsgGatherTableFieldsRecord;
import org.poem.entities.tables.records.DsgGatherTableRecord;
import org.poem.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Service
public class MetadataServiceImpl implements MetadataService {

    private static final Logger logger = LoggerFactory.getLogger( MetadataServiceImpl.class );

    @Autowired
    private GatherInfoDao gatherInfoDao;

    @Autowired
    private DsgGatherDBDao dsgGatherDBDao;

    @Autowired
    private DsgGatherTableDao dsgGatherTableDao;

    @Autowired
    private DsgGatherTableFieldsDao dsgGatherTableFieldsDao;

    /**
     * @param gatherVO
     */
    @Override
    public void savgeGather(GatherVO gatherVO) {
        List<Condition> conditions = Lists.newArrayList();
        conditions.add( DsgGatherInfo.DSG_GATHER_INFO.IP.eq( gatherVO.getIp() ) );
        conditions.add( DsgGatherInfo.DSG_GATHER_INFO.PORT.eq( gatherVO.getPort() ) );
        conditions.add( DsgGatherInfo.DSG_GATHER_INFO.DELETE.eq( (byte) 0 ) );
        List<SortField<?>> sortFields = Lists.newArrayList();
        sortFields.add( DsgGatherInfo.DSG_GATHER_INFO.CREATE_TIME.desc() );
        List<DsgGatherInfoRecord> gatherInfos = this.gatherInfoDao.findByConditions( conditions, sortFields );
        if (!CollectionUtils.isEmpty( gatherInfos )) {
            throw new IllegalArgumentException( "this record DsgGatherInfoRecord(" + gatherVO.getIp() + " / " + gatherVO.getPort() + ") is  exist . !!!!!!" );
        }
        DsgGatherInfoRecord infoRecord = new DsgGatherInfoRecord();
        infoRecord.setId( SnowFlake.genId() );
        infoRecord.setName( gatherVO.getName() );
        infoRecord.setIp( gatherVO.getIp() );
        infoRecord.setPort( gatherVO.getPort() );
        infoRecord.setDelete( (byte) 0 );
        infoRecord.setType( gatherVO.getType() );
        infoRecord.setPassword( gatherVO.getPassword() );
        infoRecord.setUser( gatherVO.getUserName() );
        infoRecord.setCreateTime( new Timestamp( System.currentTimeMillis() ) );
        infoRecord.setUpdateTime( new Timestamp( System.currentTimeMillis() ) );
        this.gatherInfoDao.insert( infoRecord );
    }

    /**
     * @return
     */
    @Override
    public List<GatherVO> getAllGather() {
        List<Condition> conditions = Lists.newArrayList();
        conditions.add( DsgGatherInfo.DSG_GATHER_INFO.DELETE.eq( (byte) 0 ) );
        List<SortField<?>> sortFields = Lists.newArrayList();
        sortFields.add( DsgGatherInfo.DSG_GATHER_INFO.CREATE_TIME.desc() );
        List<DsgGatherInfoRecord> gatherInfos = this.gatherInfoDao.findByConditions( conditions, sortFields );
        return gatherInfos.stream().map(
                o -> {
                    GatherVO gatherVO = new GatherVO();
                    gatherVO.setId( o.getId() );
                    gatherVO.setGatherId( o.getId() );
                    gatherVO.setIp( o.getIp() );
                    gatherVO.setPort( o.getPort() );
                    gatherVO.setType( o.getType() );
                    gatherVO.setPassword( o.getPassword() );
                    gatherVO.setUserName( o.getUser() );
                    return gatherVO;
                }
        ).collect( Collectors.toList() );
    }

    /**
     * @param gatherId
     * @return
     */
    @Override
    public GatherVO getGatherVOById(String gatherId) {
        DsgGatherInfoRecord o = this.gatherInfoDao.findById( gatherId );
        GatherVO gatherVO = new GatherVO();
        gatherVO.setId( o.getId() );
        gatherVO.setGatherId( gatherId );
        gatherVO.setIp( o.getIp() );
        gatherVO.setPort( o.getPort() );
        gatherVO.setType( o.getType() );
        gatherVO.setPassword( o.getPassword() );
        gatherVO.setUserName( o.getUser() );
        return gatherVO;
    }

    /**
     * @param dbVOS
     * @param gatherInfoId
     */
    @Override
    public List<DsgGatherDbRecord> saveDB(List<DbVO> dbVOS, String gatherInfoId) {
        DsgGatherInfoRecord i = this.gatherInfoDao.findById( gatherInfoId );
        List<DsgGatherDbRecord> gatherDbRecords = dbVOS.stream().map(
                o -> {
                    DsgGatherDbRecord dsgGatherDbRecord = new DsgGatherDbRecord();
                    dsgGatherDbRecord.setId( SnowFlake.genId() );
                    dsgGatherDbRecord.setCreateTime( new Timestamp( System.currentTimeMillis() ) );
                    dsgGatherDbRecord.setDataType( i.getType() );
                    dsgGatherDbRecord.setSchema( o.getName() );
                    dsgGatherDbRecord.setGatherId( gatherInfoId );
                    dsgGatherDbRecord.setDescription( o.getName() );
                    dsgGatherDbRecord.setUpdateTime( new Timestamp( System.currentTimeMillis() ) );
                    return dsgGatherDbRecord;
                }
        ).collect( Collectors.toList() );
        this.dsgGatherDBDao.insert( gatherDbRecords );
        return gatherDbRecords;
    }

    /**
     * @param gatherId
     * @return
     */
    @Override
    public List<DbVO> getAllDB(String gatherId) {
        List<DsgGatherDbRecord> dbRecords = dsgGatherDBDao.findByCondition( DsgGatherDb.DSG_GATHER_DB.GATHER_ID.eq( gatherId ) );
        return dbRecords.stream()
                .map(
                        o -> {
                            DbVO dbVO = new DbVO();
                            dbVO.setName( o.getSchema() );
                            dbVO.setGatherId( gatherId );
                            dbVO.setId( o.getId() );
                            return dbVO;
                        }
                ).collect( Collectors.toList() );
    }

    /**
     * @param dbId
     */
    private void deleteTable(String dbId) {
        List<DsgGatherTableRecord> records = this.dsgGatherTableDao.findByCondition( DsgGatherTable.DSG_GATHER_TABLE.GATHER_DB_ID.eq( dbId ) );
        for (DsgGatherTableRecord record : records) {
            deleteTableField( record.getId() );
            this.dsgGatherTableDao.delete(record  );
        }
    }

    /**
     * @param tableId
     */
    private void deleteTableField(String tableId) {
        List<Condition> conditions = Lists.newArrayList();
        conditions.add( DsgGatherTableFields.DSG_GATHER_TABLE_FIELDS.GATHER_TABLE_ID.eq( tableId ) );
        this.dsgGatherTableFieldsDao.deleteByConditions( conditions );
    }

    /**
     * @param tableVOS
     * @param dbId
     */
    @Override
    public List<DsgGatherTableRecord> saveTable(List<TableVO> tableVOS, String dbId) {
        List<DsgGatherTableRecord> dsgGatherTableRecords = tableVOS.stream().map(
                o -> {
                    DsgGatherTableRecord tableRecord = new DsgGatherTableRecord();
                    tableRecord.setId( SnowFlake.genId() );
                    tableRecord.setCreateTime( new Timestamp( System.currentTimeMillis() ) );
                    tableRecord.setUpdateTime( new Timestamp( System.currentTimeMillis() ) );
                    tableRecord.setGatherDbId( dbId );
                    tableRecord.setName( o.getName() );
                    tableRecord.setDescription( o.getTable() );
                    tableRecord.setTable_( o.getTable() );
                    return tableRecord;
                }
        ).collect( Collectors.toList() );
        this.dsgGatherTableDao.insert(
                dsgGatherTableRecords
        );
        return dsgGatherTableRecords;
    }

    /**
     * @param db
     * @return
     */
    @Override
    public List<TableVO> getTable(String db) {
        List<DsgGatherTableRecord> records = this.dsgGatherTableDao.findByCondition( DsgGatherTable.DSG_GATHER_TABLE.GATHER_DB_ID.eq( db ) );
        return records.stream().map(
                o -> {
                    TableVO tableVO = new TableVO();
                    tableVO.setTable( o.getTable_() );
                    tableVO.setName( o.getName() );
                    tableVO.setDbId( db );
                    tableVO.setId( o.getId() );
                    return tableVO;
                }
        ).collect( Collectors.toList() );
    }

    /**
     * @param fieldsVOS
     * @param tableId
     */
    @Override
    public List<DsgGatherTableFieldsRecord> saveTableFields(List<TableFieldsVO> fieldsVOS, String tableId) {
        List<DsgGatherTableFieldsRecord> dsgGatherTableFieldsRecords = fieldsVOS.stream().map(
                o -> {
                    DsgGatherTableFieldsRecord fieldsRecord = new DsgGatherTableFieldsRecord();
                    fieldsRecord.setId( SnowFlake.genId() );
                    fieldsRecord.setGatherTableId( tableId );
                    fieldsRecord.setDataType( o.getDataType() );
                    fieldsRecord.setDescription( o.getDescription() );
                    fieldsRecord.setDefaultValue( o.getDefaultValue() );
                    fieldsRecord.setField( o.getField() );
                    fieldsRecord.setCreateTime( new Timestamp( System.currentTimeMillis() ) );
                    fieldsRecord.setUpdateTime( new Timestamp( System.currentTimeMillis() ) );
                    return fieldsRecord;
                }
        ).collect( Collectors.toList() );
        this.dsgGatherTableFieldsDao.insert(
                dsgGatherTableFieldsRecords
        );
        return dsgGatherTableFieldsRecords;
    }


    /**
     * @param gatherId
     */
    @Override
    public void deleteAllDataGatherInfoId(String gatherId) {
        List<DsgGatherDbRecord> dbRecords = dsgGatherDBDao.findByCondition( DsgGatherDb.DSG_GATHER_DB.GATHER_ID.eq( gatherId ) );
        for (DsgGatherDbRecord dbRecord : dbRecords) {
            deleteTable( dbRecord.getId() );
            this.dsgGatherDBDao.delete( dbRecord );
        }
    }

    /**
     * 保存
     *
     * @param gatherDBTableFieldsVO
     */
    @Override
    public void saveGather(GatherDBTableFieldsVO gatherDBTableFieldsVO) {
        String gatherId = gatherDBTableFieldsVO.getGratherid();
        deleteAllDataGatherInfoId( gatherId );
        for (GatherDBVO dbvo : gatherDBTableFieldsVO.getGatherDBVOS()) {
            logger.info( "" + dbvo.getDbVO().getName() );
            List<DsgGatherDbRecord> dsgGatherDbRecords = this.saveDB( Collections.singletonList( dbvo.getDbVO() ), gatherId );
            for (GatherTableVO gatherTableVO : dbvo.getGatherTableVOS()) {
                logger.info( "\t\t\t" +  gatherTableVO.getTableVO() .getTable()  );
                List<DsgGatherTableRecord> tableRecords =
                        this.saveTable( Collections.singletonList( gatherTableVO.getTableVO() ), dsgGatherDbRecords.get( 0 ).getId() );
                this.saveTableFields( gatherTableVO.getTableFieldsVOS(), tableRecords.get( 0 ).getId() );
            }
        }

    }
}