package tests

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.ekazantsev.nsd_sdk_data.DbAccess

class TestUtils {
    static Logger logger = LoggerFactory.getLogger(getClass())
    static DbAccess db = DbAccess.getInstance()
}
