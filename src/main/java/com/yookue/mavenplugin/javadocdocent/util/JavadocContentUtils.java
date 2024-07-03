/*
 * Copyright (c) 2024 Yookue Ltd. All rights reserved.
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

package com.yookue.mavenplugin.javadocdocent.util;


import jakarta.annotation.Nullable;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * Utilities for javadoc content
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JavadocContentUtils {
    private static final String A_BLANK = "<a href=\"%s\" target=\"_blank\">%s</a>";    // $NON-NLS-1$
    private static final String DT_DD = "<dt>%s</dt><dd>%s</dd>";    // $NON-NLS-1$
    private static final String SPAN_SIMPLE = "<span class=\"simpleTagLabel\">%s</span>";    // $NON-NLS-1$
    private static final String TABLE = "<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">%s</table>";    // $NON-NLS-1$
    private static final String TR_TD = "<tr><td>%s</td></tr>";    // $NON-NLS-1$

    @Nullable
    public static String aOpeningBlank(@Nullable String href) {
        return aOpeningBlank(href, null);
    }

    @Nullable
    public static String aOpeningBlank(@Nullable String href, @Nullable String content) {
        return StringUtils.isBlank(href) ? null : String.format(A_BLANK, HtmlTreeUtils.encodeUrl(href), StringUtils.defaultIfBlank(content, href));
    }

    @Nullable
    public static String dtDd(@Nullable String dtTitle, @Nullable String ddContent) {
        return StringUtils.isAllBlank(dtTitle, ddContent) ? null : String.format(DT_DD, StringUtils.defaultString(dtTitle), StringUtils.defaultString(ddContent));
    }

    @Nullable
    public static String dtSpanDdTable(@Nullable String dtTitle, @Nullable String tabSubset) {
        if (StringUtils.isAllBlank(dtTitle, tabSubset)) {
            return null;
        }
        return dtDd(String.format(SPAN_SIMPLE, StringUtils.defaultString(dtTitle)), String.format(TABLE, StringUtils.defaultString(tabSubset)));
    }

    @Nullable
    public static String trTdAOpeningBlank(@Nullable String href, @Nullable String text) {
        String a = aOpeningBlank(href, text);
        return StringUtils.isBlank(a) ? null : String.format(TR_TD, a);
    }

    public static String unquote(@Nullable String text) {
        return RegExUtils.replaceAll(text, "^['\"`]|['\"`]$", StringUtils.EMPTY);    // $NON-NLS-1$
    }
}
