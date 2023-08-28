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

package com.yookue.mavenplugin.javadocdocent.taglet;


import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;
import com.sun.tools.doclets.formats.html.markup.ContentBuilder;
import com.sun.tools.doclets.formats.html.markup.HtmlTag;
import com.sun.tools.doclets.formats.html.markup.HtmlTree;
import com.yookue.mavenplugin.javadocdocent.util.JavadocContentUtils;
import com.yookue.mavenplugin.javadocdocent.util.JavadocDocletUtils;
import com.yookue.mavenplugin.javadocdocent.util.ResourceBundleUtils;


/**
 * A block taglet that representing {@code @reference} tag
 *
 * <pre><code>
 *     &#64;reference "href" ["content"]
 * </code></pre>
 * represents
 * <pre><code>
 *     &lt;dt&gt;
 *         &lt;span class="simpleTagLabel&gt;Reference:&lt;/span&gt;
 *     &lt;/dt&gt;
 *     &lt;dd&gt;
 *         &lt;table border="0" cellpadding="2" cellspacing="0"&gt;
 *             &lt;tr&gt;&lt;td&gt;&lt;a href="href" target="_blank"&gt;content&lt;/a&gt;&lt;/td&gt;&lt;/tr&gt;
 *         &lt;/table&gt;
 *     &lt;/dd&gt;
 * </code></pre>
 *
 * @author David Hsing
 * @reference "https://github.com/Broele/ReferenceTaglet/"
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue", "JavadocDeclaration", "JavadocLinkAsPlainText"})
public class ReferenceTaglet extends AbstractBlockTaglet {
    private static final String TAG_NAME = "reference";    //$NON-NLS-1$
    private static final String TAG_TITLE = "Reference:";    //$NON-NLS-1$

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return TAG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("ConstantConditions")
    public String toString(@Nullable Tag[] tags) {
        if (ArrayUtils.isEmpty(tags)) {
            return null;
        }
        HtmlTree tbody = new HtmlTree(HtmlTag.TBODY);
        for (Tag tag : tags) {
            if (tag == null || StringUtils.isBlank(tag.text())) {
                continue;
            }
            String[] args = StringUtils.split(tag.text(), StringUtils.SPACE);
            String href = JavadocContentUtils.unquote(ArrayUtils.get(args, 0));
            String content = JavadocContentUtils.unquote(ArrayUtils.get(args, 1));
            HtmlTree tr = JavadocContentUtils.trTdAOpeningBlank(href, content);
            if (tr != null) {
                tbody.addContent(tr);
            }
        }
        if (!tbody.hasContent()) {
            return null;
        }
        String title = ResourceBundleUtils.getTagletMessage(JavadocDocletUtils.getHtmlDocletLocale(), "Taglet.reference", TAG_TITLE);    //$NON-NLS-1$
        ContentBuilder builder = JavadocContentUtils.dtSpanDdTable(title, tbody, TAG_NAME);
        return builder == null ? null : builder.toString();
    }

    /**
     * Register this taglet
     *
     * @param taglets the map to register this taglet to
     */
    public static void register(@Nonnull Map<String, Taglet> taglets) {
        taglets.remove(TAG_NAME);
        taglets.put(TAG_NAME, new ReferenceTaglet());
    }
}
