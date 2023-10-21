package tests.data

import com.j256.ormlite.stmt.PreparedQuery
import ru.ekazantsev.nsd_sdk_data.dto.Attribute
import ru.ekazantsev.nsd_sdk_data.dto.AttributeType

import static tests.TestUtils.*

PreparedQuery<Attribute> query = db.attributeDao.queryBuilder().where().eq("type", AttributeType.OBJECT).prepare()
Attribute attr =  db.attributeDao.queryForFirst(query)
logger.info(attr.relatedMetaClass)