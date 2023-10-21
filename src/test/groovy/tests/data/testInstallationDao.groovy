package tests.data

import ru.ekazantsev.nsd_sdk_data.dto.Installation
import static tests.TestUtils.*

Installation installation = new Installation()
installation.host = 'tetete1'

db.installationDao.create(installation)
logger.info(installation.id.toString())
logger.info(db.installationDao.queryForAll().collect{it.host}.join(', '))
