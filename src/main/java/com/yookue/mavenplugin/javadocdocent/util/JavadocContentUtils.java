/*
 * Copyright (c) 2021 Yookue Ltd. All rights reserved.
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


import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import com.sun.tools.doclets.formats.html.markup.ContentBuilder;
import com.sun.tools.doclets.formats.html.markup.HtmlAttr;
import com.sun.tools.doclets.formats.html.markup.HtmlStyle;
import com.sun.tools.doclets.formats.html.markup.HtmlTree;
import com.sun.tools.doclets.formats.html.markup.RawHtml;
import com.sun.tools.doclets.formats.html.markup.StringContent;
import com.sun.tools.doclets.internal.toolkit.Content;


/**
 * Utilities for {@link com.sun.tools.doclets.internal.toolkit.Content}
 *
 * @author David Hsing
 * @see com.sun.tools.doclets.internal.toolkit.Content
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JavadocContentUtils {
    @Nullable
    public static HtmlTree aOpeningBlank(@Nullable String href) {
        return aOpeningBlank(href, null);
    }

    @Nullable
    public static HtmlTree aOpeningBlank(@Nullable String href, @Nullable String content) {
        if (StringUtils.isBlank(href)) {
            return null;
        }
        HtmlTree result = HtmlTree.A(href, new StringContent(StringUtils.defaultIfBlank(content, href)));
        result.addAttr(HtmlAttr.TARGET, "_blank");    // $NON-NLS-1$
        return result;
    }

    @Nullable
    public static ContentBuilder dtDd(@Nullable String dtTitle, @Nullable String ddContent) {
        if (StringUtils.isAllBlank(dtTitle, ddContent)) {
            return null;
        }
        ContentBuilder result = new ContentBuilder();
        Content title = hasRawHtml(dtTitle) ? new RawHtml(dtTitle) : new StringContent(StringUtils.defaultString(dtTitle));
        Content content = hasRawHtml(ddContent) ? new RawHtml(ddContent) : new StringContent(StringUtils.defaultString(ddContent));
        result.addContent(HtmlTree.DT(title));
        result.addContent(HtmlTree.DD(content));
        return result;
    }

    @Nullable
    public static ContentBuilder dtSpanDdTable(@Nullable String dtTitle, @Nullable Content tabSubset) {
        return dtSpanDdTable(dtTitle, tabSubset, null);
    }

    @Nullable
    public static ContentBuilder dtSpanDdTable(@Nullable String dtTitle, @Nullable Content tabSubset, @Nullable String tabSummary) {
        if (tabSubset == null || tabSubset.isEmpty()) {
            return null;
        }
        ContentBuilder result = new ContentBuilder();
        Content title = hasRawHtml(dtTitle) ? new RawHtml(dtTitle) : new StringContent(StringUtils.defaultString(dtTitle));
        result.addContent(HtmlTree.DT(HtmlTree.SPAN(HtmlStyle.simpleTagLabel, title)));
        result.addContent(HtmlTree.DD(HtmlTree.TABLE(null, 0, 2, 0, StringUtils.defaultString(tabSummary), tabSubset)));
        return result;
    }

    @Nullable
    public static HtmlTree trTdAOpeningBlank(@Nullable String href, @Nullable String content) {
        HtmlTree a = aOpeningBlank(href, content);
        return a == null ? null : HtmlTree.TR(HtmlTree.TD(a));
    }

    public static boolean hasRawHtml(@Nullable String text) {
        return StringUtils.isNotBlank(text) && Pattern.compile("<[^>]+>").matcher(text).find();    // $NON-NLS-1$
    }

    public static String unquote(@Nullable String text) {
        return RegExUtils.replaceAll(text, "^['\"`]|['\"`]$", StringUtils.EMPTY);    // $NON-NLS-1$
    }
}
