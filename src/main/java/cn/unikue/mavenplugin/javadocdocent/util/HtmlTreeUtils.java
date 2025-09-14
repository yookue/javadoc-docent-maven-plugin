/*
 * Copyright (c) 2023 Unikue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.unikue.mavenplugin.javadocdocent.util;


import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import jakarta.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;


/**
 * Utilities for javadoc HtmlTree
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class HtmlTreeUtils {
    private static final BitSet NONE_ENCODING_CHARS = new BitSet(256);

    static {
        // alphabetic characters
        for (int i = 'a'; i <= 'z'; i++) {
            NONE_ENCODING_CHARS.set(i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            NONE_ENCODING_CHARS.set(i);
        }
        // numeric characters
        for (int i = '0'; i <= '9'; i++) {
            NONE_ENCODING_CHARS.set(i);
        }
        // Reserved characters as per RFC 3986. These are set of delimiting characters
        String noEnc = ":/?#[]@!$&'()*+,;=";   // $NON-NLS-1$
        // Unreserved characters as per RFC 3986 which should not be percent encoded
        noEnc += "-._~";   // $NON-NLS-1$
        for (int i = 0; i < noEnc.length(); i++) {
            NONE_ENCODING_CHARS.set(noEnc.charAt(i));
        }
    }

    public static String encodeUrl(@Nullable String url) {
        if (StringUtils.isBlank(url)) {
            return url;
        }
        StringBuilder result = new StringBuilder();
        byte[] bytes = url.getBytes(StandardCharsets.UTF_8);
        for (byte i : bytes) {
            if (NONE_ENCODING_CHARS.get(i & 255)) {
                result.append((char) i);
            } else {
                result.append(String.format("%%%02X", i & 255));   // $NON-NLS-1$
            }
        }
        return result.toString();
    }
}
