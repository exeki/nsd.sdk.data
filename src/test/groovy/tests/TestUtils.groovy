package tests

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.ekazantsev.nsd_sdk_data.DbAccess

class TestUtils {
    static Logger logger = LoggerFactory.getLogger(getClass())
    static DbAccess db = new DbAccess('C:\\Users\\ekazantsev\\nsd_sdk\\data\\sdk_meta_store.mv.db')
}
