package util;

import org.apache.commons.codec.digest.DigestUtils;

public final class DataEncoder {

    public static String encode(String obj){
        return DigestUtils.sha1Hex(obj);
    }
}
