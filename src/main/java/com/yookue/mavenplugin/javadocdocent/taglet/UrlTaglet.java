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

package com.yookue.mavenplugin.javadocdocent.taglet;


import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import jakarta.annotation.Nonnull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.UnknownInlineTagTree;
import com.yookue.mavenplugin.javadocdocent.util.JavadocContentUtils;


/**
 * An inline taglet that representing {@code {@url}} tag
 *
 * <pre><code>
 *     {&#64;url "href" ["content"]}
 * </code></pre>
 * represents
 * <pre><code>
 *     &lt;a href="href" target="_blank"&gt;content&lt;/a&gt;
 * </code></pre>
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public class UrlTaglet extends AbstractInlineTaglet {
    private static final String TAG_NAME = "url";    // $NON-NLS-1$

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
    public String toString(@Nonnull List<? extends DocTree> tags, @Nonnull Element element) {
        if (tags.isEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (DocTree tag : tags) {
            if (!(tag instanceof UnknownInlineTagTree tree)) {
                continue;
            }
            String[] args = StringUtils.split(tree.getContent().toString(), StringUtils.SPACE);
            String href = JavadocContentUtils.unquote(ArrayUtils.get(args, 0));
            String content = JavadocContentUtils.unquote(ArrayUtils.get(args, 1));
            String a = JavadocContentUtils.aOpeningBlank(href, content);
            if (StringUtils.isNotBlank(a)) {
                result.add(a);
            }
        }
        return result.isEmpty() ? null : StringUtils.join(result, StringUtils.EMPTY);
    }
}
