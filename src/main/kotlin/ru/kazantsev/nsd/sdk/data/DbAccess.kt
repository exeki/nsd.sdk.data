package ru.kazantsev.nsd.sdk.data

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.table.TableUtils
import ru.kazantsev.nsd.sdk.data.dto.*

/**
 * Класс, инициализирующий связь с базой и предоставляющий доступ к данным
 */
class DbAccess (dbFilePath: String) {

    val connectionString: String
    val connection: JdbcConnectionSource
    val installationDao: Dao<Installation, Long>
    val metaClassDao: Dao<MetaClass, Long>
    val attributeDao: Dao<Attribute, Long>
    val attributeGroupDao: Dao<AttributeGroup, Long>
    val attributeAndGroupLinkDao: Dao<AttributeAndGroupLink, Long>

    init {
        val length = dbFilePath.length
        if(dbFilePath.substring(length - 6, length) != ".mv.db") this.connectionString = dbFilePath
        else this.connectionString = dbFilePath.substring(0, length - 6)
        this.connection = JdbcConnectionSource("jdbc:h2:file:${this.connectionString}")
        TableUtils.createTableIfNotExists(this.connection, Installation::class.java)
        TableUtils.createTableIfNotExists(this.connection, MetaClass::class.java)
        TableUtils.createTableIfNotExists(this.connection, Attribute::class.java)
        TableUtils.createTableIfNotExists(this.connection, AttributeGroup::class.java)
        TableUtils.createTableIfNotExists(this.connection, AttributeAndGroupLink::class.java)
        this.installationDao = DaoManager.createDao(this.connection, Installation::class.java)
        this.metaClassDao = DaoManager.createDao(this.connection, MetaClass::class.java)
        this.attributeDao = DaoManager.createDao(this.connection, Attribute::class.java)
        this.attributeGroupDao = DaoManager.createDao(this.connection, AttributeGroup::class.java)
        this.attributeAndGroupLinkDao = DaoManager.createDao(this.connection, AttributeAndGroupLink::class.java)
    }
}