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
import com.yookue.mavenplugin.javadocdocent.util.JavadocContentUtils;


/**
 * An inline taglet that representing {@code {@dtdd}} tag
 *
 * <pre><code>
 *     {&#64;dtdd "title" "content"}
 * </code></pre>
 * represents
 * <pre><code>
 *     &lt;dt&gt;
 *         title
 *     &lt;/dt&gt;
 *     &lt;dd&gt;
 *         content
 *     &lt;/dd&gt;
 * </code></pre>
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public class DtddTaglet extends AbstractInlineTaglet {
    private static final String TAG_NAME = "dtdd";    //$NON-NLS-1$

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
    @SuppressWarnings("DuplicatedCode")
    public String toString(@Nullable Tag tag) {
        if (tag == null || StringUtils.isBlank(tag.text())) {
            return null;
        }
        String[] args = StringUtils.split(tag.text(), StringUtils.SPACE);
        String title = JavadocContentUtils.unquote(ArrayUtils.get(args, 0));
        String content = JavadocContentUtils.unquote(ArrayUtils.get(args, 1));
        ContentBuilder result = JavadocContentUtils.dtDd(title, content);
        return result == null ? null : result.toString();
    }

    /**
     * Register this taglet
     *
     * @param taglets the map to register this taglet to
     */
    public static void register(@Nonnull Map<String, Taglet> taglets) {
        taglets.remove(TAG_NAME);
        taglets.put(TAG_NAME, new DtddTaglet());
    }
}
