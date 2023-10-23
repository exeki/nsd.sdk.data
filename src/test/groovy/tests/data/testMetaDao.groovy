package tests.data

import static tests.TestUtils.*


db.metaClassDao.queryForEq("classCode", "serviceCall").fullCode.each {
    logger.info(it)
}
